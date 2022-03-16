package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {


    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "luiz.moraes@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessage(PessoaDTO pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(pessoa.getEmail());
        message.setSubject("Olá " + pessoa.getNome());
        message.setText("Estamos felizes em ter você no nosso sistema :)\nSeu cadastro foi realizado com sucesso, seu identificador é "+ pessoa.getIdPessoa() + "\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail " + from + "\n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(MAIL_TO);
        helper.setSubject("TESTE");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");

        File file1 = new File("imagem.jpg");

        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }


    public void sendEmail(String email, String assunto, String mensagem) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(mensagem, true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailPessoa(PessoaDTO pessoa) {
            sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getCreatePersonTemplate(pessoa));
    }

    public void sendEmailUpdatePessoa(PessoaDTO pessoa) {
        sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getUpdatePersonTemplate(pessoa));
    }

    public void sendEmailDeletePessoa(PessoaDTO pessoa) {
        sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getDeletePersonTemplate(pessoa));
    }



    public String getPersonTemplate(String nome, Integer id, String templateHTML) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome);
        dados.put("id", id);
        dados.put("from", from);
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        Template template = fmConfiguration.getTemplate(templateHTML);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getCreatePersonTemplate(PessoaDTO pessoa) {
        try {
           return getPersonTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUpdatePersonTemplate(PessoaDTO pessoa) {
        try {
            return getPersonTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template-update.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDeletePersonTemplate(PessoaDTO pessoa) {
        try {
            return getPersonTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template-delete.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }


}
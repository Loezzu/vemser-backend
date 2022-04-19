package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.EmailDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Autowired
    private PessoaRepository pessoaRepository;

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "luiz.moraes@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;


    public void sendSimpleEmail(EmailDTO emailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(emailDTO.getDestinatario());
        message.setSubject(emailDTO.getAssunto());
        message.setText(emailDTO.getTexto());
        emailSender.send(message);
    }

    public void sendSimpleMessage(PessoaDTO pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Olá, " + pessoa.getNome() + ",");
        message.setText("Olá " + pessoa.getNome() + "\n\nEstamos muito felizes que você está em nosso sistema." +
                        "\nPara que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro." +
                        "\nMuito obrigado,\nSistema de Pessoas");
        emailSender.send(message);
    }

    public void sendSimpleMessageTodos(PessoaDTO pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Ofertas");
        message.setText("Ola " + pessoa.getNome() + "!\n\n" +
                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa plataforma especialmente para você:\n" +
                "- Na compra de um CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." + "\n" +
                "- Na locação de um filme em VHS, a outra locação é grátis." + "\n" +
                "- Fita de Super Nintendo com 50% de desconto." + "\n\n" +
                "Aproveite,\n" +
                "Magazine OldSchool.");
        emailSender.send(message);
    }

    public void sendSimpleMessageAniversariante(PessoaDTO pessoa, Integer idade) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Aniversariante");
        message.setText("Olá " + pessoa.getNome() +
                "\n\nEssa data de " + pessoa.getDataNascimento().getDayOfMonth() + "/" + pessoa.getDataNascimento().getMonthValue() +  " também é especial para nós do " +
                "Vem Ser. Estamos comemorando junto com você. " +
                "\nDesejamos um feliz aniversário, que sejam " + idade + " anos de muitos. Sucesso, alegria, " +
                "felicidade e muitas realizações." +
                "\n\nForte abraço,\n" +
                "VemSerDBC |!");
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


    public void sendEmailEndereco(PessoaDTO pessoa, EnderecoDTO endereco) {
        sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getCreateAddressTemplate(pessoa, endereco));
    }

    public void sendEmailUpdateEndereco(PessoaDTO pessoa, EnderecoDTO endereco) {
        sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getUpdateAddressTemplate(pessoa, endereco));
    }


    public void sendEmailDeleteEndereco(PessoaDTO pessoa, EnderecoDTO endereco) {
        sendEmail(pessoa.getEmail(), "Olá, " + pessoa.getNome() + "!" , getDeleteAddressTemplate(pessoa, endereco));
    }



    public String getTemplate(String nome, Integer id, String templateHTML) throws IOException, TemplateException {
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
           return getTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUpdatePersonTemplate(PessoaDTO pessoa) {
        try {
            return getTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template-update.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDeletePersonTemplate(PessoaDTO pessoa) {
        try {
            return getTemplate(pessoa.getNome(), pessoa.getIdPessoa(), "email-template-delete.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getCreateAddressTemplate(PessoaDTO pessoa, EnderecoDTO endereco) {
        try {
            return getTemplate(pessoa.getNome(), endereco.getIdEndereco(), "email-template.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUpdateAddressTemplate(PessoaDTO pessoa, EnderecoDTO endereco) {
        try {
            return getTemplate(pessoa.getNome(), endereco.getIdEndereco(), "email-template-update.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDeleteAddressTemplate(PessoaDTO pessoa, EnderecoDTO endereco) {
        try {
            return getTemplate(pessoa.getNome(), endereco.getIdEndereco(), "email-template-delete.ftl");

        } catch ( IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

}
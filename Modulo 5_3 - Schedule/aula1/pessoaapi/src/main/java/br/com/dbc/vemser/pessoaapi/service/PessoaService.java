package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;



    @Scheduled(cron = "0 0 8 * * *")
    public void envioDeEmailAosAniversariantes() {
        log.info("enviando email aos aniversariantes");
        LocalDate dataAtual = LocalDate.now();
        pessoaRepository.findAniversariantesDoDia().stream()
                .forEach(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    Integer anoNascimento = pessoaDTO.getDataNascimento().getYear();
                    Integer anoAtual = dataAtual.getYear();
                    Integer idade = anoAtual - anoNascimento;
                    emailService.sendSimpleMessageAniversariante(pessoaDTO, idade);
                });
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void envioDeEmailUmaVezAoMes(){
        log.info("enviando email uma vez ao mes");
        pessoaRepository.findAll()
                .stream()
                .forEach(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    emailService.sendSimpleMessageTodos(pessoaDTO);
                });
    }

    @Scheduled(cron = "0 0 8,20 * * *")
    public void envioDeEmailParaQuemNaoPossuiEndereco(){
        log.info("enviando email para que nao possui endereço as 8:00 e 20:00");
        pessoaRepository.findQueNaoPossuemEndereco().stream()
                .forEach(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    emailService.sendSimpleMessage(pessoaDTO);
                });
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("chamando o método create");

      PessoaEntity pessoa = objectMapper.convertValue(pessoaCreate, PessoaEntity.class);

      PessoaEntity pessoaCriada = pessoaRepository.save(pessoa);

      PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

//      emailService.sendEmailPessoa(pessoaDTO);

       return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        log.info("chamando o método list");
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaEntity findById(Integer idPessoa) throws RegraDeNegocioException {
        return this.pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }


    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("chamando o método update");

        PessoaEntity pessoa = objectMapper.convertValue(pessoaAtualizar, PessoaEntity.class);

        PessoaEntity atualizarPessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        atualizarPessoa.setNome(pessoa.getNome());
        atualizarPessoa.setCpf(pessoa.getCpf());
        atualizarPessoa.setDataNascimento(pessoa.getDataNascimento());
        atualizarPessoa.setEmail(pessoa.getEmail());

        PessoaEntity pessoaAtualizada = pessoaRepository.save(atualizarPessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);

//        emailService.sendEmailUpdatePessoa(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        log.warn("chamando o método delete");
        pessoaRepository.deleteById(id);
    }


    public List<PessoaDTOComContatos> listarPessoasComContatos(Integer idPessoa) throws Exception {
        List<PessoaDTOComContatos> pessoasDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoasDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoasDTOList.add(pessoaDTO);
        }
        return pessoasDTOList;
    }

    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(Integer idPessoa) throws Exception {
        List<PessoaDTOComEnderecos> pessoasDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoasDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoasDTOList.add(pessoaDTO);
        }
        return pessoasDTOList;
    }

    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecoEContatos(Integer idPessoa) throws Exception {
        List<PessoaDTOComEnderecosEContatos> pessoasDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoasDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(this::retornarPessoaComEnderecoEContatos).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            pessoasDTOList.add(retornarPessoaComEnderecoEContatos(pessoaEntity));
        }
        return pessoasDTOList;
    }


    public List<PessoaDTOComEnderecosEContatos> listarPessoaComEnderecoEContatosPorNome(String nome)  {
          List<PessoaDTOComEnderecosEContatos> pessoasDTOList = new ArrayList<>();

          pessoasDTOList.addAll(pessoaRepository.findByNomeContainingIgnoreCase(nome).stream()
                  .map(this::retornarPessoaComEnderecoEContatos).toList()
          );
          return pessoasDTOList;
    }

    public List<PessoaDTOComEnderecosEContatos> listarPessoaComEnderecoEContatosQuePossuemEndereco(){
        List<PessoaDTOComEnderecosEContatos> pessoasDTOList = new ArrayList<>();

        pessoasDTOList.addAll(pessoaRepository.findByPessoasQuePossuemEnderecos().stream()
                .map(this::retornarPessoaComEnderecoEContatos).toList()
        );
        return pessoasDTOList;
    }

    public List<PessoaDTO> aniversariantesDoDia(){
       return pessoaRepository.findAniversariantesDoDia().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


    public List<PessoaDTOComEnderecosEContatos> listarPessoaComEnderecoEContatosQueNaoPossuemEndereco(){
        List<PessoaDTOComEnderecosEContatos> pessoasDTOList = new ArrayList<>();

        pessoasDTOList.addAll(pessoaRepository.findQueNaoPossuemEndereco().stream()
                .map(this::retornarPessoaComEnderecoEContatos).toList()
        );


        return pessoasDTOList;
    }


    private PessoaDTOComEnderecosEContatos retornarPessoaComEnderecoEContatos(PessoaEntity pessoaEntity) {
        PessoaDTOComEnderecosEContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecosEContatos.class);
        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList())
        );
        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList())
        );
        return pessoaDTO;
    }

}

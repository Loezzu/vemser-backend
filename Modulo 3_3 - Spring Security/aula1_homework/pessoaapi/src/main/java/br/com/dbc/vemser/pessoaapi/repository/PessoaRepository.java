package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal);

    @Query("SELECT p FROM PESSOA p WHERE p.dataNascimento BETWEEN :dataNascimentoInicial AND :dataNascimentoFinal")
    List<PessoaEntity> findByDataNascimento(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal);

    @Query("SELECT p FROM PESSOA p JOIN FETCH p.enderecos")
    List<PessoaEntity> findByPessoasQuePossuemEnderecos();

    @Query(value = "SELECT * FROM PESSOA p FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON p.ID_PESSOA = pxpe.ID_PESSOA WHERE ID_ENDERECO IS NULL", nativeQuery = true)
    List<PessoaEntity> findQueNaoPossuemEndereco();
//
//    @Query("SELECT e FROM ENDERECO_PESSOA e JOIN FETCH e.pessoas p WHERE p.idPessoa = :idPessoa")
//    List<EnderecoEntity> findByIdPessoa(Integer idPessoa);
}

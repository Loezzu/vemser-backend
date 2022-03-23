package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("SELECT e FROM ENDERECO_PESSOA e WHERE e.pais = :pais")
    List<EnderecoEntity> findByPais(String pais);

    @Query("SELECT e FROM ENDERECO_PESSOA e JOIN FETCH e.pessoas p WHERE p.idPessoa = :idPessoa")
    List<EnderecoEntity> findByIdPessoa(Integer idPessoa);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA WHERE CIDADE = :cidade OR PAIS = :pais", nativeQuery = true)
    List<EnderecoEntity> findByCidadeOrPais(String cidade, String pais);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA WHERE COMPLEMENTO IS NULL", nativeQuery = true)
    List<EnderecoEntity> findSemComplemento();

}

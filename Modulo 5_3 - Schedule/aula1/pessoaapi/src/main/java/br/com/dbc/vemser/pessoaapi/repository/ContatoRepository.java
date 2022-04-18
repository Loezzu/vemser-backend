package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository  extends JpaRepository<ContatoEntity, Integer> {


    @Query("SELECT c FROM CONTATO c WHERE c.tipoContato = :tipoContato")
    List<ContatoEntity> findByTipoContato(TipoContato tipoContato);

    @Query(value = "SELECT * FROM CONTATO c WHERE c.ID_PESSOA = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findByidPessoa(Integer idPessoa);



}





















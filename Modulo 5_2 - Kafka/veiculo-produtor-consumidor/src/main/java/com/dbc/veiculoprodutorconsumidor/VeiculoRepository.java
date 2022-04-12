package com.dbc.veiculoprodutorconsumidor;

import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {
    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum' : {'$sum': $velocidade} }}"
    })
    Double findVelocidadeTotal();

    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum' : {'$sum': $rotacao} }}"
    })
    Double findRotacaoTotal();
}

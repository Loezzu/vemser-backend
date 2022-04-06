import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Projections.*;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("tindev");

        MongoCollection<Document> users = mongoDatabase.getCollection("tindev_user");

        Document luiz = new Document("nome", "Luiz")
                .append("progLang", "JAVA")
                .append("gender", "MALE")
                .append("pref", "WOMEN")
                .append("personInfo", new Document("age", 20)
                        .append("email", "luiz@mail.com"));

        Document guilherme = new Document("nome", "Guilherme")
                .append("progLang", "JAVA")
                .append("gender", "MALE")
                .append("pref", "BOTH")
                .append("personInfo", new Document("age", 25)
                        .append("email", "guilherme@mail.com"));

        Document rafael = new Document("nome", "Rafael")
                .append("progLang", "JAVASCRIPT")
                .append("gender", "MALE")
                .append("pref", "MAN")
                .append("personInfo", new Document("age", 25)
                        .append("email", "rafael@mail.com"));

        Document maria = new Document("nome", "Maria")
                .append("progLang", "PHP")
                .append("gender", "FEMALE")
                .append("pref", "MAN")
                .append("personInfo", new Document("age", 25)
                        .append("email", "maria@mail.com"));

//         Insere usuarios
//         users.insertMany(asList(luiz, guilherme, rafael, maria));


        //Atualiazar proglang do rafael
//         users.updateOne(Filters.eq("nome", "Rafael"), new Document("$set", new Document("progLang" , "PHP")));



        //listar usuarios
//        users.find().forEach(System.out::println);

        // Busca usuario por nome
//        System.out.println("-- Aluno");
//        Document user = users.find(new Document("nome" , "Luiz")).first();
//        System.out.println(user);


//        System.out.println("-- Busca usuarios que gostam de programar em java");
//        FindIterable<Document> buscarUsers = users.find(in("progLang", "JAVA"));
//        for (Document busca : buscarUsers) {
//            System.out.println(busca);
//        }


        //Deletar por nome
//        users.deleteOne(Filters.eq("nome" , "Rafael"));

        //DELETAR TUDO
//        DeleteResult deleteMany = users.deleteMany(new Document());



        //quantidade de usuarios por progLang Java
//        users.aggregate(Arrays.asList(
//                match(Filters.eq("progLang", "JAVA")),
//                group("$progLang", Accumulators.sum("qtd", 1))))
//                .forEach(doc -> System.out.println(doc.toJson()));

//        //soma de idade da proglang java
//        users.aggregate(Arrays.asList(
//                        match(Filters.eq("progLang", "JAVA")),
//                        group("$progLang", Accumulators.sum("idadeSoma", "$personInfo.age"))))
//                        .forEach(doc -> System.out.println(doc.toJson()));


//        Bson filter = Filters.empty();
//        Bson projection = fields(include("nome", "progLang"), exclude("_id"));
//        users.find(filter).projection(projection).forEach(doc -> System.out.println(doc.toJson()));


        mongoClient.close();
    }
}

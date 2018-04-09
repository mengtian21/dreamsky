package com.travle.dreamsky.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;
@Configuration
@PropertySource(value = "classpath:/config/mongodb.yml")
public class MongoDbConfig {
    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongoClient(){
        String username = env.getProperty("mongousername");
        String password = env.getProperty("password");
        String database = env.getProperty("database");
        String host = env.getProperty("host");
        Integer port = Integer.parseInt(env.getProperty("port"));

        System.out.println("--------------"+username);
        System.out.println("--------------"+password);
        System.out.println("--------------"+database);
        System.out.println("--------------"+host);
        System.out.println("--------------"+port);
        ServerAddress serverAddress = new ServerAddress(host,port);
        MongoCredential mongoCredential = MongoCredential.createCredential(username,database,password.toCharArray());
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        mongoCredentialList.add(mongoCredential);

        System.out.println("--------------"+username);
        System.out.println("--------------"+password);
        System.out.println("--------------"+database);
        System.out.println("--------------"+host);
        System.out.println("--------------"+port);
        return new MongoClient(serverAddress,mongoCredentialList);
    }

    @Bean
    public MongoDbFactory mongoDbFactory(){
        String database = env.getProperty("database");

        return new SimpleMongoDbFactory(mongoClient(),database);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;
    }
}

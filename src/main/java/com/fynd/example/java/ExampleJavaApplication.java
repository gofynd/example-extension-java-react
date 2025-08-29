package com.fynd.example.java;

import com.fynd.extension.model.Extension;
import com.fynd.extension.model.ExtensionCallback;
import com.fynd.extension.model.ExtensionProperties;
import com.fynd.extension.session.Session;
import com.fynd.extension.storage.MultiLevelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.JedisPool;
import com.mongodb.client.MongoDatabase;
import com.fynd.example.java.config.RedisConfig;
import com.fynd.example.java.config.MongoConfig;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fynd.**","com.sdk.**"})
@Import({RedisConfig.class, MongoConfig.class})
public class ExampleJavaApplication {

    private static final String REDIS_KEY = "ext_sample";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ExtensionProperties extensionProperties;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    MongoDatabase mongoDatabase;

    ExtensionCallback callbacks = new ExtensionCallback((request) -> {
        Session fdkSession = (Session) request.getAttribute("session");
        logger.debug("In Auth callback");
        if(request.getParameter("application_id") != null){
            return extensionProperties.getBaseUrl() + "/company/" + fdkSession.getCompanyId() + "/application/" + request.getParameter("application_id");
        }
        else {
            return extensionProperties.getBaseUrl() + "/company/" + fdkSession.getCompanyId();
        }
    }, (context) -> {
        logger.info("In install callback");
        return  extensionProperties.getBaseUrl();

    }, (fdkSession) -> {
        logger.info("In uninstall callback");
        return extensionProperties.getBaseUrl();

    }, (fdkSession) -> {
        logger.info("In auto-install callback");
        return extensionProperties.getBaseUrl();
    });

    public static void main(String[] args) {
        SpringApplication.run(ExampleJavaApplication.class, args);
    }

    @Bean
    public com.fynd.extension.model.Extension getExtension() throws ClassNotFoundException {
        Extension extension = new Extension();
        Map<String, String> options = new HashMap<>();
        // Add any required options to the map
        return extension.initialize(
                extensionProperties,
                new MultiLevelStorage(jedisPool, mongoDatabase, REDIS_KEY, options),
                callbacks
        );
    }

}
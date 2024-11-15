package com.example.demo.service;

import com.example.demo.model.MovieEntity;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Neo4jService {

    private final Driver driver;

    @Autowired
    public Neo4jService(Driver driver) {
        this.driver = driver;
    }

    public boolean isConnected() {
        try (Session session = driver.session()) {
            session.run("RETURN 1");
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

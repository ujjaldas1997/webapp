package com.webapp.webapp.repositories;

import com.webapp.webapp.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
}

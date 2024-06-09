package com.infnet.tp3spring.repositories;

import com.infnet.tp3spring.models.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}

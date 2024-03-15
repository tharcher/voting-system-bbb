package me.ms.config;

import me.ms.model.VotingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotingConfig extends MongoRepository<VotingModel, String> {
}

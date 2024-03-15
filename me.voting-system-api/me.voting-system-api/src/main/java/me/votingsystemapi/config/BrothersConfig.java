package me.votingsystemapi.config;


import me.votingsystemapi.model.BrothersModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrothersConfig extends MongoRepository<BrothersModel, String> {
}

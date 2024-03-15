package me.votingsystemapi.config;

import me.votingsystemapi.model.ReferencesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReferencesConfig extends MongoRepository<ReferencesModel, String> {
}

package me.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ms.config.VotingConfig;
import me.ms.model.BrothersModel;
import me.ms.model.VotingModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotingService {
    private final VotingConfig config;

    @KafkaListener(topics = "voting", groupId = "VotingMicroservice")
    private void exec(ConsumerRecord<String, String> register) {
        String brotherStr = register.value();
        log.info("Voto para o participante {}", brotherStr);

        ObjectMapper mapper = new ObjectMapper();
        BrothersModel brother = null;

        try {
            brother = mapper.readValue(brotherStr, BrothersModel.class);
        } catch (JsonProcessingException error) {
            log.error("Falha na conversão [{}]", brotherStr, error);
            return;
        }

        VotingModel voting = new VotingModel(null, brother, new Date());
        VotingModel entity = config.save(voting);

        log.info("Voto computado [id={}, dateTime={}]", entity.getId(), entity.getDateTime());
    }
}

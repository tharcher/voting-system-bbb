package me.votingsystemapi.config.service;

import lombok.AllArgsConstructor;
import me.votingsystemapi.model.BrothersModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotingService {
    private final KafkaTemplate<Object, Object> template;
    private static final String TOPIC_VOTING = "voting";
    public void addEvent(BrothersModel brother){
        template.send(TOPIC_VOTING, brother);
    }
}

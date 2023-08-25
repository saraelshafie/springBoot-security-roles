package com.vodafone.authorization.rolebasedcourse.Services;

import com.vodafone.authorization.rolebasedcourse.Model.Topic;
import com.vodafone.authorization.rolebasedcourse.Repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Optional<Topic> getTopicById(Integer id) {
        return topicRepository.findById(id);
    }
}

package com.vodafone.authorization.rolebasedcourse.Controllers;

import com.vodafone.authorization.rolebasedcourse.Model.Topic;
import com.vodafone.authorization.rolebasedcourse.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired  //marks the variable as smthg that needs dependency injection
    private TopicService topicService;

    @GetMapping("/user/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/user/topics/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Optional<Topic> getTopicById(@PathVariable Integer id){
        return topicService.getTopicById(id);
    }

    @PutMapping("/devTeam/updateTopic")
    @PreAuthorize("hasAnyAuthority('ADMIN','DEV')")
    public ResponseEntity<String> updateTopic(@RequestBody Topic topic){
        System.out.println("IN METHOD CONTROLLER");
        topicService.updateTopic(topic);
        return new ResponseEntity<>("Topic updated", HttpStatus.OK);
    }

    @PostMapping("/admin/addTopic")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return new ResponseEntity<>("Topic added", HttpStatus.OK);
    }
}

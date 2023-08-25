package com.vodafone.authorization.rolebasedcourse.Repositories;

import com.vodafone.authorization.rolebasedcourse.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository<Topic, Integer> {
}

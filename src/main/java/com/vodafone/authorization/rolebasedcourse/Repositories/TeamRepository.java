package com.vodafone.authorization.rolebasedcourse.Repositories;

import com.vodafone.authorization.rolebasedcourse.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    Optional<Team> findByName(String name);
}

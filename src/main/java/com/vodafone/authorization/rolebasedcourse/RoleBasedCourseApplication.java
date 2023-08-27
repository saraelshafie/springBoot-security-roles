package com.vodafone.authorization.rolebasedcourse;

import com.vodafone.authorization.rolebasedcourse.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.support.Repositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RoleBasedCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedCourseApplication.class, args);
	}

}

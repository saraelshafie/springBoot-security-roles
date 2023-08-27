package com.vodafone.authorization.rolebasedcourse.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "id") // This indicates the foreign key column in the Role table
//    private Team team;

}

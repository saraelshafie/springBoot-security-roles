package com.vodafone.authorization.rolebasedcourse.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL) //eager means whenever user loads its roles will be shown
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id" , referencedColumnName = "id") // This indicates the foreign key column in the User table
    private Team team;


}

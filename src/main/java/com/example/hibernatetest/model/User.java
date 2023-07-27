package com.example.hibernatetest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Zhurenkov Pavel 21.07.2023
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_active")
    private Boolean active;

    @JsonManagedReference
    //@JsonSerialize(using = CustomListSerializer.class)
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id")
    @OneToMany(mappedBy = "user")
    private List<Role> roles;

}

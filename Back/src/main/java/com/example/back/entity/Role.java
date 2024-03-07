package com.example.back.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int roleId;

    @Column(name="role_name")
    private String roleName;
    @JsonIgnore
    @OneToMany(targetEntity=User.class, mappedBy="role",cascade=CascadeType.ALL, fetch = FetchType.LAZY)   
    private List<User> users;

}
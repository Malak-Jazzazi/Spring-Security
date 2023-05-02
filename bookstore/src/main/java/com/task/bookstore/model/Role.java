package com.task.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    private String description;
    @JsonIgnoreProperties("roles")
    @ManyToMany(mappedBy = "roles" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

}

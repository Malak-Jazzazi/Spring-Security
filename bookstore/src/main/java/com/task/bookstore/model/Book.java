package com.task.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String name;
    private String author;
    private String type;

    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "books" , cascade = CascadeType.ALL)
    private List<Store> stores = new ArrayList<>();
}

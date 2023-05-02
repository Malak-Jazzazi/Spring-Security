package com.task.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String location;

    private String notes;
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnoreProperties("stores")
    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    name = "store_book",
                    joinColumns = @JoinColumn(name = "store_id"),
                    inverseJoinColumns = @JoinColumn(name = "book_id")
            )
    private List<Book> books = new ArrayList<>();
}

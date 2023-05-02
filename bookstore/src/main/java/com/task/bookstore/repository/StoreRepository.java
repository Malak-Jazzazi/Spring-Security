package com.task.bookstore.repository;
import com.task.bookstore.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long> {
}

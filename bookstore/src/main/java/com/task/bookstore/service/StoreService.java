package com.task.bookstore.service;

import com.task.bookstore.model.Book;
import com.task.bookstore.model.Store;
import com.task.bookstore.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Book> getBookByStore(Long id) {

        try {
            Optional<Store> store = storeRepository.findById(id);
            if (store.isPresent()){
                return store.get().getBooks();
            }
        } catch (EntityNotFoundException e) {
            log.error("List of Books in Store ID {} not found", id);
        } catch (IllegalArgumentException e) {
            log.error("Invalid ID for Store: {}", id);
        } catch (PersistenceException e) {
            log.error("Error retrieving Store with ID {}", id, e);
        }
        return null;
    }

    public Store getStore(Long id) {
        try {
            return storeRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            log.error("Store ID {} not found", id);
        } catch (IllegalArgumentException e) {
            log.error("Invalid ID for Store: {}", id);
        } catch (PersistenceException e) {
            log.error("Error retrieving Store with ID {}", id, e);
        }
        return null;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}

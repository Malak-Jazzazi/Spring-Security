package com.task.bookstore.controller;

import com.task.bookstore.model.Book;
import com.task.bookstore.model.Store;
import com.task.bookstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getStores(){
        return new ResponseEntity<>(storeService.getAllStores() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable("id") Long id){
        return new ResponseEntity<>(storeService.getStore(id) , HttpStatus.OK);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByStoreId(@PathVariable("id") Long id){
        return new ResponseEntity<>(storeService.getBookByStore(id) , HttpStatus.OK);
    }
}

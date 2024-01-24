package com.vaniza.cm.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaniza.cm.domain.Category;
import com.vaniza.cm.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repo;

    public Category find(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> 
            new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()
            )
        );
    }
}

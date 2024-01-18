package com.vaniza.cm.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vaniza.cm.domain.Category;
import com.vaniza.cm.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Category obj = service.search(id);

		Category cat1 = new Category(1, "Software");
		Category cat2 = new Category(2, "Mouse");

		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);

		return ResponseEntity.ok().body(obj);
	}

}

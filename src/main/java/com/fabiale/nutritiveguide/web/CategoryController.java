package com.fabiale.nutritiveguide.web;

import java.util.List;

import javassist.NotFoundException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.nutritiveguide.model.Category;
import com.fabiale.nutritiveguide.repositories.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryRepository repository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> index() {
		return repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Category read(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> delete(@PathVariable("id") Integer id) throws NotFoundException {
		repository.delete(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@Valid @RequestBody(required = true) Category category) {
		repository.create(category);
		return new ResponseEntity<Category>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Integer id, @Valid @RequestBody(required = true) Category category) {
		repository.update(category);
	}
}

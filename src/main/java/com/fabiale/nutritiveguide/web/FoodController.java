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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.nutritiveguide.model.Food;
import com.fabiale.nutritiveguide.repositories.FoodRepository;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	@Autowired FoodRepository repository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Food> index() {
		return repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/filter/{name}/{maxResults}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> findByName(@RequestParam("name") String name, @RequestParam("maxResults") int maxResults) throws NotFoundException {
		return repository.findByName(name, maxResults);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Food read(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> delete(@PathVariable("id") Integer id) throws NotFoundException {
		repository.delete(id);
		return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Food> create(@Valid @RequestBody(required = true) Food food) {
		repository.create(food);
		return new ResponseEntity<Food>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Integer id, @Valid @RequestBody(required = true) Food category) {
		repository.update(category);
	}
}

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

import com.fabiale.nutritiveguide.model.Element;
import com.fabiale.nutritiveguide.repositories.ElementRepository;

@Controller
@RequestMapping("/element")
public class ElementController {
	
	@Autowired ElementRepository repository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Element> index() {
		return repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Element read(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Element> delete(@PathVariable("id") Integer id) throws NotFoundException {
		repository.delete(id);
		return new ResponseEntity<Element>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Element> create(@Valid @RequestBody(required = true) Element element) {
		repository.create(element);
		return new ResponseEntity<Element>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Integer id, @Valid @RequestBody(required = true) Element element) {
		repository.update(element);
	}
}

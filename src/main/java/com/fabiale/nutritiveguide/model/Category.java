package com.fabiale.nutritiveguide.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity(name = "categories")
@SequenceGenerator(name = "SEQ_CATEGORY", sequenceName = "SEQ_CATEGORY", initialValue = 1, allocationSize = 1)
public class Category implements Serializable {

	private static final long serialVersionUID = -1823684895080662242L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORY")
	@Expose
	private Integer id;
	@NotEmpty
	@Length(max = 255)
	@Expose
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package com.fabiale.nutritiveguide.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "food")
@SequenceGenerator(name = "SEQ_FOOD", sequenceName = "SEQ_FOOD", initialValue = 1, allocationSize = 1)
public class Food implements Serializable {

	private static final long serialVersionUID = -3156184559630102355L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FOOD")
	private Integer id;
	@NotEmpty
	@Length(max = 255)
	private String name;
	private String description;
	private Double quantity;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@ForeignKey(name = "FK_FOOD_CATEGORY")
	@NotNull
	private Category category;
	
	@OneToOne(mappedBy = "food", cascade=CascadeType.ALL)
    private FoodElement foodElement;

	public FoodElement getFoodElement() {
		return foodElement;
	}

	public void setFoodElement(FoodElement foodElement) {
		this.foodElement = foodElement;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}
}

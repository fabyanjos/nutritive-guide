package com.fabiale.nutritiveguide.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "food_element")
@AssociationOverrides({
		@AssociationOverride(name = "pk.food", joinColumns = @JoinColumn(name = "food_id")),
		@AssociationOverride(name = "pk.element", joinColumns = @JoinColumn(name = "element_id")) })
public class FoodElement implements Serializable {

	private static final long serialVersionUID = 499491218083333185L;

	@EmbeddedId
	@Expose
	private FoodElementId pk;
	@Expose
	private String value;

	public FoodElementId getPk() {
		return pk;
	}

	public void setPk(FoodElementId pk) {
		this.pk = pk;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Element getElement() {
		return getPk().getElement();
	}

	public void setElement(Element element) {
		getPk().setElement(element);
	}

	public Food getFood() {
		return getPk().getFood();
	}

	public void setFood(Food food) {
		getPk().setFood(food);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FoodElement that = (FoodElement) o;

		if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}

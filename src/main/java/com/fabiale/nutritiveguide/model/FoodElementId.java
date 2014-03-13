package com.fabiale.nutritiveguide.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Embeddable
public class FoodElementId implements Serializable {

	private static final long serialVersionUID = -3104046623690214844L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Food food;
	@ManyToOne
	@Expose
	private Element element;

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FoodElementId that = (FoodElementId) o;

		if (food != null ? !food.equals(that.food) : that.food != null)
			return false;
		if (element != null ? !element.equals(that.element)
				: that.element != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (food != null ? food.hashCode() : 0);
		result = 31 * result + (element != null ? element.hashCode() : 0);
		return result;
	}

}

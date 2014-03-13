package com.fabiale.nutritiveguide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity(name = "food")
@SequenceGenerator(name = "SEQ_FOOD", sequenceName = "SEQ_FOOD", initialValue = 1, allocationSize = 1)
public class Food implements Serializable {

	private static final long serialVersionUID = -3156184559630102355L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FOOD")
	@Expose
	private Integer id;
	@NotEmpty
	@Length(max = 255)
	@Expose
	private String name;
	@Expose
	private String description;
	@Expose
	private Double quantity;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum january;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum february;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum march;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum april;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum may;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum june;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum july;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum august;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum september;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum october;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum november;
	@Enumerated(EnumType.STRING)
	private AvailabilityEnum december;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@ForeignKey(name = "FK_FOOD_CATEGORY")
	@NotNull
	@Expose
	private Category category;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.food", cascade=CascadeType.ALL)
	@Expose
	private List<FoodElement> foodElements;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public AvailabilityEnum getJanuary() {
		return january;
	}

	public void setJanuary(AvailabilityEnum january) {
		this.january = january;
	}

	public AvailabilityEnum getFebruary() {
		return february;
	}

	public void setFebruary(AvailabilityEnum february) {
		this.february = february;
	}

	public AvailabilityEnum getMarch() {
		return march;
	}

	public void setMarch(AvailabilityEnum march) {
		this.march = march;
	}

	public AvailabilityEnum getApril() {
		return april;
	}

	public void setApril(AvailabilityEnum april) {
		this.april = april;
	}

	public AvailabilityEnum getMay() {
		return may;
	}

	public void setMay(AvailabilityEnum may) {
		this.may = may;
	}

	public AvailabilityEnum getJune() {
		return june;
	}

	public void setJune(AvailabilityEnum june) {
		this.june = june;
	}

	public AvailabilityEnum getJuly() {
		return july;
	}

	public void setJuly(AvailabilityEnum july) {
		this.july = july;
	}

	public AvailabilityEnum getAugust() {
		return august;
	}

	public void setAugust(AvailabilityEnum august) {
		this.august = august;
	}

	public AvailabilityEnum getSeptember() {
		return september;
	}

	public void setSeptember(AvailabilityEnum september) {
		this.september = september;
	}

	public AvailabilityEnum getOctober() {
		return october;
	}

	public void setOctober(AvailabilityEnum october) {
		this.october = october;
	}

	public AvailabilityEnum getNovember() {
		return november;
	}

	public void setNovember(AvailabilityEnum november) {
		this.november = november;
	}

	public AvailabilityEnum getDecember() {
		return december;
	}

	public void setDecember(AvailabilityEnum december) {
		this.december = december;
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
}

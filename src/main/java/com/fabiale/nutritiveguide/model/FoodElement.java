package com.fabiale.nutritiveguide.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fabiale.nutritiveguide.gson.ExcludeField;

@Entity(name = "food_element")
public class FoodElement implements Serializable {

	private static final long serialVersionUID = 183096999267568386L;

	@Id
	@Column(name = "food_id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "food"))
	@ExcludeField
	private Integer foodId;

	private String umidade;
	private String energiaKcal;
	private String energiaKJ;
	private String proteina;
	private String lipideos;
	private String colesterol;
	private String carboidrato;
	private String fibraAlimentar;
	private String cinzas;
	private String calcio;
	private String magnesio;
	private String manganes;
	private String fosforo;
	private String ferro;
	private String sodio;
	private String potassio;
	private String cobre;
	private String zinco;
	private String retinol;
	private String re;
	private String rae;
	private String tiamina;
	private String riboflavina;
	private String piridoxina;
	private String niacina;
	private String vitaminaC;

	@ExcludeField
	@OneToOne
    @PrimaryKeyJoinColumn
	private Food food;
	

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getEnergiaKcal() {
		return energiaKcal;
	}

	public void setEnergiaKcal(String energiaKcal) {
		this.energiaKcal = energiaKcal;
	}

	public String getEnergiaKJ() {
		return energiaKJ;
	}

	public void setEnergiaKJ(String energiaKJ) {
		this.energiaKJ = energiaKJ;
	}

	public String getProteina() {
		return proteina;
	}

	public void setProteina(String proteina) {
		this.proteina = proteina;
	}

	public String getLipideos() {
		return lipideos;
	}

	public void setLipideos(String lipideos) {
		this.lipideos = lipideos;
	}

	public String getColesterol() {
		return colesterol;
	}

	public void setColesterol(String colesterol) {
		this.colesterol = colesterol;
	}

	public String getCarboidrato() {
		return carboidrato;
	}

	public void setCarboidrato(String carboidrato) {
		this.carboidrato = carboidrato;
	}

	public String getFibraAlimentar() {
		return fibraAlimentar;
	}

	public void setFibraAlimentar(String fibraAlimentar) {
		this.fibraAlimentar = fibraAlimentar;
	}

	public String getCinzas() {
		return cinzas;
	}

	public void setCinzas(String cinzas) {
		this.cinzas = cinzas;
	}

	public String getCalcio() {
		return calcio;
	}

	public void setCalcio(String calcio) {
		this.calcio = calcio;
	}

	public String getMagnesio() {
		return magnesio;
	}

	public void setMagnesio(String magnesio) {
		this.magnesio = magnesio;
	}

	public String getManganes() {
		return manganes;
	}

	public void setManganes(String manganes) {
		this.manganes = manganes;
	}

	public String getFosforo() {
		return fosforo;
	}

	public void setFosforo(String fosforo) {
		this.fosforo = fosforo;
	}

	public String getFerro() {
		return ferro;
	}

	public void setFerro(String ferro) {
		this.ferro = ferro;
	}

	public String getSodio() {
		return sodio;
	}

	public void setSodio(String sodio) {
		this.sodio = sodio;
	}

	public String getPotassio() {
		return potassio;
	}

	public void setPotassio(String potassio) {
		this.potassio = potassio;
	}

	public String getCobre() {
		return cobre;
	}

	public void setCobre(String cobre) {
		this.cobre = cobre;
	}

	public String getZinco() {
		return zinco;
	}

	public void setZinco(String zinco) {
		this.zinco = zinco;
	}

	public String getRetinol() {
		return retinol;
	}

	public void setRetinol(String retinol) {
		this.retinol = retinol;
	}

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}

	public String getRae() {
		return rae;
	}

	public void setRae(String rae) {
		this.rae = rae;
	}

	public String getTiamina() {
		return tiamina;
	}

	public void setTiamina(String tiamina) {
		this.tiamina = tiamina;
	}

	public String getRiboflavina() {
		return riboflavina;
	}

	public void setRiboflavina(String riboflavina) {
		this.riboflavina = riboflavina;
	}

	public String getPiridoxina() {
		return piridoxina;
	}

	public void setPiridoxina(String piridoxina) {
		this.piridoxina = piridoxina;
	}

	public String getNiacina() {
		return niacina;
	}

	public void setNiacina(String niacina) {
		this.niacina = niacina;
	}

	public String getVitaminaC() {
		return vitaminaC;
	}

	public void setVitaminaC(String vitaminaC) {
		this.vitaminaC = vitaminaC;
	}
}

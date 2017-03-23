package com.ecommerce.catalogue;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.ecommerce.pricing.Price;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"code"})})
@ApiModel
public class Product {
	
	@Id
	@GeneratedValue
	@ApiModelProperty(required = false)
	private Long id;
	
	@ApiModelProperty(required = true)
	@NotNull
	private String code;
	
	@ApiModelProperty(required = true)
	@NotNull
	private String name;
	
	private String description;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Enumerated
	private Category category;
	
	@Transient
	@ApiModelProperty(required = false)
	private Price price;
	
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

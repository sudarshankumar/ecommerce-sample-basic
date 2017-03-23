package com.ecommerce.pricing;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"productCode"})})
@ApiModel
public class Price {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(required = true)
	@NotNull
	private String productCode;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Enumerated
	private Currency currency;
	
	@ApiModelProperty(required = true)
	@NotNull
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}

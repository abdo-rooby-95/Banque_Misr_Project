package com.banquemisr.irrigation.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "Plot")
public class Plot {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double size;
	private String type;
	private Address location;
	@ManyToOne
	private PlotConfiguration configuration;

	public Plot() {
	}

	public Plot(Double size, String type, Address location) {
		super();
		this.size = size;
		this.type = type;
		this.location = location;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PlotConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(PlotConfiguration configuration) {
		this.configuration = configuration;
	}

}

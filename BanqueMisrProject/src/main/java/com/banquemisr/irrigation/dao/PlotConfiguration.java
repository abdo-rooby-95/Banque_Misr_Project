package com.banquemisr.irrigation.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PlotConfiguration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date startDate;
	private Date endDate;
	@OneToMany
	private Sensor sensor;
	private Double waterAmount;
	
	private Long numberOfRound;
	
	@OneToOne
	private Plot plot;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	
	public PlotConfiguration() {}
	
	public PlotConfiguration(Date startDate, Date endDate, Sensor sensor) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.sensor = sensor;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Double getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(Double waterAmount) {
		this.waterAmount = waterAmount;
	}

	public Long getNumberOfRound() {
		return numberOfRound;
	}

	public void setNumberOfRound(Long numberOfRound) {
		this.numberOfRound = numberOfRound;
	}


}

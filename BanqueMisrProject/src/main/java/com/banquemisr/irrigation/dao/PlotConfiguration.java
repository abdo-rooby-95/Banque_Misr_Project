package com.banquemisr.irrigation.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PlotConfiguration {
	
	private Date startDate;
	private Date endDate;
	@OneToMany
	private Sensor sensor;
	private Double waterAmount;
	
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


}

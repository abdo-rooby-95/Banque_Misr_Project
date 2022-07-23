package com.banquemisr.irrigation.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.dao.Sensor;

public class SenserServiceImp implements SensorService{

	@Autowired
	private PlotService plotService;
	@Autowired
	private SensorService sensorService;
	
	@Override
	public Boolean irrigatePlot(Long plotId, Long senserId, Date startDate, Date endDate, Double waterAmount) {
		Optional<Plot> plot = plotService.getPoltById(plotId);
		PlotConfiguration config = plot.get().getConfiguration();
		if(config == null) {
			config = new PlotConfiguration();
		}
		config.setEndDate(endDate);
		config.setStartDate(startDate);
		config.setWaterAmount(waterAmount);
		plot.get().setConfiguration(config);
		Sensor sensor = sensorService.getSensorById(senserId);
		config.setSensor(sensor);
		plotService.addPolt(plot.get());
		return null;
	}

	public PlotService getPlotService() {
		return plotService;
	}

	public void setPlotService(PlotService plotService) {
		this.plotService = plotService;
	}

	public SensorService getSensorService() {
		return sensorService;
	}

	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	@Override
	public Sensor getSensorById(Long sensorId) {
		// TODO Auto-generated method stub
		return null;
	}

}

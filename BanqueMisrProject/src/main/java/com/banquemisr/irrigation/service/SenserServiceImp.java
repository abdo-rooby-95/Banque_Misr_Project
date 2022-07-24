package com.banquemisr.irrigation.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.dao.Sensor;

public class SenserServiceImp implements SensorService{

	@Autowired
	private PlotService plotService;
	@Autowired
	private SensorService sensorService;

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

	/* this method should call the sensor integration API
	 * will redirect the call into the device/sensor to run perform the action
	 */
	@Override
	public Sensor getSensorById(Long sensorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* this method should call the sensor integration API
	 * will redirect the call into the device/sensor to run perform the action
	 */
	@Override
	public Boolean irrigatePlot(Plot plot, PlotConfiguration config) {
		
		return true;
	}

}

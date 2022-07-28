package com.banquemisr.irrigation.service;

import com.banquemisr.irrigation.dao.PlotConfiguration;

public interface SensorIntegrationLayer {
	Boolean assignJobToSensor(Long sensorId, PlotConfiguration configuration);
	
	Boolean IsSensorAvailable(Long sensorId, PlotConfiguration configuration);
}

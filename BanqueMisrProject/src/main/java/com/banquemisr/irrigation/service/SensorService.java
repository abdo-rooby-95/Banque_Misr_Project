package com.banquemisr.irrigation.service;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.dao.Sensor;

public interface SensorService {

public Boolean irrigatePlot(Plot plot, PlotConfiguration config);

public Sensor getSensorById(Long sensorId);
}

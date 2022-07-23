package com.banquemisr.irrigation.service;

import java.util.Date;

import com.banquemisr.irrigation.dao.Sensor;

public interface SensorService {

public Boolean irrigatePlot(Long plotId, Long senserId, Date startDate, Date endDate, Double waterAmoun);

public Sensor getSensorById(Long sensorId);
}

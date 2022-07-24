package com.banquemisr.irrigation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.dao.Sensor;
import com.banquemisr.irrigation.repository.PlotRepository;

@Service
public class PlotServiceImp implements PlotService {
	
	@Autowired
	private PlotRepository plotRepository;
	
	@Autowired
	private SensorService sensorService;
	
	@Override
	public void addPolt(Plot plot) {
		plotRepository.save(plot);
	}

	@Override
	public void deletPoltById(Long id) {
		plotRepository.deleteById(id);
	}
	
	@Override
	public void deletPolt(Plot plot) {
		plotRepository.delete(plot);
	}
	
	@Override
	public Optional<Plot> getPoltById(Long id) {
		return plotRepository.findById(id);
	}
	
	@Override
	public List<Plot> getAllPolt() {
		return (List<Plot>) plotRepository.findAll();
	}
	
	@Override
	public Boolean configurePlot(Plot plot, PlotConfiguration configuration) {
		
		if(configuration != null) {
			Sensor sensor = configuration.getSensor();
			if(sensor != null && sensor.getIsAvailable()) {
				plot.getConfigurationList().add(configuration);
				plotRepository.save(plot);
				return sensorService.irrigatePlot(plot, configuration);
			}
		
		}
		return false;
	}

	public PlotRepository getPlotRepository() {
		return plotRepository;
	}



	public void setPlotRepository(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
	}

}

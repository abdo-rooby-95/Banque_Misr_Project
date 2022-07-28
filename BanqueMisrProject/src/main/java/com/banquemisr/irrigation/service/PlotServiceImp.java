package com.banquemisr.irrigation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.dao.Sensor;
import com.banquemisr.irrigation.repository.PlotConfigurationRepository;
import com.banquemisr.irrigation.repository.PlotRepository;

@Service
public class PlotServiceImp implements PlotService {

	@Autowired
	private PlotRepository plotRepository;

	@Autowired
	private SensorService sensorService;

	@Autowired
	private PlotConfigurationRepository plotConfigurationRepository;
	@Autowired
	private SensorIntegrationLayer sensorIntegrationLayer;

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
	
	static Long DEAFULT_NUMBER_OF_RETRY = 3l;

	@Override
	public Boolean configurePlot(Long plotId, PlotConfiguration configuration) {
		try {
			Plot plot = this.getPoltById(plotId).get();

			List<PlotConfiguration> configurationList = plot.getConfigurationList();
			if (configurationList == null)
				configurationList = new ArrayList<>();

			configurationList.add(configuration);
			// saving the received Plot Configuration
			plotConfigurationRepository.save(configuration);
			plot.setConfigurationList(configurationList);
			// saving Plot with Configuration
			plotRepository.save(plot);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Plot> getAllPolt() {
		return (List<Plot>) plotRepository.findAll();
	}

	@Override
	public String irrigatePlot(Long plotId, Long sensorId) {
		long numberOfRetry = DEAFULT_NUMBER_OF_RETRY;
		boolean jobAssigned = false;
		Plot plot = this.getPoltById(plotId).get();
		List<PlotConfiguration> configurationList = plot.getConfigurationList();
		if (configurationList != null && configurationList.size() == 0)
			return "There Is No Configuration Assgied To The Plot";
		
		for (PlotConfiguration configuration : configurationList) {
			// check sensor availability based on the configuration
			boolean isSensorAvailable = sensorIntegrationLayer.IsSensorAvailable(sensorId, configuration);
			if(!isSensorAvailable)
				return "The Sensor Assigned Is Not Available";
			
			while(numberOfRetry > 0) {
				jobAssigned = sensorIntegrationLayer.assignJobToSensor(sensorId, configuration);
			numberOfRetry--;
			}
			if(!jobAssigned);
				return "Alert: The Sensor Is Not Able to Process The Request At The Meantime";
			}
		return "The Plot Has Been Irrigated";
	}

	public PlotRepository getPlotRepository() {
		return plotRepository;
	}

	public void setPlotRepository(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
	}

}

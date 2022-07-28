package com.banquemisr.irrigation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.repository.PlotConfigurationRepository;
import com.banquemisr.irrigation.repository.PlotRepository;

@Service
public class PlotConfigurationServiceImp implements PlotConfigurationService {

	@Autowired
	private SensorService sensorService;

	@Autowired
	private PlotConfigurationRepository plotConfigurationRepository;

	@Autowired
	private PlotRepository plotRepository;
	
	@Autowired
	private PlotService plotService;
	
	
	@Override
	public void addPoltConfiguration(PlotConfiguration plotConfiguration) {
		plotConfigurationRepository.save(plotConfiguration);
	}

	@Override
	public void deletPoltConfigurationById(Long id) {
		plotConfigurationRepository.deleteById(id);
	}

	@Override
	public void deletPoltConfiguration(PlotConfiguration plotConfiguration) {
		plotConfigurationRepository.delete(plotConfiguration);
	}

	@Override
	public Optional<PlotConfiguration> getPoltConfigurationById(Long id) {
		return plotConfigurationRepository.findById(id);
	}

	@Override
	public List<PlotConfiguration> getAllPoltConfigurations() {
		return (List<PlotConfiguration>) plotConfigurationRepository.findAll();
	}
	
	@Override
	public Boolean configurePlot(Long plotId, PlotConfiguration configuration) {
		try {
			Plot plot = plotService.getPoltById(plotId).get();
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

	public PlotRepository getPlotRepository() {
		return plotRepository;
	}

	public void setPlotRepository(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
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

	public PlotConfigurationRepository getPlotConfigurationRepository() {
		return plotConfigurationRepository;
	}

	public void setPlotConfigurationRepository(PlotConfigurationRepository plotConfigurationRepository) {
		this.plotConfigurationRepository = plotConfigurationRepository;
	}

}

package com.banquemisr.irrigation.service;

import java.util.List;
import java.util.Optional;

import com.banquemisr.irrigation.dao.PlotConfiguration;

public interface PlotConfigurationService {
	public void addPoltConfiguration(PlotConfiguration plotConfiguration);
	public void deletPoltConfigurationById(Long id);
	public void deletPoltConfiguration(PlotConfiguration plotConfiguration);
	public Optional<PlotConfiguration> getPoltConfigurationById(Long id);
	public List<PlotConfiguration> getAllPoltConfigurations();
	public Boolean configurePlot(Long plotId, PlotConfiguration configuration);
	
}

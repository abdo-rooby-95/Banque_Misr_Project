package com.banquemisr.irrigation.service;

import java.util.List;
import java.util.Optional;
import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.dao.PlotConfiguration;

public interface PlotService {
	public void addPolt(Plot plot);
	public void deletPoltById(Long id);
	public void deletPolt(Plot plot);
	public Optional<Plot> getPoltById(Long id);
	public List<Plot> getAllPolt();
	public Boolean configurePlot(Plot plot, PlotConfiguration configuration);
	
}

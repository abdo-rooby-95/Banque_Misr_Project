package com.banquemisr.irrigation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.repository.PlotRepository;

@Service
public class PlotServiceImp implements PlotService {
	
	@Autowired
	private PlotRepository plotRepository;
	
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

	public PlotRepository getPlotRepository() {
		return plotRepository;
	}



	public void setPlotRepository(PlotRepository plotRepository) {
		this.plotRepository = plotRepository;
	}

}

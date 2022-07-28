package com.banquemisr.irrigation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquemisr.irrigation.dao.Plot;
import com.banquemisr.irrigation.service.PlotService;

@RestController
@RequestMapping(path = "irrigation/plot/")
public class PlotController {
	@Autowired
	private PlotService plotService;
	
	
	@PostMapping("add")
	public void addPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@PostMapping("edit")
	public void editPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@GetMapping("getAll")
	public List<Plot> getAllPlots() {
		return plotService.getAllPolt();
	}
	
	@GetMapping("get/{id}")
	public Optional<Plot> getPlotByID(@PathVariable("id") long id) {
		return plotService.getPoltById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deletePlotByID(@PathVariable("id") long id) {
		plotService.deletPoltById(id);
	}
	
	@PostMapping("irrigate/{plotId}/{sensorId}")
	public String irrigatePlot(@PathVariable("plotId") long plotId, @PathVariable("sensorId") long sensorId) {
		return plotService.irrigatePlot(plotId, sensorId);
	}


	public PlotService getPlotService() {
		return plotService;
	}


	public void setPlotService(PlotService plotService) {
		this.plotService = plotService;
	}
}

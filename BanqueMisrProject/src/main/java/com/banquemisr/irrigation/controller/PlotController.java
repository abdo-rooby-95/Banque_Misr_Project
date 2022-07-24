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
import com.banquemisr.irrigation.dao.PlotConfiguration;
import com.banquemisr.irrigation.service.PlotServiceImp;

@RestController
@RequestMapping(path = "irrigation/plot")
public class PlotController {
	@Autowired
	private PlotServiceImp plotService;
	
	
	@PostMapping("/add")
	public void addPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@PostMapping("/edit")
	public void editPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@PostMapping("/configure")
	public void configurePlot(@RequestBody Plot plot, @RequestBody PlotConfiguration configuration) {
		plotService.addPolt(plot);
	}
	
	@GetMapping("/getAll")
	public List<Plot> getAllPlots() {
		return plotService.getAllPolt();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Plot> getPlotByID(@PathVariable("id") long id) {
		return plotService.getPoltById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePlotByID(@PathVariable("id") long id) {
		plotService.deletPoltById(id);
	}


	public PlotServiceImp getPlotService() {
		return plotService;
	}


	public void setPlotService(PlotServiceImp plotService) {
		this.plotService = plotService;
	}
}

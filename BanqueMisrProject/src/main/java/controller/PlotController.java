package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.Plot;
import service.PlotServiceImp;

@RestController
public class PlotController {
	@Autowired
	private PlotServiceImp plotService;
	
	
	@PostMapping("/plot/add")
	public void addPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@PostMapping("/plot/edit")
	public void editPlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@PostMapping("/plot/configure")
	public void configurePlot(@RequestBody Plot plot) {
		plotService.addPolt(plot);
	}
	
	@GetMapping("/plot/getAll")
	public List<Plot> getAllPlots() {
		return plotService.getAllPolt();
	}
	
	@GetMapping("/plot/get/{id}")
	public Optional<Plot> getPlotByID(@PathVariable("id") long id) {
		return plotService.getPoltById(id);
	}
	
	@DeleteMapping("/plot/delete/{id}")
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

package service;

import java.util.List;
import java.util.Optional;

import dao.Plot;

public interface PlotService {
	public void addPolt(Plot plot);
	public void deletPoltById(Long id);
	public void deletPolt(Plot plot);
	public Optional<Plot> getPoltById(Long id);
	public List<Plot> getAllPolt();
	
}

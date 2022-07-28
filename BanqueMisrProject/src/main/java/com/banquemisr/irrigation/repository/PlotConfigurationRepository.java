package com.banquemisr.irrigation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banquemisr.irrigation.dao.PlotConfiguration;

@Repository
public interface PlotConfigurationRepository extends CrudRepository<PlotConfiguration, Long> {

}

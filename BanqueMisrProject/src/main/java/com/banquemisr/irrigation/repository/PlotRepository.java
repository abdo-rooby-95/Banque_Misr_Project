package com.banquemisr.irrigation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banquemisr.irrigation.dao.Plot;

@Repository
public interface PlotRepository extends CrudRepository<Plot, Long> {

}

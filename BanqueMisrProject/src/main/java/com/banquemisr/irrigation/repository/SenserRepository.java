package com.banquemisr.irrigation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.banquemisr.irrigation.dao.Sensor;

@Repository
public interface SenserRepository extends CrudRepository<Sensor, Long> {

}

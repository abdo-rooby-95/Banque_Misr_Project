package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dao.Plot;

@Repository
public interface PlotRepository extends CrudRepository<Plot, Long> {

}

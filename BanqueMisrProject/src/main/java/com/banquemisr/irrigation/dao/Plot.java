package com.banquemisr.irrigation.dao;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "Plot")
public class Plot {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double size;
	private String type;
	@Embedded
	private Location location;
	@OneToMany
	private List<PlotConfiguration> configurationList;

	public Plot() {
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PlotConfiguration> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<PlotConfiguration> configurationList) {
		this.configurationList = configurationList;
	}

	public Plot(Long id, Double size, String type, Location location, List<PlotConfiguration> configurationList) {
		super();
		this.id = id;
		this.size = size;
		this.type = type;
		this.location = location;
		this.configurationList = configurationList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configurationList == null) ? 0 : configurationList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		if (configurationList == null) {
			if (other.configurationList != null)
				return false;
		} else if (!configurationList.equals(other.configurationList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}

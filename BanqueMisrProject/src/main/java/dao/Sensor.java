package dao;

import org.springframework.data.relational.core.mapping.Table;

@Table
public class Sensor {
private Long id;
private String type;
private String manufactureBy;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getManufactureBy() {
	return manufactureBy;
}
public void setManufactureBy(String manufactureBy) {
	this.manufactureBy = manufactureBy;
}
}

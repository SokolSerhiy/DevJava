package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City extends AbstractEntity{

	private String name;
	
	@OneToMany(mappedBy="cityArrive")
	private List<Transporter> transporters = new ArrayList<>();
	
	@OneToMany(mappedBy="cityFrom")
	private List<Cargo> cargosFrom = new ArrayList<>();
	
	@OneToMany(mappedBy="cityTo")
	private List<Cargo> cargosTo = new ArrayList<>();

	public City(String name) {
		this.name = name;
	}

	public City() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transporter> getTransporters() {
		return transporters;
	}

	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}

	public List<Cargo> getCargosFrom() {
		return cargosFrom;
	}

	public void setCargosFrom(List<Cargo> cargosFrom) {
		this.cargosFrom = cargosFrom;
	}

	public List<Cargo> getCargosTo() {
		return cargosTo;
	}

	public void setCargosTo(List<Cargo> cargosTo) {
		this.cargosTo = cargosTo;
	}
}
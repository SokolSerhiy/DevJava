package ua.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="open_close")
public class OpenClose extends AbstractEntity{

	@OneToMany(mappedBy="open")
	private List<Cafe> openedCafes = new ArrayList<>();
	
	@OneToMany(mappedBy="close")
	private List<Cafe> closedCafes = new ArrayList<>();
	
	private LocalTime time;
	
	public OpenClose(LocalTime time) {
		this.time = time;
	}

	public OpenClose() {
	}

	public List<Cafe> getOpenedCafes() {
		return openedCafes;
	}

	public void setOpenedCafes(List<Cafe> openedCafes) {
		this.openedCafes = openedCafes;
	}

	public List<Cafe> getClosedCafes() {
		return closedCafes;
	}

	public void setClosedCafes(List<Cafe> closedCafes) {
		this.closedCafes = closedCafes;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
}

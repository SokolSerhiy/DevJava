package library.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Rent implements Serializable{

	private static final long serialVersionUID = -5891772138900514532L;

	private Tenan tenan;
	
	private Tenancy tenancy;
	
	private LocalDate start;
	
	private LocalDate end;

	public Tenan getTenan() {
		return tenan;
	}

	public void setTenan(Tenan tenan) {
		this.tenan = tenan;
	}

	public Tenancy getTenancy() {
		return tenancy;
	}

	public void setTenancy(Tenancy tenancy) {
		this.tenancy = tenancy;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}
}
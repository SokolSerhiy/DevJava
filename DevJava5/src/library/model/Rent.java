package library.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Rent implements Serializable{

	private static final long serialVersionUID = -5891772138900514532L;

	private Tenant tenant;
	
	private Tenancy tenancy;
	
	private LocalDate start;
	
	private LocalDate end;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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

	@Override
	public String toString() {
		return "Rent [tenant=" + tenant + ", tenancy=" + tenancy + ", start="
				+ start + ", end=" + end + "]";
	}
}

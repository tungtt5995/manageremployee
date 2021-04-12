package poly.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departs")
public class Departs {
	@Id
	private String id;
	private String name;
	
	@OneToMany(mappedBy = "departid",fetch = FetchType.EAGER)
	private Collection<Staffs> staff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Staffs> getStaff() {
		return staff;
	}

	public void setStaff(Collection<Staffs> staff) {
		this.staff = staff;
	}
	
	
}

package poly.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Departs")
public class Departs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="Không được để trống tên phòng ban !")
	private String name;
	
	@OneToMany(mappedBy = "departid",fetch = FetchType.EAGER)
	private Collection<Staffs> staff;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

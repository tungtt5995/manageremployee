package poly.entity;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Staffs")
public class Staffs {
	@Id
	private String id;
	private String name;
	private boolean gender;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	private String photo;
	private String email;
	private String phone;
	private float salary;
	private String notes;
	@ManyToOne
	@JoinColumn(name="DepartId")
	private Departs departid;
	@OneToMany(mappedBy = "staff",fetch = FetchType.EAGER)
	private Collection<Records> record;
	
	
	public Staffs(String id, String name, boolean gender, Date birthday, String photo, String email, String phone,
			float salary, String notes, Departs departid, Collection<Records> record) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.departid = departid;
		this.record = record;
	}
	public Staffs() {
		
	}
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Departs getDepartid() {
		return departid;
	}
	public void setDepartid(Departs departid) {
		this.departid = departid;
	}
	public Collection<Records> getRecord() {
		return record;
	}
	public void setRecord(Collection<Records> record) {
		this.record = record;
	}
}

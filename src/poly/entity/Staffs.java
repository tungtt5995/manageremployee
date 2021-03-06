package poly.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staffs")
public class Staffs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Không được để trống tên !")
	private String name;
	private boolean gender;

	@NotNull(message = "Chọn ngày sinh")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	private String photo;

	@NotBlank(message = "Không được để trống email !")
	private String email;

	@NotBlank(message = "Không được để trống số điện thoại !")
	private String phone;

	//@NotBlank(message = "Không được để trống lương")
	private double salary;
	
	@NotBlank(message = "Không được để trống ghi chú !")
	private String notes;
	
	@ManyToOne
	@JoinColumn(name = "DepartId")
	private Departs departid;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Records> record;

	public Staffs(Integer id, String name, boolean gender, Date birthday, String photo, String email, String phone,
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
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

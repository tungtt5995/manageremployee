package poly.dao;

import java.util.List;

import poly.entity.Staffs;

public interface StaffDao {
	public List<Staffs> listStaffs();

	public boolean addStaff(Staffs staff);

	public boolean editStaff(Staffs staff);

	public Staffs infoStaff(int id);

	public boolean deleteStaff(int id);
	
}

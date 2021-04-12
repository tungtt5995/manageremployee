package poly.dao;

import java.util.List;

import poly.entity.Users;

public interface UserDao {
	public List<Users> listUses();

	public boolean addUser(Users users);
//	public boolean editUser(Users users);
}

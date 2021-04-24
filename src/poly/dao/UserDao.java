package poly.dao;

import java.util.List;

import poly.entity.Users;

public interface UserDao {
	public List<Users> listUses();

	public boolean addUser(Users users);

	public boolean editUser(Users users);

	public boolean deleteUser(String username);

	public Users inforUser(String username);

	public boolean checkLogin(String username, String password);

	public Users login(String username, String password);
}

package poly.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.UserDao;
import poly.entity.Users;

public interface UsersDAOImpl {
	@Transactional
	@Service("UserDAO")
	public class UserDAOImpl implements UserDao {

		@Autowired
		private SessionFactory factory;

		public SessionFactory getFactory() {
			return factory;
		}

		public void setFactory(SessionFactory factory) {
			this.factory = factory;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Users> listUses() {
			Session session = factory.openSession();
			String hql = "FROM Users";
			Query query = session.createQuery(hql);
			List<Users> list = query.list();
			return list;
		}

		@Override
		public boolean addUser(Users users) {
			Session session = this.factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(users);
				t.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				t.rollback();
				return false;
			} finally {
				session.close();
			}
		}

		@Override
		public Users inforUser(String username) {
			Session session = factory.openSession();
			try {
				Users user = (Users) session.get(Users.class, username);
				return user;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.flush();
				session.close();
			}
			return null;
		}

		@Override
		public boolean deleteUser(String username) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			Users users = inforUser(username);
			if (users == null) {
				return false;				
			}
			try {
				session.delete(username, users);
				t.commit();
				System.out.println("Deleted");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}
		}

	

		@Override
		public boolean editUser(Users users) {		
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(users);
				t.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				t.rollback();
				return false;
			}finally {
				session.close();
			}			
			
			
		}

		@Override
		public boolean checkLogin(String username, String password) {
			Session session = this.factory.getCurrentSession();
			Users user = (Users) session.get(Users.class, username);
			if (user == null) {
				return false;
			}
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
			return false;
		}

		@Override
		public Users login(String username, String password) {
			Session session = factory.openSession();
			Query query = session.createQuery("from Users where username = :username and password = :password");
			query.setString("username", username);
			query.setString("password", password);
			Users user = (Users) query.uniqueResult();
			return user;
		}

	

		
	}
}

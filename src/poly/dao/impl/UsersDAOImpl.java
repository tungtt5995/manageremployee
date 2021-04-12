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

//		@Override
//		public boolean editUser(Users users) {
//			
//			Session session = this.factory.getCurrentSession();
//			Transaction t = session.beginTransaction();
//			try {
//				session.update(users);
//				t.commit();
//				return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				t.rollback();
//				return false;
//			}finally {
//				session.close();
//			}			
//			
//			
//		}
	}
}

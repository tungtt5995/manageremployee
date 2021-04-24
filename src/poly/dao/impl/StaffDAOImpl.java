package poly.dao.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import poly.dao.StaffDao;
import poly.entity.Staffs;

@Repository
@Transactional
@Service("StaffDao")
public class StaffDAOImpl implements StaffDao {
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
	public List<Staffs> listStaffs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staffs";
		Query query = session.createQuery(hql);
		List<Staffs> list = query.list();
		return list;
	}

	@Override
	public boolean addStaff(Staffs staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(staff);
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
	public boolean editStaff(Staffs staff) {
		Session session = this.factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(staff);
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
	public Staffs infoStaff(int id) {
		Session session = factory.openSession();
		try {
			Staffs staff = (Staffs) session.get(Staffs.class, id);
			return staff;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteStaff(int id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Staffs staff = infoStaff(id);
		if(staff == null) {
			return false;
		}
		try {
			session.delete(staff);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
	}



	

}

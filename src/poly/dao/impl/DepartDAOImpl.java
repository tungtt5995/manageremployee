package poly.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.DepartDao;
import poly.entity.Departs;

@SuppressWarnings("unchecked")
@Transactional
@Service("DapartDao")
public class DepartDAOImpl implements DepartDao {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Departs> listDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Departs";
		Query query = session.createQuery(hql);
		List<Departs> list = query.list();
		return list;
	}

	@Override
	public boolean addDepart(Departs depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(depart);
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
	public boolean editDepart(Departs depart) {
		Session session = this.factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
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
	public Departs inforDepart(String id) {
		Session session = this.factory.openSession();
		try {
			Departs depart = (Departs) session.get(Departs.class, id);
			return depart;
		} catch (Exception e) {
			e.printStackTrace();
			session.flush();
			session.close();
		}
		return null;
	}

}

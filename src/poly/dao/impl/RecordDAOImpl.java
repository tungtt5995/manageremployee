package poly.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.RecordDAO;
import poly.entity.Records;

@Transactional
@Service("RecordDAO")
public class RecordDAOImpl implements RecordDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Record> listRecord() {
		Session session = factory.openSession();
		String hql = "FROM Records";
		Query query = session.createQuery(hql);
		List<Record> lisRecords = query.list();
		return lisRecords;
	}

	@Override
	public boolean insertRecord(Records records) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			records.setDate(new Date());
			session.save(records);
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
}

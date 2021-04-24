package poly.dao;

import java.util.List;

import poly.entity.Departs;

public interface DepartDao {
	public List<Departs> listDeparts();

	public boolean addDepart(Departs depart);

	public boolean editDepart(Departs depart);

	public Departs inforDepart(Integer id);
}

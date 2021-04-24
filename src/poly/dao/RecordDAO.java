package poly.dao;

import java.util.List;

import poly.entity.Records;

public interface RecordDAO {
	public List<Record> listRecord();
	public boolean insertRecord(Records records);	
//	public List<Records> lisRecords();
}

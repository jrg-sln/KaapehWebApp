package mx.unam.iimas.dao;

import java.util.List;

import mx.unam.iimas.model.LogAccess;

public interface LogAccessDAO {

	public List<LogAccess> getAllLogAccess();
	
	public void saveLogAccess(LogAccess logAccess);

}

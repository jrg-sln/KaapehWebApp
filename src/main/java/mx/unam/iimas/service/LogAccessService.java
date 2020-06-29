package mx.unam.iimas.service;

import java.util.List;

import mx.unam.iimas.model.LogAccess;

public interface LogAccessService {
	
	public List<LogAccess> getAllLogAccess();
	
	public void saveLogAccess(LogAccess logAccess);
}

package mx.unam.iimas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.iimas.dao.LogAccessDAO;
import mx.unam.iimas.model.LogAccess;

@Service
public class LogAccessServiceImpl implements LogAccessService {

	@Autowired
	private LogAccessDAO logAccessDAO;
	
	@Override
	@Transactional
	public List<LogAccess> getAllLogAccess(){
		return logAccessDAO.getAllLogAccess();
	}
	
	@Override
	@Transactional
	public void saveLogAccess(LogAccess logAccess) {
		logAccessDAO.saveLogAccess(logAccess);
	}
}

package mx.unam.iimas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.iimas.dao.WorkerTypeDAO;
import mx.unam.iimas.model.WorkerType;

@Service
public class WorkerTypeServiceImpl implements WorkerTypeService {

	@Autowired
	private WorkerTypeDAO workerTypeDAO;
	
	@Override
	@Transactional
	public List<WorkerType> getWorkerTypes() {
		return workerTypeDAO.getWorkerTypes();
	}
}

package mx.unam.iimas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.iimas.dao.WorkerAreaDAO;
import mx.unam.iimas.model.WorkerArea;

@Service
public class WorkerAreaServiceImpl implements WorkerAreaService {

	@Autowired
	private WorkerAreaDAO workerAreaDAO;
	
	@Override
	@Transactional
	public List<WorkerArea> getWorkerAreas() {
		return workerAreaDAO.getWorkerAreas();
	}

}

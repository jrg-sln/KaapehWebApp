package mx.unam.iimas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.iimas.dao.WorkerDAO;
import mx.unam.iimas.model.Worker;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerDAO workerDAO;
	
	@Override
	@Transactional
	public List<Worker> getWorkers() {
		return workerDAO.getWorkers();
	}
	
	@Override
	@Transactional
	public List<Worker> getWorkersByArea(int idArea) {
		return workerDAO.getWorkersByArea(idArea);
	}

	@Override
	@Transactional
	public void saveWorker(Worker worker) {
		workerDAO.saveWorker(worker);
	}

	@Override
	@Transactional
	public Worker getWorker(long id) {
		return workerDAO.getWorker(id);
	}

	@Override
	@Transactional
	public void deleteWorker(long id) {
		workerDAO.deleteWorker(id);
	}
}

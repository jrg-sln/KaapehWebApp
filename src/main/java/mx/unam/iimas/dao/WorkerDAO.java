package mx.unam.iimas.dao;

import java.util.List;

import mx.unam.iimas.model.Worker;

public interface WorkerDAO {

	public List<Worker> getWorkers();
	
	public List<Worker> getWorkersByArea(int idArea);

	public void saveWorker(Worker worker);

	public Worker getWorker(long id);

	public void deleteWorker(long id);
	
}

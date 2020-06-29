package mx.unam.iimas.service;

import java.util.List;

import mx.unam.iimas.model.Worker;

public interface WorkerService {
	
	public List<Worker> getWorkers();
	
	public List<Worker> getWorkersByArea(int idArea);
	
	public void saveWorker(Worker worker);
	
	public Worker getWorker(long id);

	public void deleteWorker(long id);
}

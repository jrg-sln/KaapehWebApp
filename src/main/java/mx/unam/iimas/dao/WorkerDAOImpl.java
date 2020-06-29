package mx.unam.iimas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.unam.iimas.model.Worker;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Worker> getWorkers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Worker> cq = cb.createQuery(Worker.class);
		Root<Worker> root = cq.from(Worker.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		
		return query.getResultList();
	}
	
	@Override
	public List<Worker> getWorkersByArea(int idArea) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Worker> cq = cb.createQuery(Worker.class);
		Root<Worker> root = cq.from(Worker.class);
		cq.select(root).where(cb.equal(root.get("userarea"), idArea));
		Query query = session.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void deleteWorker(long id) {
		Session session = sessionFactory.getCurrentSession();
		Worker theWorker = session.byId(Worker.class).load(id);
		session.delete(theWorker);
	}

	@Override
	public void saveWorker(Worker worker) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(worker);
	}

	@Override
	public Worker getWorker(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Worker theWorker = currentSession.get(Worker.class, id);
		
		return theWorker;
	}
	
}

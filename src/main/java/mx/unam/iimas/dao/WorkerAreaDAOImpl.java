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

import mx.unam.iimas.model.WorkerArea;

@Repository
public class WorkerAreaDAOImpl implements WorkerAreaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<WorkerArea> getWorkerAreas() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<WorkerArea> cq = cb.createQuery(WorkerArea.class);
		Root<WorkerArea> root = cq.from(WorkerArea.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		
		return query.getResultList();
	}

}

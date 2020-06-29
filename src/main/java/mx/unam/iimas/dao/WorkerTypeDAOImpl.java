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

import mx.unam.iimas.model.WorkerType;

@Repository
public class WorkerTypeDAOImpl implements WorkerTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<WorkerType> getWorkerTypes() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<WorkerType> cq = cb.createQuery(WorkerType.class);
		Root<WorkerType> root = cq.from(WorkerType.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		
		return query.getResultList();
	}

}

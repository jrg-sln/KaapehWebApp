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

import mx.unam.iimas.model.LogAccess;

@Repository
public class LogAccessDAOImpl implements LogAccessDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LogAccess> getAllLogAccess(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<LogAccess> cq = cb.createQuery(LogAccess.class);
		Root<LogAccess> root = cq.from(LogAccess.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("date_access")));
		Query query = session.createQuery(cq);
		
		return query.getResultList();
	}
	
	@Override
	public void saveLogAccess(LogAccess logAccess) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(logAccess);
	}
}

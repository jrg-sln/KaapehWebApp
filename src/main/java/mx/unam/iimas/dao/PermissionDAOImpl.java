package mx.unam.iimas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.unam.iimas.model.Permission;

@Repository
public class PermissionDAOImpl implements PermissionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Boolean hasAccessTo(int idUserType, String nameScreen) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Permission> cq = cb.createQuery(Permission.class);
		Root<Permission> root = cq.from(Permission.class);
		cq.select(root).where(
				cb.and(
						cb.equal(root.get("idworkertype"), idUserType),
						cb.equal(root.get("namescreen"), nameScreen)
				)
		);
		Query query = session.createQuery(cq);
		
		List<Permission> l = query.getResultList();
		System.out.println(l.size());
		
		return l.size()>0 ? true : false;
	}

}

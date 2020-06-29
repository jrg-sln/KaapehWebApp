package mx.unam.iimas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.iimas.dao.PermissionDAO;

@Service
public class PermissionServiceImp implements PermissionService {

	@Autowired
	private PermissionDAO permissionDAO;
	
	@Override
	@Transactional
	public Boolean hasAccessTo(int idUserType, String nameScreen) {
		return permissionDAO.hasAccessTo(idUserType, nameScreen);
	}

}

package mx.unam.iimas.service;

public interface PermissionService {

	public Boolean hasAccessTo(int idUserType, String nameScreen);
}

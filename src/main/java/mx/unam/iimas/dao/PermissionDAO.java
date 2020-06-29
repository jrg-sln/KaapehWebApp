package mx.unam.iimas.dao;

public interface PermissionDAO {

	public Boolean hasAccessTo(int idUserType, String nameScreen);
}

package mx.unam.iimas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log_access")
public class LogAccess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ip_address;
	
	private String date_access;
	
	private String email;
	
	private String resource;

	public LogAccess () {}
	
	public LogAccess(String ip, String date, String email, String resource) {
		this.setIp_address(ip);
		this.setDate_access(date);
		this.setEmail(email);
		this.setResource(resource);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getDate_access() {
		return date_access;
	}

	public void setDate_access(String date_access) {
		this.date_access = date_access;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}

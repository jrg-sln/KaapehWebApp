package mx.unam.iimas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="worker")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Favor de ingresar un correo electrónico")
    @Email(message = "Favor de ingresar un correo electrónico válido")
	private String email;
	
	@NotEmpty( message = "Por favor ingresa una contraseña." )
	@Size( min = 8, max = 80, message = "Longitud de la contraseña incorrecta" )
	private String pwd;
	
	@NotNull(message = "Favor de ingresar un nombre")
    @Size(min = 1, message = "Parámetro requerido.")
	private String firstName;
	
	private String secondName;
	
	@NotNull(message = "Favor de ingresar un apellido")
    @Size(min = 1, message = "Parámetro requerido.")
	private String lastName1;
	
	private String lastName2;
	
	@NotNull(message = "Favor de ingresar un tipo de usuario")
	@Min(1)
	private Integer usertype;
	
	private Integer userarea;
	
	private LocalDateTime created;
	
	private Boolean vigent;

	public Worker() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getUserarea() {
		return userarea;
	}

	public void setUserarea(Integer userarea) {
		this.userarea = userarea;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Boolean getVigent() {
		return vigent;
	}

	public void setVigent(Boolean vigent) {
		this.vigent = vigent;
	}
	
	@Override
	public String toString() {
		return "Worker [id=" + id + ", email=" + email + ", pwd=" + pwd + ", firstName=" + firstName + ", secondName="
				+ secondName + ", lastName1=" + lastName1 + ", lastName2=" + lastName2 + ", usertype=" + usertype
				+ ", userarea=" + userarea + ", created=" + created + ", vigent=" + vigent + "]";
	}
}

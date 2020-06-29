package mx.unam.iimas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"permission\"")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idworkertype;
	
	private String nametype;
	
	private Integer idscreen;
	
	private String namescreen;
	
	private Boolean vigent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdworkertype() {
		return idworkertype;
	}

	public void setIdworkertype(Integer idworkertype) {
		this.idworkertype = idworkertype;
	}

	public String getNametype() {
		return nametype;
	}

	public void setNametype(String nametype) {
		this.nametype = nametype;
	}

	public Integer getIdscreen() {
		return idscreen;
	}

	public void setIdscreen(Integer idscreen) {
		this.idscreen = idscreen;
	}

	public String getNamescreen() {
		return namescreen;
	}

	public void setNamescreen(String namescreen) {
		this.namescreen = namescreen;
	}

	public Boolean getVigent() {
		return vigent;
	}

	public void setVigent(Boolean vigent) {
		this.vigent = vigent;
	}
}

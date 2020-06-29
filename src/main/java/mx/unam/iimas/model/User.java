package mx.unam.iimas.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	public User() {
		super();
	}

	@NotEmpty( message = "NotEmpty.userForm.email" )	
	@Email
	private String email;
	
	@NotEmpty( message = "Por favor ingresa una contraseña." )
	@Size( min = 8, max = 20, message = "Longitud de la contraseña incorrecta" )
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	} 
	
	public static String toHexString(byte[] hash) { 
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}

		return hexString.toString();
	}
	
	public static void letAccess(String user, String resource) {
		
	}
}

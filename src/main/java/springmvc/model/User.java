package springmvc.model;

import java.lang.reflect.GenericDeclaration;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


public class User {
	private int id;
	@Size(min=2,max=6)
/*	@Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名长度必须在2-22之间,以字母下划线开头，可由字母数字下划线组成")  
*/	private String username;
	
	@Size(min=1,max=6)
/*	@Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "密码长度必须在10-18之间,以字母下划线开头，可由字母数字下划线组成")  
*/	private String password;
	
	@NotNull(message="必填")
	private Gender gender;
	private boolean enable;
	private Date lastlogin;
	
	
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", enable=" + enable + "]";
	}
	
	
}

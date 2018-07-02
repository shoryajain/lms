package internship.lms.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.user.User;
import internship.lms.view.View;

@Entity
@Table(name = "user_roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String role;

	@OneToOne
	@JoinColumn(name = "user_uname")
	@JsonView(View.UserNameAlso.class)
	private User user;
	
	public Role() {
		super();
	}

	public Role(String role, User user) {
		super();
		this.role = role;
		this.user = user;
	}

	
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public String getUsername() {
		return user.getUname();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

package internship.lms.roles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.view.View;

@RestController
public class RoleController {
	
	@Autowired 
	private RoleService roleService;
	
	@RequestMapping("/admin/roles")
	@JsonView(View.UserNameAlso.class)
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
	
	@RequestMapping("/admin/rolecheck/{username}") 
	public boolean checkRole(@PathVariable String username) {
		return roleService.checkRole(username);
	}
	
	@RequestMapping("/role")
	public String getRole() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/admin/role/{username}")
	@JsonView(View.UserNameAlso.class)
	public Role getRole(@PathVariable String username) {
		return roleService.getRole(username);
	}

	@RequestMapping(method=RequestMethod.POST, value="/admin/role/{username}") 
	public void addRole(@RequestBody String role, @PathVariable String username) {
		roleService.addRole(role, username);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admin/role/{username}")
	public void updateRole(@RequestBody String role, @PathVariable String username) {
		roleService.addRole(role, username);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/role/{username}")
	public void deleteRole(@PathVariable String username) {
		roleService.deleteRole(username);
	}
}

package internship.lms.roles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.view.View;

@RestController
@CrossOrigin
public class RoleController {
	
	@Autowired 
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/roles")
	@JsonView(View.UserNameAlso.class)
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/rolecheck/{username}") 
	public boolean checkRole(@PathVariable String username) {
		return roleService.checkRole(username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/role")
	public String getRole() {
		return "Please enter a valid id";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/role/{username}")
	@JsonView(View.UserNameAlso.class)
	public Role getRole(@PathVariable String username) {
		return roleService.getRole(username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/authentication", produces = "application/json")
	public boolean authentication(@RequestParam(required=true) String username,@RequestParam(required=true) String password) {
		return roleService.authentication(username,password);
	}

	@RequestMapping(method=RequestMethod.POST, value="/admin/role/{username}") 
	public void addRole(@PathVariable String username) {
		roleService.addRole("ROOT_USER", username);
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


package internship.lms.roles;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles() {
		 List<Role> roles = new ArrayList<>();
		 roleRepository.findAll().forEach(roles::add);
		 return roles;
	}
	 
	public Role getRole(String username) {
		return roleRepository.findByuserUname(username);
	}

	public void addRole(String role, String username) {
		Role rol = roleRepository.findByuserUname(username);
		rol.setRole(role);
		roleRepository.save(rol);
	}
	
	public void deleteRole(String username) {
		Role rol = roleRepository.findByuserUname(username);
		roleRepository.delete(rol);
	}

	public boolean checkRole(String username) {
		Role rol = roleRepository.findByuserUname(username); 
		if(rol.getUsername()!=null)	{
			return true;
		}
		else {
			return false;
		}
		}
	}

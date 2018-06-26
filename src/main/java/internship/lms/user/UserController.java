package internship.lms.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/usercheck") 
	public boolean checkUserId(@RequestBody String uname) {
		return userService.checkUserUname(uname);
	}
	
	@RequestMapping("/user")
	public String getUser() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/user/{uname}")
	public User getUser(@PathVariable String uname) {
		return userService.getUser(uname);
	}

	@RequestMapping(method=RequestMethod.POST, value="/user") 
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{uname}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/{uname}")
	public void deleteUser(@PathVariable String uname) {
		userService.deleteUser(uname);
	}
}


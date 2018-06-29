package internship.lms.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.book.Book;
import internship.lms.view.View;

@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/admin/users")
	@JsonView(View.UserWithoutBooks.class)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/usercheck/{uname}") 
	public boolean checkUserId(@PathVariable String uname) {
		return userService.checkUserUname(uname);
	}
	
	@RequestMapping("/user")
	public String getUserr() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/userforgetpass/{pno}")
	public boolean checkUserPno(@PathVariable long pno) {
		return userService.checkUserPno(pno);
	}
	
	@RequestMapping("/userforgetpass/true/{pno}")
	@JsonView(View.UserLoginDetails.class)
	public User getUnameAndPass(@PathVariable long pno) {
		return userService.getUserByPno(pno);
	}
	
	@RequestMapping("/userforgetpass/false") 
	public String getUnameAndPass() {
		return "No user with given phone number exists";
	}
	
	@RequestMapping("/admin/user/{uname}")
	@JsonView(View.UserWithoutBooks.class)
	public User getUser(@PathVariable String uname) {
		return userService.getUser(uname);
	}
	
	@RequestMapping("/user/{uname}/issuedbooks")
	@JsonView(View.IssuedBooks.class)
	public List<Book> getBooks(@PathVariable String uname) {
		return userService.getBooks(uname);
	}

	@RequestMapping(method=RequestMethod.POST, value="/adduser") 
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{uname}/newbook") 
	public boolean issueBook(@RequestBody String bname, @PathVariable String uname) {
		return userService.issueBook(bname,uname);
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


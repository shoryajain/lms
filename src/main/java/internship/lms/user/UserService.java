package internship.lms.user;

import java.util.ArrayList;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import internship.lms.book.Book;
import internship.lms.book.BookRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository br;
	
	public boolean checkUserPno(long pno) {
		User user = userRepository.findByPno(pno);
		if(user.getAge() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public User getUserByPno(long pno) {
		return userRepository.findByPno(pno);
	}
	
	public List<User> getAllUsers() {
		 List<User> users = new ArrayList<>();
		 userRepository.findAll().forEach(users::add);
		 return users;
	}
	 
	public User getUser(String uname) {
		return userRepository.findOne(uname);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String uname) {
		userRepository.delete(uname);
	}

	public boolean checkUserUname(String uname) {
		return userRepository.exists(uname);
	}

	public List<Book> getBooks(String uname) {
		return userRepository.findOne(uname).getBooks();
	}

	public boolean issueBook(String bname, String uname) {
		if(br.findByName(bname).getCopies()>br.findByName(bname).getIcopies()){
			User u = userRepository.findOne(uname);
			u.issuingBook(br.findByName(bname));
			userRepository.save(u);
			br.findByName(bname).issueCopy();
			br.save(br.findByName(bname));
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean authentication(String username, String password) {
		if(this.checkUserUname(username)) {
			if(this.getUser(username).getPass().equals(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public void updateRole(String role, String username) {
		this.getUser(username).setRole(role);
		
	}
}

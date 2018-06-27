package internship.lms.user;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
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
	
	//id not passed here ^
	
	public void deleteUser(String uname) {
		userRepository.delete(uname);
	}

	public boolean checkUserUname(String uname) {
		return userRepository.exists(uname);
	}

}

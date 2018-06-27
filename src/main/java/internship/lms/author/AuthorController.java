package internship.lms.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@Autowired 
	private AuthorService authorService;
	
	@RequestMapping("/authors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@RequestMapping("/authorcheck/{id}") 
	public boolean checkAuthorId(@PathVariable String id) {
		return authorService.checkAuthorId(id);
	}
	
	@RequestMapping("/author")
	public String getAuthor() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/author/{id}")
	public Author getAuthor(@PathVariable String id) {
		return authorService.getAuthor(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/author") 
	public void addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/author/{id}")
	public void updateAuthor(@RequestBody Author author) {
		authorService.updateAuthor(author);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/author/{id}")
	public void deleteAuthor(@PathVariable String id) {
		authorService.deleteAuthor(id);
	}
}

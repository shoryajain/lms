package internship.lms.author;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAllAuthors() {
		 List<Author> authors = new ArrayList<>();
		 authorRepository.findAll().forEach(authors::add);
		 return authors;
	}
	 
	public boolean checkAuthorId(String id) {
		return authorRepository.exists(id);
	}
	
	public Author getAuthor(String id) {
		return authorRepository.findOne(id);
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void deleteAuthor(String id) {
		authorRepository.delete(id);
	}

}

package internship.lms.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/bookcheck") 
	public boolean checkBookId(@RequestBody long id) {
		return bookService.checkBookId(id);
	}
	
	@RequestMapping("/book")
	public String getBook() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/book/{uname}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/book/{authorId}") 
	public void addTopic(@RequestBody Book book, @PathVariable String authorId) {
		bookService.addBook(book, authorId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/book/{uname}")
	public void updateTopic(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/book/{id}")
	public void deleteTopic(@PathVariable long id) {
		bookService.deleteBook(id);
	}
}

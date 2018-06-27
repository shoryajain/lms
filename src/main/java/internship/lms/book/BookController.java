package internship.lms.book;

import java.util.List;
import java.util.Set;

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
	
	@RequestMapping("/bookcheck/{id}") 
	public boolean checkBookId(@PathVariable long id) {
		return bookService.checkBookId(id);
	}
	
	@RequestMapping("/book")
	public String getBook() {
		return "Please enter a valid id";
	}
	
	@RequestMapping("/book/id/{id}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping("/book/name/{name}")
	public Book getBookByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}
	
	@RequestMapping("/book/author/{name}")
	public Book getBookByAuthorName(@PathVariable String name) {
		return bookService.getBookByAuthorName(name);
	}
	
	@RequestMapping("/books/genres")
	public Set<String> getGenresOnly() {
		return bookService.getGenresOnly();
	}
	
	@RequestMapping("/books/authors")
	public Set<String> getAuthorNamesOnly() {
		return bookService.getAuthorNamesOnly();
	}

	@RequestMapping("/books/total")
	public int totalBooks() {
		return bookService.totalBooks();
	}
	
	@RequestMapping("/books/total/unique")
	public int totalUniqueBooks() {
		return bookService.totalUniqueBooks();
	}
	
	@RequestMapping("/books/total/issued")
	public int totalIsseudBooks() {
		return bookService.totalIssuedBooks();
	}
	
	@RequestMapping("/books/total/issued/author/{name}")
	public Set<Book> totalIssuedBooksByAuthor(@PathVariable String name) {
		return bookService.totalIssuedBooksByAuthor(name);
	}
	
	@RequestMapping("/books/total/issued/book/{name}")
	public Set<Book> totalIssuedBooksByBookName(@PathVariable String name) {
		return bookService.totalIssuedBooksByBookName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/book/{authorId}") 
	public void addTopic(@RequestBody Book book, @PathVariable String authorId) {
		bookService.addBook(book, authorId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/book/{id}")
	public void updateTopic(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/book/{id}")
	public void deleteTopic(@PathVariable long id) {
		bookService.deleteBook(id);
	}
}

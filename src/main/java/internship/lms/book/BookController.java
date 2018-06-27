package internship.lms.book;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.view.View;

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
	
	@RequestMapping("/book/{id}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping("/book/{name}")
	public Book getBookByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}
	
	@RequestMapping("/books/genres")
	@JsonView(View.GenresOnly.class)
	public List<Book> getGenresOnly() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/books/authors")
	@JsonView(View.AuthorNamesOnly.class)
	public List<Book> getAuthorNamesOnly() {
		return bookService.getAllBooks();
	}

	@RequestMapping("/books/total")
	public int totalBooks() {
		return bookService.totalBooks();
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

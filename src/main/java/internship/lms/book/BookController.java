package internship.lms.book;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.view.View;


@RestController
@CrossOrigin
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/books")
	@JsonView(View.AllBookDetails.class)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/bookcheck/{id}") 
	public boolean checkBookId(@PathVariable long id) {
		return bookService.checkBookId(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/book")
	public String getBook() {
		return "Please enter a valid id";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/book/id/{id}")
	@JsonView(View.AllBookDetails.class)
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/book/name/{name}")
	@JsonView(View.MainDetails.class)
	public Book getBookByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/book/author/{name}")
	@JsonView(View.MainDetails.class)
	public Book getBookByAuthorName(@PathVariable String name) {
		return bookService.getBookByAuthorName(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/book/lang/{lang}")
	@JsonView(View.MainDetails.class)
	public Book getBookByLang(@PathVariable String lang) {
		return bookService.getBookByLang(lang);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/books/genres")
	public Set<String> getGenresOnly() {
		return bookService.getGenresOnly();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/books/authors")
	public Set<String> getAuthorNamesOnly() {
		return bookService.getAuthorNamesOnly();
	}

	@RequestMapping(method = RequestMethod.GET, value="/admin/books/total")
	public int totalBooks() {
		return bookService.totalBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/books/total/unique")
	public int totalUniqueBooks() {
		return bookService.totalUniqueBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/books/total/issued")
	public int totalIsseudBooks() {
		return bookService.totalIssuedBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/books/total/issued/author/{name}")
	@JsonView(View.AllBookDetails.class)
	public Set<Book> totalIssuedBooksByAuthor(@PathVariable String name) {
		return bookService.totalIssuedBooksByAuthor(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/books/total/issued/book/{name}")
	@JsonView(View.AllBookDetails.class)
	public Set<Book> totalIssuedBooksByBookName(@PathVariable String name) {
		return bookService.totalIssuedBooksByBookName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/admin/book/{authorId}") 
	public void addBook(@RequestBody Book book, @PathVariable String authorId) {
		bookService.addBook(book, authorId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admin/book/{id}")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/book/{id}")
	public void deleteBook(@PathVariable long id) {
		bookService.deleteBook(id);
	}
}

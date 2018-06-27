package internship.lms.book;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import internship.lms.author.AuthorService;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService as;
	
	public List<Book> getAllBooks() {
		 List<Book> books = new ArrayList<>();
		 bookRepository.findAll().forEach(books::add);
		 return books;
	}
	 
	public boolean checkBookId(long id) {
		return bookRepository.exists(id);
	}
		
	public Book getBookByName(String name) {
		return bookRepository.findByName(name);
	}
	
	public Book getBook(long id) {
		return bookRepository.findOne(id);
	}

	public void addBook(Book book, String authorId) {
		book.setAuthor(as.getAuthor(authorId));
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	public void deleteBook(long id) {
		bookRepository.delete(id);
	}
	
	public int totalBooks() {
		int num = 0;
		List<Book> books = this.getAllBooks();
		for(Book b: books) {
			num = num+b.getCopies();
		}
		return num;
	}
	
	public int totalIssuedBooks() {
		int num = 0;
		List<Book> books = this.getAllBooks();
		for(Book b: books) {
			num = num+b.getIcopies();
		}
		return num;
	}
}

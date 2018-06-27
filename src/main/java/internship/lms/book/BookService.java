package internship.lms.book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public Book getBookByAuthorName(String name) {
		return bookRepository.findByauthorName(name);
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
	
	public Set<String> getGenresOnly() {
	Set<String> genres = new HashSet<>();
	List<Book> boks = this.getAllBooks();
	for(Book b: boks) {
			genres.add(b.getGenre());
		}
	return genres;
	}
	
	public Set<String> getAuthorNamesOnly() {
		Set<String> authorNames = new HashSet<>();
		List<Book> boks = this.getAllBooks();
		for(Book b: boks) {
				authorNames.add(b.getAuthor().getName());
			}
		return authorNames;
		}
	
	public int totalBooks() {
		int num = 0;
		List<Book> books = this.getAllBooks();
		for(Book b: books) {
			num = num+b.getCopies();
		}
		return num;
	}
	

	public int totalUniqueBooks() {
		int num = 0;
		List<Book> books = this.getAllBooks();
		for(Book b: books) {
			num = num++;
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
	
	public Set<Book> totalIssuedBooksByAuthor(String name) {
		Set<Book> books = new HashSet<>();
		List<Book> boks = this.getAllBooks();
		for(Book b: boks) {
			if(b.getIcopies()>0) {
				if(b.getAuthor().getName().equals(name))
					books.add(b);
			}
		}
		return books;
	}
	
	public Set<Book> totalIssuedBooksByBookName(String name) {
		Set<Book> books = new HashSet<>();
		List<Book> boks = this.getAllBooks();
		for(Book b: boks) {
			if(b.getIcopies()>0) {
				if(b.getName().equals(name))
					books.add(b);
			}
		}
		return books;
	}
}

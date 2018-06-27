package internship.lms.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.book.Book;
import internship.lms.view.View;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@JsonView(View.UserLoginDetails.class)
	private String uname;
	@JsonView(View.UserLoginDetails.class)
	private String pass;
	@JsonView(View.UserWithoutBooks.class)
	private String fname;
	@JsonView(View.UserWithoutBooks.class)
	private String lname;
	@JsonView(View.UserWithoutBooks.class)
	private int age;
	@JsonView(View.UserWithoutBooks.class)
	private long pno;
	@JsonView(View.UserWithoutBooks.class)
	private String email;	
	
	@OneToMany
	@JoinColumn(name = "book_id", nullable=true)
	@JsonView(View.IssuedBooks.class)
	private List<Book> books;
	
	public User() {
		super();
		this.age=0;
	}

	public User(String uname, String pass, String fname, String lname, int age, long pno, String email, List<Book> books) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pno = pno;
		this.email = email;
		this.books = books;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPno() {
		return pno;
	}

	public void setPno(long pno) {
		this.pno = pno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBook(List<Book> books) {
		this.books = books;
	}
	
	public void issuingBook(Book b) {
		this.books.add(b);
	}
}

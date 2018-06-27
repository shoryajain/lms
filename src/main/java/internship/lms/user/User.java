package internship.lms.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import internship.lms.book.Book;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String uname;
	private String pass;
	private String fname;
	private String lname;
	private int age;
	private long pno;
	private String email;	
	
	@OneToMany
	@JoinColumn(name = "book_id", nullable=true)
	private List<Book> book;
	
	public User() {
		super();
		this.age=0;
	}

	public User(String uname, String pass, String fname, String lname, int age, long pno, String email, List<Book> book) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pno = pno;
		this.email = email;
		this.book = book;
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
	
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
}

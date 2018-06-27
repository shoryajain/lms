package internship.lms.author;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import internship.lms.view.View;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	private String id;
	private String email;
	@JsonView(View.AuthorNamesOnly.class)
	private String name;
	private int age;
	private long pno;
	
	public Author() {
		super();
	}
	
	public Author(String id, String email, String name, int age, long pno) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.pno = pno;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

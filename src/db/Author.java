package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
public class Author implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable=false)
	private String name;
	@ManyToMany(mappedBy="idauthors")
	private Collection<Book> idbooks;

	public Author(){};
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public Collection<Book> getIdbooks(){
		return idbooks;
	}
	public void setIdbooks(Collection<Book> idbooks){
		this.idbooks=idbooks;
	}
}

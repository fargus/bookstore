package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="BOOKS")
public class Book implements Serializable{
	 
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable=false)
	private String title;
	@Column(nullable=false)
	private float price;
	@ManyToMany
	 @JoinTable(name="A2B",
		        joinColumns=
		            @JoinColumn(name="IDBooks", referencedColumnName="ID"),
		        inverseJoinColumns=
		            @JoinColumn(name="IDAuthors", referencedColumnName="ID")
		        
		        )
	private Collection<Author> idauthors;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="book")
	private Collection<Sellhistory> sellhistory;
	
	public Book(){};
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	
	public float getPrice(){
		return price;
	}
	public void setPrice(float price){
		this.price=price;
	}

	public void setIdauthors(Collection<Author> idauthors) {
		this.idauthors = idauthors;
	}
	public Collection<Author> getIdauthors() {
		return idauthors;
	}
	
	public void setSellhistory(Collection<Sellhistory> sellhistory) {
		this.sellhistory = sellhistory;
	}
	public Collection<Sellhistory> getSellhistory() {
		return sellhistory;
	}
	
	
}
package db;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Sellhistory")
public class Sellhistory implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private Date date;
	@ManyToOne
    @JoinColumn(name="idclients",nullable = false)
	private Client client;
	@ManyToOne
    @JoinColumn(name="idbooks",nullable = false)
	private Book book;
	@Column(nullable=false)
	private float price;
	
	public Sellhistory(){};
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public float getPrice(){
		return price;
	}
	public void setPrice(float price){
		this.price=price;
	}
	
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date=date;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}
}

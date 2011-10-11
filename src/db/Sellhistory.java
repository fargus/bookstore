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
	private Clients client;
	@ManyToOne
    @JoinColumn(name="idbooks",nullable = false)
	private Books book;
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

	public void setBook(Books book) {
		this.book = book;
	}

	public Books getBook() {
		return book;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Clients getClient() {
		return client;
	}
}

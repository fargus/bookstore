package db;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Sellhistory")
public class Sellhistory implements Serializable{
	
	private int id;
	private Date date;
	private int idclients;
	private int idbooks;
	private float price;
	
	public Sellhistory(){};
	
	@Id
	@GeneratedValue
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
	
	
	public int getIdclients(){
		return idclients;
	}
	public void setIdclients(int idclients){
		this.idclients=idclients;
	}
	
	
	public int getIdbooks(){
		return idbooks;
	}
	public void setIdbooks(int idbooks){
		this.idbooks=idbooks;
	}
	
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date=date;
	}
}

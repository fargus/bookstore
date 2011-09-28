package db;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Clients implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy="idclients")
	private Collection<Sellhistory> sellhistory;
	
	public Clients(){};
	
	
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

	
	public void setSellhistory(Collection<Sellhistory> sellhistory) {
		this.sellhistory = sellhistory;
	}

	public Collection<Sellhistory> getSellhistory() {
		return sellhistory;
	}
}

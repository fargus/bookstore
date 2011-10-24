package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
// FIXME : почему класс называется во мн.ч.
public class Client implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable=false)
	private String name;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private Collection<Sellhistory> sellhistory;
	
	public Client(){};
	
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

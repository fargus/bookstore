package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
public class Authors implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable=false)
	private String name;
	@ManyToMany(mappedBy="idauthors")
	private Collection<Books> idbooks;

	public Authors(){};
	
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
	
	public Collection<Books> getIdbooks(){
		return idbooks;
	}
	public void setIdbooks(Collection<Books> idbooks){
		this.idbooks=idbooks;
	}
}

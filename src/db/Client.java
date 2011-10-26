package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Client implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private String name;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private Collection<Sellhistory> sellhistory;
	@Column(nullable=false)
	private boolean admin;
	@Column(unique=true, nullable=false)
	private String login;
	
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

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}
}

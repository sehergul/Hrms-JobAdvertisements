package com.example.hrmsSpringBoot.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "system_staffs")
public class SystemStaff extends User{
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	public SystemStaff() {
		super();
	}


	public SystemStaff(int id, String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	

}
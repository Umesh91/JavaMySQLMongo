/**
 * 
 */
package com.MySQLHibernateCRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author A631954
 *
 */

@Entity
@Table(name="student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
	
	public Student() 
	{
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String lastname, String email) 
	{
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + "]";
	}
}

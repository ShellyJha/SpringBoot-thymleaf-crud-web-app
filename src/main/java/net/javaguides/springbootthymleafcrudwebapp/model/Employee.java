package net.javaguides.springbootthymleafcrudwebapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(name = "first_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "email")
	public String email;

	/**
	 * @return the id
	 */
	public long getid() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setid(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getfirstname() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setfirstname(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastname
	 */
	public String getlastname() {
		return lastName;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setlastname(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}

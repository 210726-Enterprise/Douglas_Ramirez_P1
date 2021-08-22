package com.revature.orm.model;

import java.io.Serializable;
import com.revature.orm.annotations.Column;
import com.revature.orm.annotations.Entity;
import com.revature.orm.annotations.Id;
import com.revature.orm.annotations.JoinColumn;

// this class will be referred to as an ENTITY in our database
@Entity(tableName = "employees")
public class User implements Serializable {

	@Id(columnName = "employee_id")
	private int employee_id;

	@Column(columnName = "first_name")
	private String firstname;

	@Column(columnName = "last_name")
	private String lastname;

	@Column(columnName = "email")
	private String email;

	public User() {
		super();
	}

	public User(int employee_id, String firstname, String lastname, String email) {
		super();
		this.employee_id = employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	public String toString() {
		return "User [id=" + employee_id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailadress=" + email
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}



}

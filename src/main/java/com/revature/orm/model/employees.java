package com.revature.orm.model;

import java.io.Serializable;
import com.revature.orm.annotations.Column;
import com.revature.orm.annotations.Entity;
import com.revature.orm.annotations.Id;
import com.revature.orm.annotations.Table;
//import com.revature.orm.annotations.JoinColumn;

// this class will be referred to as an ENTITY in our database
@Entity(entityName = "employees")
public class employees implements Serializable {

	@Id(columnName = "employee_id")
	private int employee_id;

	@Column(columnName = "first_name")
	private String first_name;

	@Column(columnName = "last_name")
	private String last_name;

	@Column(columnName = "email")
	private String email;

	public employees() {
		super();
	}

	public employees(int employee_id, String firstname, String lastname, String email) {
		super();
		this.employee_id = employee_id;
		this.first_name = firstname;
		this.last_name = lastname;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "employees{" +
				"employee_id=" + employee_id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
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
		employees other = (employees) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}



}

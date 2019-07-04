package com.revature.pojo;

public class Person {
	
	private int id;
	private static String firstname;
	private static String lastname;
	private static String username;
	private static String password;
	
	
	
	
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (firstname == null) {
			if (Person.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(Person.firstname)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastname == null) {
			if (Person.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(Person.lastname)) {
			return false;
		}
		if (password == null) {
			if (Person.password != null) {
				return false;
			}
		} else if (!password.equals(Person.password)) {
			return false;
		}
		if (username == null) {
			if (Person.username != null) {
				return false;
			}
		} else if (!username.equals(Person.username)) {
			return false;
		}
		return true;
	}
	public Person() {
		super();
		
	}
	public Person( String firstname, String lastname, String username, String password) {
		
		Person.firstname = firstname;
		Person.lastname = lastname;
		Person.username = username;
		Person.password = password;
	}
	public Person(int id, String firstname, String lastname, String username, String password) {
		this.id = id;
		Person.firstname = firstname;
		Person.lastname = lastname;
		Person.username = username;
		Person.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		Person.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		Person.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		Person.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Person.password = password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]\n";
	}

}

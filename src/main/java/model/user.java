package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class user {
   

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name,address,email,password;
private long contact;
private String dob;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", password=" + password
			+ ", contact=" + contact + ", dob=" + dob + "]";
}


}
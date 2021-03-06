package io.aval.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table
@NamedQueries (
		@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u WHERE u.email= :pEmail")
)
public class User {

	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
}

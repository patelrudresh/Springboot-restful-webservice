package com.RestApiMvc.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
		@Column(nullable=false)
	String firstName;
		@Column(nullable=false)
	String lastName;
		@Column(nullable = false,unique = true)
	String email;
}

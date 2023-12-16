package com.unittesting.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {

	@Id
	private Integer id;
	private String name;
	private String city;
	private Integer age;

}

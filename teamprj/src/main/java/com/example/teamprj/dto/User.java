package com.example.teamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int uno;
	private String id;
	private String pw;
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
}

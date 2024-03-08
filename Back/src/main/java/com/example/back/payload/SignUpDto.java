package com.example.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
	private String userFirstname;
	private String userLastname;
	private String userEmail;
	private String userPhone;
	private String userPassword;
}

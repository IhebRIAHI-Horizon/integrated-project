package com.example.back.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="user")
public class User implements UserDetails{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="user_firstname")
	private String userFirstname;

	@Column(name="user_lastname")
	private String userLastname;

	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_phone")
	private String userPhone;

	@Column(name="user_password")
	private String userPassword;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName = "role_id", nullable =  false)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.getRoleName()));
	}

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}

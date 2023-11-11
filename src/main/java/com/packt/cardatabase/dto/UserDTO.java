package com.packt.cardatabase.dto;

import com.packt.cardatabase.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private String role;
	
	public UserDTO(final User entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.password = entity.getPassword();
		this.role = entity.getRole();
	}
	
	public static User toEntity(final UserDTO dto) {
		return User.builder()
				.id(dto.getId())
				.username(dto.getUsername())
				.password(dto.getPassword())
				.role(dto.getRole())
				.build();
	}
}

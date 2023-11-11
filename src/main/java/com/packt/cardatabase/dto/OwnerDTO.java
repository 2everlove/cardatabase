package com.packt.cardatabase.dto;

import java.util.List;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerDTO {
	private long ownerid;
	private String firstname, lastname;
	private List<Car> cars;
	
	public OwnerDTO(final Owner entity) {
		this.ownerid = entity.getOwnerid();
		this.firstname = entity.getFirstname();
		this.lastname = entity.getLastname();
		this.cars = entity.getCars();
	}
	
	public static Owner toEntity(final OwnerDTO dto) {
		return Owner.builder()
				.ownerid(dto.getOwnerid())
				.firstname(dto.getFirstname())
				.lastname(dto.getLastname())
				.cars(dto.getCars())
				.build();
	}
}

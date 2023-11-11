package com.packt.cardatabase.dto;

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
public class CarDTO {
	private long id;
	private String brand, model, color, registerNumber;
	private int year;
	private int price;
	private Owner owner;
	
	public CarDTO(Car entity) {
		this.id = entity.getId();
		this.brand = entity.getBrand();
		this.model = entity.getModel();
		this.color = entity.getColor();
		this.registerNumber = entity.getRegisterNumber();
		this.year = entity.getYear();
		this.price = entity.getPrice();
		this.owner = entity.getOwner();
	}
	
	public static Car toEntity(final CarDTO dto) {
		return Car.builder()
				.id(dto.getId())
				.brand(dto.getBrand())
				.model(dto.getModel())
				.color(dto.getColor())
				.registerNumber(dto.getRegisterNumber())
				.year(dto.getYear())
				.price(dto.getPrice())
				.owner(dto.getOwner())
				.build();
	}
}

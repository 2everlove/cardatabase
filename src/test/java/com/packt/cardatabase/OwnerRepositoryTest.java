package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardatabase.dto.OwnerDTO;
import com.packt.cardatabase.persistence.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private OwnerRepository repository;
	
	@Test
	void saveOwner() {
		OwnerDTO dto = new OwnerDTO();
		dto.setFirstname("Lucy");
		dto.setLastname("Smith");
		repository.save(OwnerDTO.toEntity(dto));
		assertThat(repository.findByFirstname("Lucy").isPresent()).isTrue();
	}
	
	@Test
	void deleteOwners() {
		OwnerDTO dto = new OwnerDTO();
		dto.setFirstname("Lisa");
		dto.setLastname("Morrison");
		repository.save(OwnerDTO.toEntity(dto));
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}
	
}

package com.packt.cardatabase.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.cardatabase.domain.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Optional<Owner> findByFirstname(String firstName);
}

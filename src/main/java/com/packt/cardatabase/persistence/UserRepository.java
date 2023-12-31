package com.packt.cardatabase.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.packt.cardatabase.domain.User;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}

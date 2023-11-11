package com.packt.cardatabase.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.packt.cardatabase.domain.Car;

@Repository
//@RepositoryRestResource(path="vehicles")
public interface CarRepository extends org.springframework.data.repository.CrudRepository<Car, Long> {

	List<Car> findByBrandAndModel(String brand, String model);
	
	List<Car> findByBrandOrColor(String brand, String color);
	
	List<Car> findByBrandOrderByYear(String brand);
	
	//@Query("select c from Car c where c.brand = ?1")
	//List<Car> findByBrand(String brand);
	
	@Query("select c from Car c where c.brand like ?1")
	List<Car> findByBrandEndsWith(String brand);
	
	List<Car> findByColor(@Param("color") String color);
	
	List<Car> findByYear(int year);
	
	List<Car> findByBrand(@Param("brand") String brand);
}

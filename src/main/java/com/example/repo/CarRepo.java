package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CarModel;

@Repository
public interface CarRepo extends CrudRepository<CarModel, String>{

	List<CarModel> findByStatus(String status);

}

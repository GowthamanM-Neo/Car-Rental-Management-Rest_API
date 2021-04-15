package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CarModel;
import com.example.repo.CarRepo;

@RestController
public class Controller {

	@Autowired
	CarRepo carRepo;
	
	//save a new car
	@PostMapping("/saveCar")
	public void saveCars(@RequestBody CarModel car) {
		carRepo.save(car);
	}
	
	//get all the cars
	@GetMapping("/getCars")
	public List<CarModel> getCars(){
		return (List<CarModel>) carRepo.findAll();
	}
	
	//get a particular car
	@GetMapping("getCar")
	public Optional<CarModel> getCar(@RequestParam(name="id") String id){
		return carRepo.findById(id);
	}
	
//	delete a particular car
	@GetMapping("/deleteCar")
	public void deleteCar(@RequestParam(name="id") String id) {
		carRepo.deleteById(id);
	}
	
	//edit car details
	@PostMapping("/editCar")
	public void editCar(@RequestBody Map<String,Object> data,@RequestParam(name="id") String id) {
		var a = carRepo.findById(id);
		if(!a.isEmpty()) {
			a.get().setCarModel(data.get("carModel").toString());
			a.get().setCarNo(data.get("carNo").toString());
			a.get().setStatus(data.get("status").toString());
			carRepo.save(a.get());
		}
	}
	
	@GetMapping("/getByStatus")
	public List<CarModel> getByStatus(@RequestParam(name="status") String status){
		return carRepo.findByStatus(status);
	}
}

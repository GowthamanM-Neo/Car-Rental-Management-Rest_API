package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarModel {

	@Id
	private String carId;
	private String carModel;
	private String carNo;
	private String status;
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CarModel [carId=" + carId + ", carModel=" + carModel + ", carNo=" + carNo + ", status=" + status + "]";
	}
}

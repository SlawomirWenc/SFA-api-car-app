package com.example.SFAapicarapp.service;

import com.example.SFAapicarapp.model.Car;
import com.example.SFAapicarapp.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public void addCar(Car car){
        carRepo.save(car);
    }

    public Iterable<Car> findAll(){
        return carRepo.findAll();
    }
}

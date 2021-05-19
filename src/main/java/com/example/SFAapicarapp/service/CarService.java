package com.example.SFAapicarapp.service;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;
import com.example.SFAapicarapp.model.Car;
import com.example.SFAapicarapp.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Car> findCarById(Long id){
        return carRepo.findById(id);
    }

    public Iterable<Car> findCarsByMark(String s){
        return carRepo.findByMark(s);
    }

    public Iterable<Car> findCarsByModel(String s){
        return carRepo.findByModel(s);
    }

    public Iterable<Car> findCarsByYearOfProduction(int i){
        return carRepo.findByYearOfProduction(i);
    }

    public Iterable<Car> findCarsByType(TypeEnum t){
        return carRepo.findByType(t);
    }

    public Iterable<Car> findCarsByEnginePower(int i){
        return carRepo.findByEnginePower(i);
    }

    public Iterable<Car> findCarsByEngineCapacity(double d){
        return carRepo.findByEngineCapacity(d);
    }

    public Iterable<Car> findCarsByGearbox(GearBoxEnum g){
        return carRepo.findByGearbox(g);
    }

    public Iterable<Car> findCarsByFuelType(FuelTypeEnum f){
        return carRepo.findByFuelType(f);
    }
}

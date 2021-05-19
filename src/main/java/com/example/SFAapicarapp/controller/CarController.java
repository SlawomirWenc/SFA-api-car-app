package com.example.SFAapicarapp.controller;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;
import com.example.SFAapicarapp.model.Car;
import com.example.SFAapicarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public Iterable<Car> getCars(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id){
        return carService.findCarById(id);
    }

    @GetMapping("/mark")
    public Iterable<Car> getCarsEqualsMark(@RequestParam String value){
        return carService.findCarsByMark(value);
    }

    @GetMapping("/model")
    public Iterable<Car> getCarsEqualsModel(@RequestParam String value){
        return carService.findCarsByModel(value);
    }

    @GetMapping("/year-of-production")
    public Iterable<Car> getCarsEqualsYearOfProduction(@RequestParam String value){
        return carService.findCarsByYearOfProduction(Integer.valueOf(value));
    }

    @GetMapping("/type")
    public Iterable<Car> getCarsEqualsType(@RequestParam String value){
        return carService.findCarsByType(TypeEnum.valueOf(value));
    }

    @GetMapping("/engine-power")
    public Iterable<Car> getCarsEqualsEnginePower(@RequestParam String value){
        return carService.findCarsByEnginePower(Integer.valueOf(value));
    }

    @GetMapping("/engine-capacity")
    public Iterable<Car> getCarsEqualsEngineCapacity(@RequestParam String value){
        return carService.findCarsByEngineCapacity(Double.valueOf(value));
    }

    @GetMapping("/gearbox")
    public Iterable<Car> getCarsEqualsGearbox(@RequestParam String value){
        return carService.findCarsByGearbox(GearBoxEnum.valueOf(value));
    }

    @GetMapping("/fuel-type")
    public Iterable<Car> getCarsEqualsFuelType(@RequestParam String value){
        return carService.findCarsByFuelType(FuelTypeEnum.valueOf(value));
    }

    @GetMapping("/{id}/{value}")
    public String getSingleDataFromCar(@PathVariable Long id, @PathVariable String value){
        Optional<Car> car = carService.findCarById(id);
        if(car.isPresent()){
            switch (value) {
                case "mark" -> { return car.get().getMark(); }
                case "model" -> { return car.get().getModel(); }
                case "yearOfProduction" -> { return String.valueOf(car.get().getYearOfProduction()); }
                case "type" -> { return String.valueOf(car.get().getType()); }
                case "enginePower" -> { return String.valueOf(car.get().getEnginePower()); }
                case "engineCapacity" -> { return String.valueOf(car.get().getEngineCapacity()); }
                case "gearbox" -> { return String.valueOf(car.get().getGearbox()); }
                case "fuelType" -> { return  String.valueOf(car.get().getFuelType()); }
                default -> { return "value not recognize"; }
            }
        }
        return "Car with id [" + id + "] not found";
    }

}

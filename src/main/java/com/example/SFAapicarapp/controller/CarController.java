package com.example.SFAapicarapp.controller;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;
import com.example.SFAapicarapp.model.Car;
import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.service.CarService;
import com.example.SFAapicarapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    private TokenService tokenService;

    @Autowired
    public CarController(CarService carService, TokenService tokenService) {
        this.carService = carService;
        this.tokenService = tokenService;
    }

    @GetMapping("/all")
    public Iterable<Car> getCars(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id, @RequestParam String api_key){
        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            if(carService.findCarById(id).isPresent()){
                return carService.findCarById(id);
            }
                throw new RuntimeException("Car not found");
        }
            throw new RuntimeException("Token not found");
    }


    @GetMapping("/mark")
    public Iterable<Car> getCarsEqualsMark(@RequestParam String value, @RequestParam String api_key){
        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByMark(value);
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/model")
    public Iterable<Car> getCarsEqualsModel(@RequestParam String value, @RequestParam String api_key){
        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByModel(value);
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/year-of-production")
    public Iterable<Car> getCarsEqualsYearOfProduction(@RequestParam String value, @RequestParam String api_key){
        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByYearOfProduction(Integer.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/type")
    public Iterable<Car> getCarsEqualsType(@RequestParam String value, @RequestParam String api_key){

        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByType(TypeEnum.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/engine-power")
    public Iterable<Car> getCarsEqualsEnginePower(@RequestParam String value, @RequestParam String api_key){

        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByEnginePower(Integer.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/engine-capacity")
    public Iterable<Car> getCarsEqualsEngineCapacity(@RequestParam String value, @RequestParam String api_key){

        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByEngineCapacity(Double.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/gearbox")
    public Iterable<Car> getCarsEqualsGearbox(@RequestParam String value, @RequestParam String api_key){

        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByGearbox(GearBoxEnum.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/fuel-type")
    public Iterable<Car> getCarsEqualsFuelType(@RequestParam String value, @RequestParam String api_key){

        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
            return carService.findCarsByFuelType(FuelTypeEnum.valueOf(value));
        }
        throw new RuntimeException("Token not found");
    }

    @GetMapping("/{id}/{value}")
    public String getSingleDataFromCar(@PathVariable Long id, @PathVariable String value, @RequestParam String api_key){
        Optional<Token> token = tokenService.findTokenByValue(api_key);
        if(token.isPresent()){
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
        throw new RuntimeException("Token not found");
    }

}

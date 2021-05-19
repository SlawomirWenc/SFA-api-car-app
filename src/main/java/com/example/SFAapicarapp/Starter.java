package com.example.SFAapicarapp;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;
import com.example.SFAapicarapp.model.Car;
import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.service.CarService;
import com.example.SFAapicarapp.service.TokenService;
import com.example.SFAapicarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class Starter {

    private UserService userService;

    private TokenService tokenService;

    private PasswordEncoder passwordEncoder;

    private CarService carService;

    @Autowired
    public Starter(UserService userService, TokenService tokenService, PasswordEncoder passwordEncoder, CarService carService) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.carService = carService;

        // USER
        User user = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
        user.setEnabled(true);
        userService.addUser(user);

        // TOKEN
        String value = UUID.randomUUID().toString();
        Token token = new Token(value, user);
        tokenService.addToken(token);

        // CARS
        carService.addCar(new Car("fiat", "bravo", 2011, TypeEnum.HATCHBACK, 105, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("audi", "q5", 2019, TypeEnum.SUV, 286, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("opel", "vectra", 1999, TypeEnum.SEDAN, 136, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("kia", "soul", 2012, TypeEnum.MINIVAN, 128, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("mercedes-benz", "class S", 2007, TypeEnum.SEDAN, 235, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("dacia", "duster", 2018, TypeEnum.SUV, 114, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("dodge", "challenger", 2017, TypeEnum.COUPE, 717, 6.2, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("volkswagen", "fassat", 2013, TypeEnum.SEDAN, 160, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("subaru", "forester", 2005, TypeEnum.SUV, 158, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.GAS));
        carService.addCar(new Car("peugeot", "508", 2016, TypeEnum.COMBI, 150, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
    }
}

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
        User user = new User("user@user.com", passwordEncoder.encode("user"), "ROLE_USER");
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
        carService.addCar(new Car("tesla", "X", 2017, TypeEnum.SUV, 525,  GearBoxEnum.AUTOMATIC, FuelTypeEnum.ELECTRIC));
        carService.addCar(new Car("fiat", "bravo", 2017, TypeEnum.HATCHBACK, 105, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("audi", "q3", 2012, TypeEnum.SUV, 140, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("bmw", "x6", 2009, TypeEnum.SUV, 407, 4.4, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("bmw", "x2", 2019, TypeEnum.SUV, 140, 1.5, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("toyota", "camry", 2002, TypeEnum.SEDAN, 186, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.GAS));
        carService.addCar(new Car("land rover", "range rover sport", 2016, TypeEnum.SUV, 306, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("skoda", "octavia", 2014, TypeEnum.COMBI, 140, 1.4, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("kia", "stinger", 2018, TypeEnum.COUPE, 255, 2.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("audi", "tt", 2017, TypeEnum.COUPE, 400, 2.5, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("skoda", "roomster", 2011, TypeEnum.MINIVAN, 86, 1.2, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("peugeot", "208", 2020, TypeEnum.SUV, 136,  GearBoxEnum.AUTOMATIC, FuelTypeEnum.ELECTRIC));
        carService.addCar(new Car("bmw", "3", 2018, TypeEnum.SEDAN, 326, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("ford", "f150", 2016, TypeEnum.SUV, 450, 3.5, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("ford", "fiesta", 2016, TypeEnum.HATCHBACK, 95, 1.5, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("alfa romeo", "159", 2006, TypeEnum.SEDAN, 200, 2.4, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("mazda", "cx-5", 2012, TypeEnum.SUV, 150, 2.2, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL)); // 27
        carService.addCar(new Car("audi", "a6", 2013, TypeEnum.SEDAN, 204, 30, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("opel", "astra", 2012, TypeEnum.COMBI, 125, 1.7, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("jaguar", "xf", 2021, TypeEnum.SEDAN, 204, 2.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("volkswagen", "passat", 2016, TypeEnum.SEDAN, 190, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("alfa romeo", "159", 2009, TypeEnum.SEDAN, 140, 1.8, GearBoxEnum.MANUAL, FuelTypeEnum.GAS));
        carService.addCar(new Car("nissan", "qashqai", 2021, TypeEnum.SUV, 158, 1.3, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("chevrolet ", "orlando", 2011, TypeEnum.MINIVAN, 141, 1.8, GearBoxEnum.MANUAL, FuelTypeEnum.GAS));
        carService.addCar(new Car("toyota", "camry", 2002, TypeEnum.SEDAN, 186, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.GAS));
        carService.addCar(new Car("ford", "mondeo", 2012, TypeEnum.COMBI, 163, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("volkswagen", "amarok", 2019, TypeEnum.SUV, 204, 3.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("kia", "sorento", 2020, TypeEnum.SUV, 202, 2.2, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("fiat", "tipo", 2016, TypeEnum.SEDAN, 95, 1.4, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("citroen ", "c4 picasso", 2014, TypeEnum.MINIVAN, 149, 2.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("citroen", "c3", 2020, TypeEnum.HATCHBACK, 110, 1.2, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("seat", "ibiza", 2010, TypeEnum.HATCHBACK, 70, 1.2, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("opel", "corsa", 2013, TypeEnum.HATCHBACK, 192, 1.6, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("volvo", "xc 60 d4", 2018, TypeEnum.SUV, 190, 2.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("ford", "f350", 2019, TypeEnum.SUV, 390, 5.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("nissan", "juke", 2020, TypeEnum.SUV, 117, 1.0, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("mazda", "6", 2019, TypeEnum.COMBI, 194, 2.5, GearBoxEnum.AUTOMATIC, FuelTypeEnum.PETROL));
        carService.addCar(new Car("jeep", "compass", 2017, TypeEnum.SUV, 140, 2.0, GearBoxEnum.MANUAL, FuelTypeEnum.DIESEL));
        carService.addCar(new Car("ford", "mustang", 2015, TypeEnum.COUPE, 317, 2.3, GearBoxEnum.MANUAL, FuelTypeEnum.PETROL));
        carService.addCar(new Car("volkswagen", "tiguan", 2019, TypeEnum.SUV, 240, 2.0, GearBoxEnum.AUTOMATIC, FuelTypeEnum.DIESEL)); // 50
    }
}

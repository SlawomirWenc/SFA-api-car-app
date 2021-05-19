package com.example.SFAapicarapp.model;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;

    private String model;

    private int yearOfProduction;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private int enginePower;

    private double engineCapacity;

    @Enumerated(EnumType.STRING)
    private GearBoxEnum gearbox;

    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    public Car() {
    }

    public Car(String mark, String model, int yearOfProduction, TypeEnum type, int enginePower, double engineCapacity, GearBoxEnum gearbox, FuelTypeEnum fuelType) {
        this.mark = mark;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.type = type;
        this.enginePower = enginePower;
        this.engineCapacity = engineCapacity;
        this.gearbox = gearbox;
        this.fuelType = fuelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public GearBoxEnum getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearBoxEnum gearbox) {
        this.gearbox = gearbox;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

}

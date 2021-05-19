package com.example.SFAapicarapp.repo;

import com.example.SFAapicarapp.enums.FuelTypeEnum;
import com.example.SFAapicarapp.enums.GearBoxEnum;
import com.example.SFAapicarapp.enums.TypeEnum;
import com.example.SFAapicarapp.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

    @Override
    Optional<Car> findById(Long aLong);

    Iterable<Car> findByMark(String s);

    Iterable<Car> findByModel(String s);

    Iterable<Car> findByYearOfProduction(int i);

    Iterable<Car> findByType(TypeEnum t);

    Iterable<Car> findByEnginePower(int i);

    Iterable<Car> findByEngineCapacity(double d);

    Iterable<Car> findByGearbox(GearBoxEnum g);

    Iterable<Car> findByFuelType(FuelTypeEnum f);


}

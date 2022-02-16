package com.baithi_md4.service;

import com.baithi_md4.model.City;
import com.baithi_md4.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService{

    @Autowired
    CityRepo cityRepo;
    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public void save(City city) {
    cityRepo.save(city);
    }

    @Override
    public void delete(long id) {
    cityRepo.deleteById(id);
    }

    @Override
    public City findById(long id) {
        return cityRepo.findById(id).get();
    }

    @Override
    public Page<City> findUsersByName(String name, Pageable pageable) {
        return cityRepo.findAllByName(name,pageable);
    }
}

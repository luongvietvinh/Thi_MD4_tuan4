package com.baithi_md4.repository;

import com.baithi_md4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepo extends PagingAndSortingRepository<City , Long> {
    @Query(value = " select u from City u where u.name like concat('%' ,:name, '%')")
    Page<City> findAllByName(@Param("name") String name, Pageable pageable);
}

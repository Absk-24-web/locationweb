package com.absk.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absk.location.entites.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {



}

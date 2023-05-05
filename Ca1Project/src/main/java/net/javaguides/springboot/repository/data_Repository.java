package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Chicago_data_crime;

@Repository
public interface data_Repository extends JpaRepository<Chicago_data_crime, Long>{

}

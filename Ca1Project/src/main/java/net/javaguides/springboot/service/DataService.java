package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Chicago_data_crime;
//bellow we have our list which will get all data set and select each by ID
public interface DataService {
	List<Chicago_data_crime> getAlldaSet();
	void saveChicago_data(Chicago_data_crime data);
	Chicago_data_crime getChicago_dataById(long id);
	void deleteChicago_dataById(long id);
	Page<Chicago_data_crime> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

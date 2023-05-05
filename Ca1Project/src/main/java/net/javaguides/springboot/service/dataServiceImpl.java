package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Chicago_data_crime;
import net.javaguides.springboot.repository.data_Repository;

@Service
public class dataServiceImpl implements DataService {

	@Autowired
	private data_Repository  dataRepository;

	@Override
	public List<Chicago_data_crime> getAlldaSet() {
		return dataRepository.findAll();
	}

	@Override
	public void saveChicago_data(Chicago_data_crime data) {
		this.dataRepository.save(data);
	}

	@Override
	public Chicago_data_crime getChicago_dataById(long id) {
		Optional<Chicago_data_crime> optional = dataRepository.findById(id);
		Chicago_data_crime data = null;
		if (optional.isPresent()) {
			data = optional.get();
		} else {
			throw new RuntimeException(" Data not found for id :: " + id);
		}
		return data;
	}

	@Override
	public void deleteChicago_dataById(long id) {
		this.dataRepository.deleteById(id);
	}

	@Override
	public Page<Chicago_data_crime> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dataRepository.findAll(pageable);
	}
}

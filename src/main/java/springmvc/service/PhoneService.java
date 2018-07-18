package springmvc.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import springmvc.model.Phone;

public interface PhoneService {
	void create(Phone phone);
	
	void update(Phone phone);
	
	void delete(int id);
	
	Phone findOne(int id);
	
	List<Phone> findAll();
}

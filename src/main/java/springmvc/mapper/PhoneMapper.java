package springmvc.mapper;

import java.util.List;

import springmvc.model.Phone;

public interface PhoneMapper {
	
	void create(Phone phone);
	
	void update(Phone phone);
	
	void delete(int id);
	
	Phone findOne(int id);
	
	List<Phone> findAll();
}

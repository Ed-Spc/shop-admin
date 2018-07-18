package springmvc.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.PhoneMapper;
import springmvc.model.Phone;
import springmvc.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {
	private PhoneMapper phoneMapper;

	@Autowired
	public PhoneServiceImpl(PhoneMapper phoneMapper) {
		this.phoneMapper = phoneMapper;
	}

	public void create(Phone phone) {
		 phoneMapper.create(phone);
	}

	public void update(Phone phone) {
		phoneMapper.update(phone);
	}

	public void delete(int id) {
		phoneMapper .delete(id);
	}

	public Phone findOne(int id) {
		return phoneMapper.findOne(id);
	}

	public List<Phone> findAll() {
		return phoneMapper.findAll();
	}

}

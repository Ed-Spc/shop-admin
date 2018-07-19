package springmvc.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.UserMapper;
import springmvc.model.User;
import springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<User> finAll() {
		
		return userMapper.findAll();
	}



}

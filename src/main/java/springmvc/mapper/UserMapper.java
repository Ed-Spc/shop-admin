package springmvc.mapper;

import java.util.List;

import springmvc.model.User;

public interface UserMapper {

	List<User> findAll();
}

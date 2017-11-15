package org.yangjie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yangjie.entity.User;
import org.yangjie.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;  
	
	
	public List<User> getList(int page, int size) {
		return userRepository.findAll();
	}
	
	public long getCount() {
		return userRepository.count();
	}
	
	public User get(int id) {
		return userRepository.findOne(id);
	}
	
	public User add(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	
}

package org.yangjie.service;

import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
	
	/**
	 * 模拟复杂条件查询
	 * @param username
	 * @param password
	 * @param teamid
	 * @return
	 */
	public List<User> getList(String username, String password, int teamid){
		return userRepository.findAll(new Specification<User>() {
			/**
			 * @param root: 代表查询的实体类. 
			 * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以用来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象. 
			 * @param cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
			 * @return Predicate 类型, 代表一个查询条件. 
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (Objects.nonNull(username)) {
					cb.and(cb.like(root.get("username"), username));
				}
				if (Objects.nonNull(password)) {
					cb.and(cb.equal(root.get("username"), username));
				}
				cb.and(cb.gt(root.get("teamid"), teamid));
				return cb.conjunction();
			}
		});
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

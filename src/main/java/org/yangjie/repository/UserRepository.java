package org.yangjie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.yangjie.entity.User;

/**
 * 实现接口 {@link JpaRepository}
 * spring会自动创建代理实现类操作数据库
 * 操作数据尽量遵守jpa规范,避免不使用原生sql
 * 
 * jpa默认全部方法开启事务, 查询方法只读事务, 其他方法默认事务
 * 
 * 约定关键词
 * find.. get.. count.. delete.. By..
 * and or is not in notIn like between after before isNull isNotNull orderBy 
 * 
 * 自定义sql
 * @Query{@link Query}  @Modifying{@link Modifying}
 * 
 * @author YangJie 
 * @createTime 2017年11月14日 下午9:47:25
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * 符合jpa方法名规范, 会自动生成sql
	 * @param username
	 * @param password
	 * @return
	 */
	User getByUsernameAndPassword(String username, String password);
	
}

package org.yangjie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
 * JpaRepository 继承于 PagingAndSortingRepository 接口, 拥有PagingAndSortingRepository 的所有方法
 * 接口特色： 1. 将一些查询方法的返回类型由Iterable 转换成了 List<T>； 2. 新增了保存或更新等方法。
 * 
 * JpaSpecificationExecutor 不属于Repository 体系。由于JpaSpecificationExecutor 并不继承repository 接口，所以它不能单独使用，只能和jpa Repository 一起用。
 * JpaSpecificationExecutor特色：实现了带条件的查询， 类似于Hibernate 的cretira
 * 
 * @author YangJie 
 * @createTime 2017年11月14日 下午9:47:25
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{
	
	/**
	 * 符合jpa方法名规范, 会自动生成sql
	 * @param username
	 * @param password
	 * @return
	 */
	User getByUsernameAndPassword(String username, String password);
	
}

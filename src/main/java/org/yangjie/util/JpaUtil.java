package org.yangjie.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * JPA工具类
 * @author YangJie 
 * @createTime 2017年11月14日 下午9:38:06
 */
public class JpaUtil {
	
	/**
	 * 构建分页
	 * @param page
	 * @param size
	 * @return
	 */
	public Pageable buildPage(int page, int size) {
		return new PageRequest(page, size);
	}
	
	/**
	 * 构建带排序的分页
	 * 同时使用多个字段排序时, 参考 {@link Sort#and(Sort)}
	 * @see {@link #buildSortAse(String)} || {@link #buildSortDese(String)}
	 * @param page
	 * @param size
	 * @param sort
	 * @return
	 */
	public Pageable buildPageSort(int page, int size, Sort sort) {
		return new PageRequest(page, size, sort);
	}
	
	/**
	 * 构建带正序排列的分页
	 * @param page
	 * @param size
	 * @param property 分页参数
	 * @return
	 */
	public Pageable buildPageSortAsc(int page, int size, String property) {
		return new PageRequest(page, size, Sort.Direction.ASC, property);
	}
	
	/**
	 * 构建带倒序排列的分页
	 * @param page
	 * @param size
	 * @param property 分页参数
	 * @return
	 */
	public Pageable buildPageSortDesc(int page, int size, String property) {
		return new PageRequest(page, size, Sort.Direction.DESC, property);
	}

	/**
	 * 构建正序排列规则
	 * 同时使用多个字段排序时, 参考 {@link Sort#and(Sort)}
	 * @param property
	 * @return
	 */
	public Sort buildSortAse(String property) {
		return new Sort(Sort.Direction.ASC, property);
	}
	
	/**
	 * 构建倒序排列规则
	 * 同时使用多个字段排序时, 参考 {@link Sort#and(Sort)}
	 * @param property
	 * @return
	 */
	public Sort buildSortDese(String property) {
		return new Sort(Sort.Direction.DESC, property);
	}
	
}

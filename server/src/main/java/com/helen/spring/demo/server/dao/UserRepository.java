package com.helen.spring.demo.server.dao;

import com.helen.spring.demo.server.dao.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by JinYang.Qin on 2019-03-05
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}

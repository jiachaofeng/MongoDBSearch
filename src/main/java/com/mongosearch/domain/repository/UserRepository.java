package com.mongosearch.domain.repository;

import com.mongosearch.domain.entity.User;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    public List<User> findByUserName(String userName);
    public List<User> findAllBy(TextCriteria criteria);
}

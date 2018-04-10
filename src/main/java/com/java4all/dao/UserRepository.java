package com.java4all.dao;

import com.java4all.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: momo
 * Date: 2018/3/27
 * Description:
 */
@Transactional
@CacheConfig(cacheNames = "user")
public interface UserRepository extends JpaRepository<User,Long> {

    /**根据userName查询对象*/
    @Cacheable(key = "#p0")
    User findUserByUserName(String userName);

    /**根据id查询对象*/
    @Cacheable(key = "#p0")
    User findById(Integer id);

    /**根据id删除*/
    @CacheEvict(key = "#p0")
    void deleteById(Integer id);

    /**保存或者更新  当有id时就是更新，否则是添加*/
    @Override
    @CachePut(key = "#p0.userName")
    User saveAndFlush(User user);

    /**分页查询*/
    @Override
    @Cacheable(key = "#p0.pageNumber")
    Page<User> findAll(Pageable pageable);
}

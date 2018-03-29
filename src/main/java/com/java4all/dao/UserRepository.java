package com.java4all.dao;

import com.java4all.entity.User;
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
public interface UserRepository extends JpaRepository<User,Long> {


    /**根据id查询对象*/
    User findById(Integer id);

    /**根据id删除*/
    void deleteById(Integer id);

    /**保存或者更新  当有id时就是更新，否则是添加*/
    @Override
    User saveAndFlush(User user);

    /**分页查询*/
    @Override
    Page<User> findAll(Pageable pageable);
}

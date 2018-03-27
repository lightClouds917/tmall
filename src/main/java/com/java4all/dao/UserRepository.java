package com.java4all.dao;

import com.java4all.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: momo
 * Date: 2018/3/27
 * Description:
 */
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {


    User findById(Integer id);

    void deleteById(Integer id);

}

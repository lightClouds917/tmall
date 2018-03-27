package com.java4all.dao;

import com.java4all.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: momo
 * Date: 2018/3/27
 * Description:
 */
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByProvince(String province);

    void deleteById(Integer id);

}

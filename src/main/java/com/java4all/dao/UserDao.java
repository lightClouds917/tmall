package com.java4all.dao;

import com.java4all.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Author: momo
 * Date: 2018/3/29
 * Description:
 */
public interface UserDao {

    User getById(@Param("id")Integer id);
}

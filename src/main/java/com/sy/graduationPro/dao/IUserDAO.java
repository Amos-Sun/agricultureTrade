package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/15.
 */
@Repository(value = "userDAO")
public interface IUserDAO extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.name=:name or u.phone=:phone and u.hasDel=0")
    List<User> findByNameOrPhone(@Param("name") String name, @Param("phone") String phone);

    @Query("select u from User u where u.name=:loginInfo or u.phone=:loginInfo " +
            "and u.password=:password and u.hasDel=0")
    User userLogin(@Param("loginInfo") String loginInfo, @Param("password") String password);

    @Query("select u from User u where u.name=:userName and u.hasDel = 0")
    User findByName(@Param("userName")String name);
}

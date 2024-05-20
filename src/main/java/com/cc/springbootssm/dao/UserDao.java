package com.cc.springbootssm.dao;

import com.cc.springbootssm.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/11/29
 * Time: 17:28
 * Description:
 */
@Repository
public interface UserDao {

    User queryById(Integer id);

}

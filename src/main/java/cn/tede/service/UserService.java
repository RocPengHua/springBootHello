package cn.tede.service;

import cn.tede.pojo.User;

import java.util.List;

/**
 * Created by LYJ on 2017/6/1.
 */
public interface UserService {
    public List<User> findAll();

    public void saveUser(User user);

    public void updateUser(User user);

    public List<User> findUserByAge(Integer age);
}

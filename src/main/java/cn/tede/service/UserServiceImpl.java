package cn.tede.service;

import cn.tede.mapper.UserMapper;
import cn.tede.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LYJ on 2017/6/1.
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    //表示需要添加事务
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
      for (int i=0;i<3;i++){
          user.setId(user.getId()+i);
          userMapper.save(user);
      }
        int a = 1/0;
    }

    @Override
    public void updateUser(User user) {
        /**
         * 如果数据库中 有主键ID那么做修改操作,
         * 如果没有主键ID 做新增操作.
         */
        userMapper.save(user);
    }

    @Override
    public List<User> findUserByAge(Integer age) {
        return userMapper.findByAge(age);
    }
}

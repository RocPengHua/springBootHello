package cn.tede.mapper;

import cn.tede.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LYJ on 2017/6/1.
 */
public interface UserMapper extends JpaRepository<User,Integer>{
    public List<User> findByAge(Integer age);
}

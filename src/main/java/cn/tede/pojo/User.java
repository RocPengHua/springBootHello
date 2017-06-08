package cn.tede.pojo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by LYJ on 2017/6/1.
 */
//@Component
//@ConfigurationProperties(prefix = "person")  //从配置文件中 获取对应的属性
@Entity  //表示与数据库中的表一一对应
public class User {
    @Id  //当前的属性设为主键
    @GeneratedValue //主键自增
    private Integer id;
    @NotEmpty(message = "姓名不能为null")
    private String name;

    @Min(value = 10,message = "年龄不能小于10岁")
    @Max(value = 150,message = "哥们你现实点")
    private Integer age;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

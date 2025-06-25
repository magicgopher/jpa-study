package com.magicgopher.study;

import com.magicgopher.study.entity.User;
import com.magicgopher.study.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.LinkedList;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-25 04:31:02
 * @Version: v1.0.5
 * @Description: 单元测试
 */
@SpringBootTest
@ActiveProfiles("postgresql") // 指定使用application-postgresql.properties配置文件
public class JpaDemo05ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    /**
     * 查询所有
     */
    @Test
    void findAllTest() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    /**
     * 根据id查询
     */
    @Test
    void findById() {
        User user = userRepository.findById(16L).orElse(new User()); // 如果为空，返回一个新的 User 对象
        System.out.println(user);
    }

    /**
     * 保存操作
     */
    @Test
    void save() {
        User user = new User("橙留香", 19, "男");
        System.out.println("保存操作的用户信息:" + user);
        User saveUserInfo = userRepository.save(user);
        System.out.println("保存操作成功后的用户信息:" + saveUserInfo);
    }

    /**
     * 更新操作
     */
    @Test
    void update() {
        // 查询出用户信息
        User user = userRepository.findById(55L).orElseThrow(() -> new RuntimeException("查询的用户信息不存在！"));
        System.out.println("更新前用户信息:" + user);
        // 更新User实体
        user.setName("陆小果");
        user.setAge(17);
        user.setSex("男");
        // save操作更新数据
        User saveUserInfo = userRepository.save(user);
        System.out.println("更新后用户信息:" + saveUserInfo);
    }

    /**
     * 统计表数据
     * SQL的COUNT()函数
     */
    @Test
    void count() {
        long count = userRepository.count();
        System.out.println("tb_user表数有：" + count + "条数据");
    }

    /**
     * 根据id删除
     */
    @Test
    void deleteById() {
        userRepository.deleteById(40L);
    }

    /**
     * 根据多个id删除
     */
    @Test
    void deleteAllById() {
        LinkedList<Long> ids = new LinkedList<>();
        ids.add(31L);
        ids.add(32L);
        ids.add(33L);
        ids.add(34L);
        ids.add(35L);
        userRepository.deleteAllById(ids);
    }

    /**
     * 删除所有
     */
    @Test
    void deleteAll() {
        userRepository.deleteAll();
    }

    /**
     * 根据实体删除
     */
    @Test
    void delete() {
        // 当您调用delete(T entity)并传递一个实体时，不需要该实体的所有属性都匹配才能进行删除。
        // 工作原理：Spring Data JPA 使用实体的主键delete（或标识符）执行删除操作。
        // 当您向该方法提供实体对象时，Spring Data JPA 会从该实体中提取 ID。
        // 然后，它DELETE根据该 ID 向数据库发出 SQL 语句。
        User user = new User();
        user.setId(58L); // 需要ID
        user.setName("雷军"); // 删除时忽略此属性和其他属性
        user.setSex("男");
        userRepository.delete(user);
    }
}

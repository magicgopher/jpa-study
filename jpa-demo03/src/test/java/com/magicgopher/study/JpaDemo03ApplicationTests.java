package com.magicgopher.study;

import com.magicgopher.study.entity.User;
import com.magicgopher.study.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@ActiveProfiles("postgresql") // JUnit Test指定profile
class JpaDemo03ApplicationTests {

    @Autowired
    UserRepository userRepository;

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
    void findByIdTest() {
        // 使用 orElse 查询到不存在的用户信息，直接返回一个默认的User实例
        User user1 = userRepository.findById(111L).orElse(new User());
        System.out.println(user1);
        User user2 = userRepository.findById(11L).orElse(new User());
        System.out.println(user2);
    }

    /**
     * 保存操作
     */
    @Test
    void saveTest() {
        User user = new User("伍六七", 20, "男");
        System.out.println("保存操作的用户信息:" + user);
        User saveUserInfo = userRepository.save(user);
        System.out.println("保存操作成功后的用户信息:" + saveUserInfo);
    }

    /**
     * 根据id删除
     */
    @Test
    void deleteByIdTest() {
        try {
            userRepository.deleteById(50L);
            // 如果没有异常，验证记录是否已被删除
            assertFalse(userRepository.existsById(50L), "记录应该已被删除");
        } catch (Exception e) {
            // 如果抛出异常，测试失败
            fail("删除操作不应该抛出异常: " + e.getMessage());
        }
    }
}

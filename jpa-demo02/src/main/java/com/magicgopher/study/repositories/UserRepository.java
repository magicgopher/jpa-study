package com.magicgopher.study.repositories;

import com.magicgopher.study.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-19 05:11:42
 * @Version: v1.0.2
 * @Description: 用户持久层映射接口
 */
public interface UserRepository extends CrudRepository<User, Long> {

}

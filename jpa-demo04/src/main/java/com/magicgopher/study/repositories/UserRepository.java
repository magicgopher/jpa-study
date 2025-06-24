package com.magicgopher.study.repositories;

import com.magicgopher.study.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-24 07:07:59
 * @Version: v1.0.4
 * @Description: 用户持久层映射接口
 */
public interface UserRepository extends CrudRepository<User, Long> {

}

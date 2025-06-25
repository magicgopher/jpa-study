package com.magicgopher.study.repositories;

import com.magicgopher.study.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-25 04:36:25
 * @Version: v1.0.5
 * @Description: 用户持久层映射接口
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}

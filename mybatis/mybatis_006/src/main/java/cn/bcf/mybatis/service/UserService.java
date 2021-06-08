package cn.bcf.mybatis.service;

import cn.bcf.mybatis.mapper.UserMapper;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 8:02 下午
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<UserEntity> selectAll() {
        return userMapper.selectAll();
    }

    public UserEntity selectById(Integer id) {
        return userMapper.selectById(id);
    }

}

package cn.bcf.mybatis.service;

import cn.bcf.mybatis.entity.UserEntity;
import cn.bcf.mybatis.mapper.UserMapper;
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

}

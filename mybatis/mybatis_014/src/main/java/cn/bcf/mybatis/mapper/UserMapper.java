package cn.bcf.mybatis.mapper;

import cn.bcf.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/7 7:55 下午
 */
@Mapper
public interface UserMapper {

    List<UserEntity> selectAll();

}

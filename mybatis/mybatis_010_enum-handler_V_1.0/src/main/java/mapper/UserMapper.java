package mapper;

import entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> selectAll();

    UserEntity selectById(Integer id);

}

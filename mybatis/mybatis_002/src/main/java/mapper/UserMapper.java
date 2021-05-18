package mapper;

import entity.UserEntity;

import java.util.List;

public interface UserMapper {

    UserEntity selectAll();

    UserEntity selectById(Integer id);

}

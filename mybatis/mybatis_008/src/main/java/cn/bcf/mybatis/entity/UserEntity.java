package cn.bcf.mybatis.entity;

import cn.bcf.mybatis.enums.SexEnum;
import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private SexEnum sex;

}

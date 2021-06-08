package entity;

import enums.SexEnum;
import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private SexEnum sex;

}

package entity;

import enums.NationEnum;
import enums.SexEnum;
import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String username;
    private SexEnum sex;
    private NationEnum nation;

}

package enums;

import annotation.EnumHandler;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/26 7:50 下午
 */
@EnumHandler
public enum SexEnum{

    MAN(3, "男"),
    WOMAN(1, "女")
    ;

    private Integer key;
    private String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}

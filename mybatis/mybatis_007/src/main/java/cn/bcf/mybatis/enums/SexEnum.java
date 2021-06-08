package cn.bcf.mybatis.enums;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/26 7:50 下午
 */
public enum SexEnum implements BaseEnum {

    MAN(1, "男"),
    WOMAN(2, "女")
    ;

    public Integer key;
    public String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public int getKey() {
        return this.key;
    }

}

package enums;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/26 7:50 下午
 */
public enum SexEnum implements BaseEnum {

    MAN(3, "男"),
    WOMAN(1, "女")
    ;

    private Integer key;
    private String value;

    SexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public int getKey() {
        return this.key;
    }

}

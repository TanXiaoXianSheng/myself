package autowire.byName;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/17 15:04
 **/
public class Person {

    private XiaoMing xiaoMing001;

    public XiaoMing getXiaoMing001() {
        return xiaoMing001;
    }

    public void setXiaoMing001(XiaoMing xiaoMing001) {
        this.xiaoMing001 = xiaoMing001;
    }

    public void getMessage(){
        System.out.println(this.xiaoMing001.getName());
    }
}

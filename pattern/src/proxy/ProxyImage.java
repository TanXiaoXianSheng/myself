package proxy;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/11 14:52
 **/
public class ProxyImage implements Image{

    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

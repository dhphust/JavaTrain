package designMode.bridgepatternExample;

public class Client {
    public static void main(String[] args) {
        //设置图像类型
        Image image = new GIFImage();
        //设置图像显示系统
        image.setImageImp(new WindowsImp());
        image.parseFile("梦娜丽莎");

    }
}

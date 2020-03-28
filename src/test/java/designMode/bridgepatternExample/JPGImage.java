package designMode.bridgepatternExample;

public class JPGImage extends Image {
    @Override
    void parseFile(String fileName) {
        Matrix m = new Matrix();
        imageImp.doPaint(m);
        System.out.println(fileName + "--jpg格式");
    }
}

package designMode.bridgepatternExample;

public class BMPImage extends Image {

    @Override
    void parseFile(String fileName) {
        Matrix m = new Matrix();
        imageImp.doPaint(m);
        System.out.println(fileName + "--bmp格式");
    }
}

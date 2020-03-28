package designMode.bridgepatternExample;

public class GIFImage extends Image {
    @Override
    void parseFile(String fileName) {
        Matrix m = new Matrix();
        imageImp.doPaint(m);
        System.out.println(fileName + "--gif格式");
    }
}

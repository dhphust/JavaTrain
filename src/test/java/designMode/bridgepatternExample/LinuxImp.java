package designMode.bridgepatternExample;

public class LinuxImp implements ImageImp {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("linux操作系统--");
    }
}

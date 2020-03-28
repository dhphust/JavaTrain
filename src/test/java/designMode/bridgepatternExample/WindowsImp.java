package designMode.bridgepatternExample;

public class WindowsImp implements ImageImp {

    @Override
    public void doPaint(Matrix matrix) {
        System.out.print("windows系统--");
    }
}

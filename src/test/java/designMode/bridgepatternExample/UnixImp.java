package designMode.bridgepatternExample;

public class UnixImp implements ImageImp {

    @Override
    public void doPaint(Matrix matrix) {
        System.out.print("unix操作系统--");
    }
}

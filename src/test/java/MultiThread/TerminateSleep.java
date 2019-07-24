package MultiThread;

import jdk.nashorn.internal.objects.NativeReferenceError;

/**
 * 通过标志位中断线程
 * 因为stop()、termiate()方法被淘汰
 */
public class TerminateSleep implements Runnable{
    boolean flag = true;
    String name;

    public TerminateSleep(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i =0;
        //关联标识，true->运行，false->中断
        if(flag){
            System.out.println(name + "-->" + i++);
        }
    }
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        TerminateSleep t1 = new TerminateSleep("tom");
        Thread thread = new Thread(t1);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if(i == 90){
                t1.terminate();//线程终止
                System.out.println("结束");
            }
            System.out.println("main-->" + i);

        }
    }
}

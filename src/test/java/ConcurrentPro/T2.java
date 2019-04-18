package ConcurrentPro;

/**
 * synchronized方法执行时，非synchronized方法也可以执行
 */
public class T2 {
    /**
     * 同步方法
     */
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " s1 start");
        try {
            Thread.sleep(500);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " s1 end");

    }
    /**
     * 普通方法
     */
    public void m2(){
        try {
            Thread.sleep(500);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " s2");


    }

    public static void main(String[] args) {
        T2 t2 = new T2();
//        //lamda表达式
        new Thread(()->t2.m1(),"t1").start();
        new Thread(()->t2.m2(),"t2").start();
//
        //写法2
//        new Thread(t2::m1,"t1").start();
//        new Thread(t2::m2,"t2").start();

//        //传统写法1.8之前
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t2.m1();
//            }
//        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t2.m2();
//            }
//        });


    }
}

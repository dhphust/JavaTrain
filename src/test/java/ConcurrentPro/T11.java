package ConcurrentPro;

/**
 * 不要以字符串常量作为锁定对象
 * 下面的例子中，m1、m2锁定的是同一个对象hello
 * 容易导致死锁阻塞
 *
 */
public class T11 {
    String str1 = "hello";
    String str2 = "hello";
    public void m1(){
        synchronized (str1){

        }
    }
    public void m2(){
        synchronized (str2){

        }
    }
}

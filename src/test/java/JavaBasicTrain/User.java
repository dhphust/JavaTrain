package JavaBasicTrain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * builder设计模式
 */
public class User {

    private final String name;
    private final int age;
    private final int money;//可选
    private final int girlFriend;//可选
    private final int car;//可选

    //定义内部类
    public static class Builder{
        //必须参数
        private final String name;
        private final int age;
        //可选参数
        private int money = 0;
        private int girlFriend = 0;
        private int car = 0;

        //构造函数
        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        //定义可选参数
        public Builder money(int value){
            money = value;
            return this;
        }
        public Builder girlFriend(int value){
            girlFriend = value;
            return this;
        }
        public Builder car(int value){
            car = value;
            return this;
        }
        //静态工厂方法
        //设置方法返回自己本身，以便把方法连接起来
        public User build(){
            User user = new User(this);
            if(user.age > 120){
                throw new RuntimeException("param error");
            }
            return user;
        }
    }
    private User(Builder builder){
        name = builder.name;
        age = builder.age;
        money = builder.money;
        girlFriend = builder.girlFriend;
        car = builder.car;
    }



    public static void main(String[] args) {
        //任意加可选参数
      User user = new Builder("tom",123).money(5).car(0).build();
      System.out.println(user.money);
    }
}

package JavaBasicTrain;
import java.time.Instant;
/**
 * 反例代码
 * 超类的构造函数优先于子类，构造器sub还没有机会初始化instant域，
 * 导致最后打印null
 */
public class Super {
    public Super() {//3
        overrideMe();//4
    }
    public void overrideMe(){
        System.out.println("不会执行");
    }
}

final class Sub extends Super{
    private final Instant instant;
    public Sub() {//2
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {//5
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();//1
        sub.overrideMe();//6
    }
}


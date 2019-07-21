package designMode;


/**
 * 静态代理模式
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).marry();//你结婚
        new WeddingCompany(new YourBrother()).marry();//你弟弟结婚
    }
}

interface Marry{
    void marry();
}

//真实角色：You结婚
class You implements Marry{

    @Override
    public void marry() {
        System.out.println("You happy day");
    }
}

//真实角色：YourBrother结婚
class YourBrother implements Marry{

    @Override
    public void marry() {
        System.out.println("YourBrother happy day");
    }
}

//代理角色：婚庆公司
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        ready();//准备工作
        this.target.marry();
        after();//扫尾工作
        
    }

    private void ready() {
        System.out.println("婚庆公司准备工作");
    }

    private void after() {
        System.out.println("扫尾工作");
    }

}

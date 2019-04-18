public class Animal {
    public String name = "父类name";
    public void move(){
        System.out.println("父类move");
    }
    public void content(){
        System.out.println("父类content");
    }
}
class Bird extends Animal{
    public String name = "子类name";
    @Override
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("子类move");
    }
    @Override
    public void content(){
        System.out.println("子类content");
    }

}
class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.name);
        a.move();
        a.content();
        System.out.println("----------------------");
        Animal b = new Bird(); //向上转型由系统自动完成
        //编译时变量/运行时变量
        System.out.println(b.name);
        b.move();
        b.content();
        System.out.println("----------------------");
        Bird c = new Bird();
        System.out.println(c.name);
        c.move();
        c.content();
    }
}


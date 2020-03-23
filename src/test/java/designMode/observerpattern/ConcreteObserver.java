package designMode.observerpattern;

/**
 * 具体观察者:根据目标类的变化，进行响应
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("针对目标对象的变化，" +"观察者"+ name+ "可进行响应处理");
    }
}

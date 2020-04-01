package designMode.mediatorPatternExample;

public class Client {
    public static void main(String[] args) {
        //定义同事对象
        Button button = new Button();
        TextBox textBox = new TextBox();
        ComboBox comboBox = new ComboBox();

        //定义中介者对象
        ConcreteMediator mediator = new ConcreteMediator(button, textBox, comboBox);

        //设置中介
        button.setMediator(mediator);
        textBox.setMediator(mediator);
        comboBox.setMediator(mediator);

        //点击按钮
        button.changed();
        System.out.println("---------------");
        textBox.changed();

    }
}

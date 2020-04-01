package designMode.mediatorPatternExample;

public class ConcreteMediator extends Mediator {
    private Button button;
    private TextBox textBox;
    private ComboBox comboBox;

    public ConcreteMediator(Button button, TextBox textBox, ComboBox comboBox) {
        this.button = button;
        this.textBox = textBox;
        this.comboBox = comboBox;
    }

    @Override
    void componentChanged(Component component) {
        if (component == button) {
            System.out.println("单击添加按钮");
            textBox.update();
            comboBox.update();
        } else if (component == textBox) {
            System.out.println("单击文本框");
            comboBox.update();
        }
    }

}

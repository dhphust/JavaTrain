package designMode.mediatorPatternExample;

public class ComboBox extends Component {
    @Override
    public void update() {
        System.out.println("comboBox update");
    }

    public void select() {
        System.out.println("comboBox select");
    }
}

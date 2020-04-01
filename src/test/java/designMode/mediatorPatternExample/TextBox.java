package designMode.mediatorPatternExample;

public class TextBox extends Component {
    @Override
    public void update() {
        System.out.println("textbox update");
    }

    public void setText() {
        System.out.println("textbox setText");
    }
}

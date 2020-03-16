package designMode.builderModeVideoPlayer;

public class DisplayElement {
    private final String menu;
    private final String list;
    private final String main; //主窗口
    private final String controller;
    private final String save;

    public DisplayElement(Builder builder) {
        menu = builder.menu;
        list = builder.list;
        main = builder.main;
        controller = builder.controller;
        save = builder.save;
    }

    public static class Builder {
        private final String main; //主窗口

        private String menu;
        private String list;
        private String controller;
        private String save;

        public Builder(String main) {
            this.main = main;
        }

        //定义可选参数
        public Builder menu(String menu) {
            this.menu = menu;
            return this;
        }

        public Builder list(String list) {
            this.list = list;
            return this;
        }

        public Builder controller(String controller) {
            this.controller = controller;
            return this;
        }

        public Builder save(String save) {
            this.save = save;
            return this;
        }

        //静态工厂方法
        //设置方法返回自己本身，以便把方法连接起来
        public DisplayElement build(){
            DisplayElement displayElement = new DisplayElement(this);
            return displayElement;
        }
    }

    @Override
    public String toString() {
        return "DisplayElement{" +
                "menu='" + menu + '\'' +
                ", list='" + list + '\'' +
                ", main='" + main + '\'' +
                ", controller='" + controller + '\'' +
                ", save='" + save + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DisplayElement displayElement = new Builder("显示主窗口")
                .menu("显示菜单").list("显示列表").build();
        System.out.println(displayElement);
    }

}

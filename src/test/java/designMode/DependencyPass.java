package designMode;

//依赖关系传递的3种方法
public class DependencyPass {
    public static void main(String[] args) {
//        //通过接口传递实现依赖
        ChangHong changHong = new ChangHong();
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.open(changHong);

//        //通过构造器进行依赖传递
//        OpenAndClose openAndClose = new OpenAndClose(changHong);
//        openAndClose.open();

       // 通过 setter 方法进行依赖传递
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(changHong);
        openAndClose.open();
    }

//    // 方式 1: 通过接口传递实现依赖
//    // 开关的接口
//    interface IOpenAndClose {
//        void open(ITV tv);
//    }
//
//    interface ITV {
//        void play();
//    }
//
//    static class ChangHong implements ITV {
//
//        @Override
//        public void play() {
//            System.out.println("changhong open");
//        }
//    }
//
//    static class OpenAndClose implements IOpenAndClose {
//
//        @Override
//        public void open(ITV tv) {
//            tv.play();
//        }
//    }

//    // 方式 2: 通过构造方法传递依赖
//    // 开关的接口
//    interface IOpenAndClose {
//        void open();
//    }
//
//    interface ITV {
//        void play();
//    }
//
//    static class ChangHong implements ITV {
//
//        @Override
//        public void play() {
//            System.out.println("changhong open");
//        }
//    }
//
//    static class OpenAndClose implements IOpenAndClose {
//        public ITV itv;
//
//        public OpenAndClose(ITV itv) {
//            this.itv = itv;
//        }
//
//        @Override
//        public void open() {
//            itv.play();
//        }
//    }

    // 方式 3: 通过setter方法传递依赖
    // 开关的接口
    interface IOpenAndClose {
        void open();
        void setTv(ITV tv);
    }

    interface ITV {
        void play();
    }

    static class ChangHong implements ITV {

        @Override
        public void play() {
            System.out.println("changhong open");
        }
    }

    static class OpenAndClose implements IOpenAndClose {
        private ITV tv;

        @Override
        public void open() {
            this.tv.play();
        }

        @Override
        public void setTv(ITV tv) {
            this.tv = tv;
        }
    }

}

package designMode.ProxyPatternExample;

public class Client {
    public static void main(String[] args) {
        //被代理对象
        AbstractUserDao userDao = new UserDao();
        //创建动态代理对象
        AbstractUserDao userDaoProxy = (AbstractUserDao) UserLoggingHandler
                .createProxy(userDao);
        //之后操作都是针对代理对象
        System.out.println(userDaoProxy.findUserById("user389"));
    }
}

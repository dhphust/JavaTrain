package designMode.ProxyPatternExample;

public class UserDao implements AbstractUserDao {
    @Override
    public Boolean findUserById(String userId) {
        Person personInfo = new Person("user389", "tom", 23, "男");
        if (userId.equalsIgnoreCase(personInfo.getUserId())) {
            System.out.println(personInfo);
            return true;
        } else {
            System.out.println("查询用户失败");
            return false;
        }
    }
}

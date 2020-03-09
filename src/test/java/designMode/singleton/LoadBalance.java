package designMode.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 负载均衡器设计
 * 由一个负载均衡器负责服务器的管理和请求的分发
 * 保证数据的唯一性
 */
public class LoadBalance {

    //私有静态成员变量，存储唯一实例
    private static LoadBalance instance = null;
    //存储服务器集合
    private List<String> serverList = null;

    private LoadBalance() {
        serverList = new ArrayList<>();
    }

    //公有静态方法，返回唯一实例
    public static LoadBalance getLoadBalance(){
        if(instance == null){
            instance = new LoadBalance();
        }
        return instance;
    }

    //添加服务器
    public void addServer(String server){
        serverList.add(server);
    }

    //删除服务器
    public void removeServer(String server){
        serverList.remove(server);
    }

    //随机获取一台服务器
    public String getServer(){
        Random random = new Random();
        int number = random.nextInt(serverList.size());
        return serverList.get(number);
    }

    public static void main(String[] args) {
        //创建3个LoadBalance对象
        LoadBalance balance1, balance2, balance3;
        balance1 = LoadBalance.getLoadBalance();
        balance2 = LoadBalance.getLoadBalance();
        balance3 = LoadBalance.getLoadBalance();

        //判断3台负载均衡器是否相同
        if(balance1 == balance2 && balance2 == balance3 && balance1 == balance3){
            System.out.println("负载均衡器具有唯一性");
        }

        //添加服务器
        balance1.addServer("server1");
        balance1.addServer("server2");
        balance1.addServer("server3");

        //模拟客户端请求的分发
        for (int i = 0; i < 5; i++) {
            String server = balance2.getServer();
            System.out.println(server);
        }
    }
}

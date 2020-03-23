package designMode.observerPatternExample;

public class Client {
    public static void main(String[] args) {
        //定义观察目标对象
        AllyControlCenter allyControlCenter;
        allyControlCenter = new ConcreteAllyControlCenter("战队：勇往直前");

        //定义观察者对象
        Observer player1,player2,player3;
        player1 = new Player("玩家1");
        allyControlCenter.join(player1);

        player2 = new Player("玩家2");
        allyControlCenter.join(player2);

        player3 = new Player("玩家3");
        allyControlCenter.join(player3);

        //某成员遭受攻击
        player1.beAttacked(allyControlCenter);


    }
}

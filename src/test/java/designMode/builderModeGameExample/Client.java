package designMode.builderModeGameExample;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IllegalAccessException, ParserConfigurationException, InstantiationException, IOException, SAXException, ClassNotFoundException {
        List<Object> actorBuilders = XMLUtil.getInstances();

        //指挥者角色:创建完整的建造者对象
        ActorController actorController = new ActorController();
        Actor actor;
        for (Object actorBuilder : actorBuilders) {
            actor = actorController.construct((ActorBuilder) actorBuilder);
            System.out.println("角色类型：" + actor.getType());
            System.out.println("性别：" + actor.getSex());
            System.out.println("面部：" + actor.getFace());
            System.out.println("发型：" + actor.getHairstyle());
        }

    }
}

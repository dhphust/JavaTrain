package designMode.builderModeGameExample;

/**
 * 游戏角色创建控制器：指挥者
 * 指挥者控制角色的逐步构建
 * 建造者模式的重点：根据情况构建不同的角色
 */
public class ActorController {
    //逐步构建复杂的产品对象
    public Actor construct(ActorBuilder actorBuilder) {
        //角色构建
        Actor actor;
        actorBuilder.buildSex();
        actorBuilder.buildCostume();
        actorBuilder.buildFace();
        actorBuilder.buildType();
        if(!actorBuilder.isBareHeaded()) {
            actorBuilder.buildHairstyle();
        }
        //创建角色
        actor = actorBuilder.createActor();
        return actor;
    }
}

package designMode.builderModeGameExample;

public class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("坏淫");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("阴险");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }


    /**
     * 覆盖钩子方法
     * @return
     */
    @Override
    public boolean isBareHeaded() {
        return true;
    }
}

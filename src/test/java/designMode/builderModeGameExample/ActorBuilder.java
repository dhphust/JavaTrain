package designMode.builderModeGameExample;

/**
 * 抽象建造者
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();

    /**
     * 钩子方法
     * 是否为光头
     * @return
     */
    public boolean isBareHeaded() {
        return false;
    }

    public Actor createActor(){
        return actor;
    }
}

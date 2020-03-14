package designMode.factory.protomode;

import java.io.IOException;
import java.io.Serializable;

/**
 * 抽象原型接口
 */
public abstract class ProtoType implements Serializable {
    private String id;
    private String name;

    public ProtoType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    /**
//     * 克隆自身的方法
//     * @return 一个从自身克隆出来的对象。
//     */
//    public abstract ProtoType clone();

    /**
     * 深克隆
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public abstract ProtoType deepCopy() throws IOException, ClassNotFoundException;

    @Override
    public String toString() {
        return "ProtoType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

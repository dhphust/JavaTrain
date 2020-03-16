package designMode.protomode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 具体原型类A
 */
public class ConcretePrototypeA extends ProtoType implements Serializable {

    public ConcretePrototypeA(String id, String name) {
        super(id, name);
    }

//    @Override
//    public ProtoType clone() {
//        ProtoType protoType = new ConcretePrototypeA(this.getId(), this.getName());
//        return protoType;
//    }


    public ConcretePrototypeA deepCopy() throws IOException, ClassNotFoundException {
        //序列化：将对象写入到流中
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);

        //反序列化：将对象从流中取出
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (ConcretePrototypeA) objectInputStream.readObject();

    }

}

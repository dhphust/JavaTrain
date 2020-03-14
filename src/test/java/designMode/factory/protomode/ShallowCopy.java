package designMode.factory.protomode;

/**
 * 浅克隆
 */
public class ShallowCopy implements Cloneable {
    private String name;
    private int age;

    public ShallowCopy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public ShallowCopy clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (ShallowCopy) object;

    }

    @Override
    public String toString() {
        return "ShallowCopy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

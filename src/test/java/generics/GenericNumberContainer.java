package generics;

import java.util.List;

/**
 *，如果希望将某类型限制为特定类型或特定类型的子类型，请使用以下表示法：
 * <T extends UpperBoundType>
 * 同样，如果希望将某个类型限制为特定类型或特定类型的超类型，请使用以下表示法：
 * <T super LowerBoundType>
 *
 * 指定一个上限，将其泛型类型限制为 Number 或 Number 的子类
 */
public class GenericNumberContainer<T extends Number>{
    private T obj;

    public GenericNumberContainer(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static <N extends Number> double add(N a, N b){
        double sum = 0;
        sum = a.doubleValue() + b.doubleValue();
        return sum;
    }

    public static <T> void checkList(List<?> myList, T obj){
        if(myList.contains(obj)){
            System.out.println("The list contains the element: " + obj);
        } else {
            System.out.println("The list does not contain the element: " + obj);
        }
    }

}

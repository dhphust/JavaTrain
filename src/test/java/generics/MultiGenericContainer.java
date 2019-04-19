package generics;

/**
 * 多种范型类型
 * @param <T>
 * @param <S>
 */
public class MultiGenericContainer<T,S> {
    private T firstPosition;
    private S secondPosition;
    private T thirdPosition;

    public MultiGenericContainer(T firstPosition, S secondPosition, T thirdPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
    }

    public MultiGenericContainer() {

    }

    public T getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(T firstPosition) {
        this.firstPosition = firstPosition;
    }

    public S getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(S secondPosition) {
        this.secondPosition = secondPosition;
    }

    public T getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(T thirdPosition) {
        this.thirdPosition = thirdPosition;
    }


}

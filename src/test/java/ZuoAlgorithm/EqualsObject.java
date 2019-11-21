package ZuoAlgorithm;

import java.util.Objects;

public class EqualsObject {
    private Integer num;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsObject that = (EqualsObject) o;
        return Objects.equals(num, that.num) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(num, name);
    }
}

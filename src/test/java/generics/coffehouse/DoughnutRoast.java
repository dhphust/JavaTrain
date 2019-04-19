package generics.coffehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * 甜甜圈
 */
public class DoughnutRoast extends CoffeeType implements Medium {
    List<String> description;
    public DoughnutRoast() {
        description = new ArrayList<>();
        description.add(AROMATIC);
        description.add(SWEET);
        description.add(GROUND);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }
}

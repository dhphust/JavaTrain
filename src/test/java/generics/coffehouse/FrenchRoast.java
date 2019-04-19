package generics.coffehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * 法式面包
 */
public class FrenchRoast extends CoffeeType implements Light {

    List<String> description;

    public FrenchRoast() {
        description = new ArrayList<>();
        description.add(AROMATIC);
        description.add(BOLD);
        description.add(WHOLE_BEAN);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }
}

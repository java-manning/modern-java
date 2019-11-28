package modernjavainaction.chap06;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static modernjavainaction.chap06.Dish.menu;

public class ReducingWithCollectors {


    public static void main(String... args) {
        Comparator<Dish> someComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(someComparator));
        Dish d =  mostCalorieDish.get();
        System.out.println(d.getCalories());
    }

}

package modernjavainaction.chap06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static modernjavainaction.chap06.Dish.menu;

public class Reducing {

  public static void main(String... args) {
    long howManyDishes = menu.stream().collect(Collectors.counting());
    long howManyDishes2 = menu.stream().count();
    Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

    Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
    menu.stream().collect(maxBy(dishCaloriesComparator));

    String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

    Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
    System.out.println(dishesByType);

    //System.out.println(howManyDishes);
    //System.out.println(howManyDishes2);
    System.out.println(shortMenu);
  }

  public static void main2(String... args) {
    System.out.println("Total calories in menu: " + calculateTotalCalories());
    System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
    System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
    System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
  }

  private static int calculateTotalCalories() {
    return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
  }

  private static int calculateTotalCaloriesWithMethodReference() {
    return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
  }

  private static int calculateTotalCaloriesWithoutCollectors() {
    return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
  }

  private static int calculateTotalCaloriesUsingSum() {
    return menu.stream().mapToInt(Dish::getCalories).sum();
  }

}

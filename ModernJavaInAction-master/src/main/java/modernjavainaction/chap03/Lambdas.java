package modernjavainaction.chap03;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

  public static void main(String... args) {
    // Simple example
    Runnable r = () -> System.out.println("Hello!");
    r.run();

    // Filtering with lambdas
    List<Apple> inventory = Arrays.asList(
        new Apple(80, Color.GREEN),
        new Apple(155, Color.GREEN),
        new Apple(120, Color.RED)
    );

    // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
    List<Apple> greenApples = filter(inventory, (Apple a) -> a.getColor() == Color.GREEN);
    System.out.println(greenApples);

    Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

    // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
    inventory.sort(c);
    System.out.println(inventory);

    Lambdas nn = new Lambdas();
    List<String> ss = nn.weirdLambdaNames();
    ss.add("sdf");

  }

  public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  interface ApplePredicate {

    boolean test(Apple a);

  }

  public <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for(T t: list) {
      if(p.test(t)) {
        results.add(t);
      } }
    return results;
  }

  public List<String> weirdLambdaNames() {

    Predicate<String> nonEmptyStringPredicate = (String s) -> (s.startsWith("E"));

    List<String> listOfStrings = new ArrayList<String>();
    listOfStrings.add("Erdem");
    listOfStrings.add("YILMAZ");
    listOfStrings.add("TEST");

    List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
    return nonEmpty;

  }



}

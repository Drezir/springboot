package springboot.recipe.utils;

import java.util.Collection;
import java.util.LinkedList;

public class RecipeUtils {

  public static <T> Collection<T> fromIterable(Iterable<T> iterable) {
    LinkedList<T> collection = new LinkedList<>();
    iterable.forEach(collection::add);
    return collection;
  }

}

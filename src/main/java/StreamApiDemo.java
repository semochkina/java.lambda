import human.Human;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamApiDemo extends LambdaDemo {

    // в списке объектов удалить все значения null
    public static Function<List<Object>, List<Object>> removeAllNull =
            l -> l != null ? l.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()) : null;

    // во множестве целых чисел найти количество положительных значений
    public static Function<Set<Integer>, Long> countPositives =
            s -> s != null ? s.stream()
                    .filter(i -> i > 0)
                    .count() : null;

    // в списке объектов получить последние три элемента
    public static Function<List<Object>, List<Object>> getLastThree =
            l -> l != null && l.size() >= 3 ? l.stream()
                    .skip(l.size() - 3)
                    .collect(Collectors.toList()) : null;

    // в списке целых чисел получить первое четное число или значение null, если в списке нет четных чисел
    public static Function<List<Integer>, Integer> getFirstEven =
            l -> l != null ? l.stream()
                    .filter(i -> i % 2 == 0)
                    .findFirst()
                    .orElse(null) : null;

    // по массиву целых чисел построить список квадратов элементов массива без повторений
    public static Function<Integer[], List<Integer>> getListOfSquares =
            a -> Arrays.stream(a).map(i -> i * i).distinct().collect(Collectors.toList());


    // по списку строк построить новый список, содержащий все непустые строки исходного списка, упорядоченные по возрастанию
    public static Function<List<String>, List<String>> sortNotEmpty =
            l -> l.stream().filter(s -> s != null && s.length() > 0)
                    .sorted(String::compareTo).collect(Collectors.toList());

    // множество строк превратить в список, упорядоченный по убыванию
    public static Function<Set<String>, List<String>> sortReverse =
            s -> s != null ? s.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()) : null;

    // для множества целых чисел вычислить сумму квадратов его элементов
    public static Function<Set<Integer>, Integer> getSumOfSquares =
            s -> s != null ? s.stream()
                    .map(i -> i * i)
                    .reduce(0, (a, b) -> a + b) : null;

    // в коллекции людей вычислите максимальный возраст человека
    public static Function<Collection<Human>, Integer> getMaxAge =
            c -> c != null ? c.stream().max(Comparator.comparingInt(Human::getAge)).map(Human::getAge).orElse(null)
                    : null;
}

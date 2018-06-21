import human.Human;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface QuadroPredicate<T1, T2, T3, T4> {
    boolean test(T1 x, T2 y, T3 z, T4 t);
}

public class LambdaDemo {

    // для строки символов получить ее длину
    public static final Function<String, Integer> getLength = String::length;

    // для строки символов получить ее первый символ, если он существует, или null иначе
    public static final Function<String, Character> getFirstChar = s -> (s == null || s.length() == 0) ? null : s.charAt(0);

    // для строки проверить, что она не содержит пробелов
    public static final Predicate<String> checkNoSpaces = s -> s.indexOf(' ') < 0;

    // слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> getWordCount = s -> {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ',')
                count++;
        return count + 1;
    };

    // по человеку получить его возраст
    public static final Function<Human, Integer> getAge = Human::getAge;

    // по двум людям проверить, что у них одинаковая фамилия
    public static final BiPredicate<Human, Human> checkSameSurname = (h1, h2) ->
            h1.getSurname().equals(h2.getSurname());

    // получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    public static final Function<Human, String> getFullName = h -> h.getSurname().concat(" ")
            .concat(h.getName()).concat(" ")
            .concat(h.getPatronymic());

    // сделать человека старше на один год (по объекту human.Human создать новый объект)
    public static final Function<Human, Human> incrementAge = h -> new Human(h.getName(), h.getSurname(),
            h.getPatronymic(), h.getAge() + 1, h.getGender());

    // по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    public static final QuadroPredicate<Human, Human, Human, Integer> checkAllYounger = (h1, h2, h3, a) ->(h1 != null) && h1.getAge() < a
            && h2.getAge() < a
            && h3.getAge() < a;

}
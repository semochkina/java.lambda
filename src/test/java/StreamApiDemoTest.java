import human.Human;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StreamApiDemoTest {
    private List<Object> objectList = new ArrayList<Object>() {{
        add("1");
        add(new Human("a", "b", "c", 45, Human.Gender.FEMALE));
        add(null);
        add(null);
        add(5);
        add(null);
        add(6.6);
        add(null);
    }};
    private Set<Integer> integerSet = new HashSet<Integer>() {{
        add(5);
        add(-5);
        add(3);
        add(-6);
    }};
    private List<Integer> integerList = new ArrayList<Integer>() {{
        add(5);
        add(5);
        add(6);
        add(5);
        add(8);
    }};
    private Integer[] integers = { 5, 5, 6, 5, 8 };
    private List<String> stringList = new ArrayList<String>() {{
        add("s");
        add("");
        add("se");
        add(null);
        add("");
        add("as");
    }};
    private Set<String> stringSet = new HashSet<String>() {{
        add("a");
        add("b");
        add("f");
        add("c");
    }};
    private Collection<Human> humanCollection = new ArrayList<Human>() {{
        add(new Human("a", "b", "c", 54, Human.Gender.MALE));
        add(new Human("a", "b", "c", 45, Human.Gender.FEMALE));
        add(new Human("a", "b", "c", 65, Human.Gender.MALE));
    }};

    @Test
    public void removeAllNullTest() {
        List<Object> expected = new ArrayList<Object>() {{
            add("1");
            add(new Human("a", "b", "c", 45, Human.Gender.FEMALE));
            add(5);
            add(6.6);
        }};
        assertEquals(expected, StreamApiDemo.removeAllNull.apply(objectList));
    }
    
    @Test
    public void countPositivesTest() {
        assertEquals(2, (long)StreamApiDemo.countPositives.apply(integerSet));
    }

    @Test
    public void getLastThreeTest() {
        List<Object> expected = new ArrayList<Object>() {{
            add(null);
            add(6.6);
            add(null);
        }};
        assertEquals(expected, StreamApiDemo.getLastThree.apply(objectList));
    }

    @Test
    public void getFirstEvenTest() {
        assertEquals(6, (long)StreamApiDemo.getFirstEven.apply(integerList));
    }

    @Test
    public void getListOfSquaresTest() {
        List<Integer> expected = new ArrayList<Integer>() {{
            add(25);
            add(36);
            add(64);
        }};
        assertEquals(expected, StreamApiDemo.getListOfSquares.apply(integers));
    }

    @Test
    public void sortNotEmptyTest() {
        List<String> expected = new ArrayList<String>() {{
            add("as");
            add("s");
            add("se");
        }};
        assertEquals(expected, StreamApiDemo.sortNotEmpty.apply(stringList));
    }

    @Test
    public void sortReverseTest() {
        List<String> expected = new ArrayList<String>() {{
            add("f");
            add("c");
            add("b");
            add("a");
        }};
        assertEquals(expected, StreamApiDemo.sortReverse.apply(stringSet));
    }

    @Test
    public void getSumOfSquaresTest() {
        assertEquals(25 + 25 + 9 + 36, (long)StreamApiDemo.getSumOfSquares.apply(integerSet));
    }

    @Test
    public void getMaxAgeTest() {
        assertEquals(65, (long)StreamApiDemo.getMaxAge.apply(humanCollection));
    }
}

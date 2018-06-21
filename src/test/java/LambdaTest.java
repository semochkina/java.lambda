import human.Human;
import human.Student;
import org.junit.Test;

import static org.junit.Assert.*;


public class LambdaTest {
    private static final Human h1 = new Human("a", "b", "c", 11, Human.Gender.MALE);
    private static final Human h2 = new Human("a", "b", "c", 12, Human.Gender.MALE);
    private static final Human h3 = new Human("a", "d", "c", 11, Human.Gender.MALE);
    private static final Student s1 = new Student("a", "b", "c", 11, Human.Gender.MALE,
            "", "", "");


    @Test
    public void FunctionTest() {
        assertEquals(Integer.valueOf(5), LambdaRunner.run(LambdaDemo.getLength, "qwert"));
        assertEquals(Character.valueOf('q'), LambdaRunner.run(LambdaDemo.getFirstChar, "qwert"));
        assertEquals(Integer.valueOf(10), LambdaRunner.run(LambdaDemo.getWordCount, "qwert,, , 123, 123, 2,,7,,"));
        assertEquals(Integer.valueOf(11), LambdaRunner.run(LambdaDemo.getAge, s1));
        assertEquals("b a c", LambdaRunner.run(LambdaDemo.getFullName, s1));
        assertEquals(h2, LambdaRunner.run(LambdaDemo.incrementAge, h1));
    }

    @Test
    public void PredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.checkNoSpaces, "qwert"));
        assertFalse(LambdaRunner.run(LambdaDemo.checkNoSpaces, "qwer t"));
    }

    @Test
    public void BiPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.checkSameSurname, h1, h2));
        assertFalse(LambdaRunner.run(LambdaDemo.checkSameSurname, h1, h3));
    }

    @Test
    public void QuadroPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.checkAllYounger, h1, h2, s1, 13));
        assertFalse(LambdaRunner.run(LambdaDemo.checkAllYounger, h1, h2, s1, 12));
    }
}

import org.example.models.Cars;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.*;

public class AssertionsTests {

    @Test
    public void AssertsExamples()
    {
        Cars fiatActual = new Cars("red", 1.5);
        Cars kiaExpected = new Cars("red", 1.5);


        assertEquals(1,1,"int is incorrect");
        assertEquals("red","red","string is incorrect");
        assertEquals(fiatActual, kiaExpected,"Cars do not have the same parameters");

        fiatActual = kiaExpected;

        assertSame(fiatActual, kiaExpected,"Cars are not the same");
    }

    @Test
    public void AssertArrayNoOrder()
    {
        Integer[] actual = {1,2,3,5,4,6,7};
        Integer[] expected = {1,2,3,4,5,6,7};

        Assert.assertEqualsNoOrder(actual,expected,"Array is incorrect");
        Assert.assertEquals(actual,expected,"Array is incorrect");
    }

    @Test
    public void AssertArrayOrder()
    {
        Integer[] actual = {8,1,2,3,6,7};
        Integer[] expected = {8,1,2,3,6,7};

        Assert.assertEquals(actual,expected,"Array is incorrect");
    }

    @Test
    public void AssertArrayContain()
    {
      List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(8);
        expected.add(1);
        Integer actual = 8;
        assertListContainsObject(expected,actual,"Array does not contain");
    }

    @Test
    public void AssertNotNull()
    {
        String actual = "";
        Assert.assertNotNull(actual);
    }

    @Test
    public void AssertEmptyString()
    {
        String actual = "";
        Assert.assertEquals(actual,"");
    }


    @Test
    public void AssertByUsingHamcrest()
    {
        String string = "Petya";
        assertThat(string, equalTo("Pety"));
    }
    @Test
    public void givenNumber_whenConditions_thenCorrect() {
        Integer intVal = 7;
        assertThat(intVal, allOf(greaterThan(5), lessThanOrEqualTo(7), not(equalTo(6))));
    }
    }

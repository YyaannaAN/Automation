import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;

public class TestNgTests{

    @DataProvider
    public Object[][] parseLocaleData()
    {
        return new Object[][]{
                {null,null},
                {"en", Locale.ENGLISH},
                {"en_US",Locale.US},
                {"en_GB", Locale.UK}
        };
    }

    @Test(dataProvider = "parseLocaleData")
    public void testParseLocale(String locale, Locale expected)
    {
        Locale actual = Locale.forLanguageTag(locale);
        Assert.assertEquals(actual,expected,"Locale is incorrect");
    }

    @Test
    public void firstTest()
    {
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods ="firstTest")
    public void secondTest()
    {
        Assert.assertTrue(true);
    }



}

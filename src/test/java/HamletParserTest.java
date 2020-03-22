import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String expected = hamletText;
        String actual =hamletParser.getHamletData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletText;
        String actual =hamletParser.getHamletData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        Boolean actual = hamletParser.findHamlet(hamletText);
        Pattern pattern = Pattern.compile("Horatio");
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        Boolean actual = hamletParser.findHamlet(hamletText);
        Pattern pattern = Pattern.compile("Hamlet");
        Assert.assertTrue(actual);
    }
}
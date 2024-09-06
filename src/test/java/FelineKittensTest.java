import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FelineKittensTest {

    public FelineKittensTest(int expected, int input) {
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> kittenCount() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        });
    }

    private final int expected;
    private final int input;

    @Test
    public void testKittenCount() {
        Feline feline = new Feline();
        Assert.assertEquals(expected, feline.getKittens(input));
    }

}

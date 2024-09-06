import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class FelineTest {

    Feline feline = new Feline();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFelineGetFood() throws Exception {
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    public void testGetFelineFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetTwoKittens() {
        Assert.assertEquals(2, feline.getKittens(2));
    }

    @Test
    public void testGetOneKitten() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        feline.getFood("НеизвестныйВид");
    }
}

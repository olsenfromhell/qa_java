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
    public void testFelineEatMeat() throws Exception {
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    public void testGetFelineFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(2, feline.getKittens(2));
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        feline.getFood("НеизвестныйВид");
    }
}

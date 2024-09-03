import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class LionTest {

    @Mock
    Predator predatorMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this); }

    @Test
    public void testLionWithMaleSex() throws Exception {
        Mockito.when(predatorMock.getKittens()).thenReturn(3);
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predatorMock);

        Assert.assertTrue(lion.doesHaveMane());
        Assert.assertEquals(3, lion.getKittens());
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());

    }

    @Test
    public void testLionWithFemaleSex() throws Exception {
        Mockito.when(predatorMock.getKittens()).thenReturn(2);
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", predatorMock);

        Assert.assertFalse(lion.doesHaveMane());
        Assert.assertEquals(2, lion.getKittens());
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());

    }

    @Test(expected = Exception.class)
    public void testLionWithWrongSexThrowsException() throws Exception {
        new Lion("НеизвестныйПол", predatorMock);
    }
}

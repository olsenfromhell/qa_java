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

    // Тесты для льва

    @Test
    public void testLionGetKittens() throws Exception {
        Mockito.when(predatorMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predatorMock);

        Assert.assertEquals(3, lion.getKittens());
    }

    @Test
    public void testLionEatMeat() throws Exception {
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predatorMock);

        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", predatorMock);

        Assert.assertTrue(lion.doesHaveMane());
    }

    // Тесты для львицы

    @Test
    public void testLionessMane() throws Exception {
        Lion lioness = new Lion("Самка", predatorMock);

        Assert.assertFalse(lioness.doesHaveMane());
    }

    @Test
    public void testLionessEatMeat() throws Exception {
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Lion lioness = new Lion("Самка", predatorMock);

        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lioness.getFood());
    }

    @Test
    public void testLionessGetKittens() throws Exception {
        Mockito.when(predatorMock.getKittens()).thenReturn(2);

        Lion lioness = new Lion("Самка", predatorMock);

        Assert.assertEquals(2, lioness.getKittens());
    }

    @Test(expected = Exception.class)
    public void testLionWithWrongSexThrowsException() throws Exception {
        new Lion("НеизвестныйПол", predatorMock);
    }
}

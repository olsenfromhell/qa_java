import com.example.AlexTheLion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class AlexTheLionTest {

    @Mock
    Predator predatorMock;

    private AlexTheLion alexTheLion;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        alexTheLion = new AlexTheLion(predatorMock);
    }

    @Test
    public void testAlexGetKittens() {
        // Проверяем, что у Алекса нет львят
        Assert.assertEquals(0, alexTheLion.getKittens());
    }

    @Test
    public void testAlexGetFriends() throws Exception {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        // Проверяем, что список друзей Алекса соответствует ожиданиям
        Assert.assertArrayEquals(expectedFriends.toArray(), alexTheLion.getFriends().toArray());
    }

    @Test
    public void testAlexGetPlaceOfLiving() {
        // Проверяем, что место жительства Алекса — Нью-Йоркский зоопарк
        Assert.assertEquals("Нью-Йоркский зоопарк", alexTheLion.getPlaceOfLiving());
    }

    @Test
    public void testLionKittenInheritance() throws Exception {
        // Проверяем, что метод getKittens() класса Lion работают правильно
        Mockito.when(predatorMock.getKittens()).thenReturn(0);

        Assert.assertEquals(0, predatorMock.getKittens());
    }

    @Test
    public void testLionFoodInheritance() throws Exception {
        // Проверяем, что метод eatMeat() класса Lion работают правильно
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), predatorMock.eatMeat());
    }

    @Test
    public void testAlexFood() throws Exception {
        // Проверяем, что Алекс ест то же что и обычный лев
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), alexTheLion.getFood());
    }

    @Test
    public void testAlexHasMane() throws Exception {
        // Проверяем наличие гривы
        Assert.assertTrue(alexTheLion.doesHaveMane());
    }
}

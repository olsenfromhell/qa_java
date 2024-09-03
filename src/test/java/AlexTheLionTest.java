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
    public void testLionInheritance() throws Exception {
        // Проверяем, что методы класса Lion работают правильно
        Mockito.when(predatorMock.getKittens()).thenReturn(0);
        Mockito.when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        // Проверяем наличие гривы
        Assert.assertTrue(alexTheLion.doesHaveMane());

        // Проверяем, что Алекс ест то же что и обычный лев
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), alexTheLion.getFood());
    }
}

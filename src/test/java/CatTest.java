import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class CatTest {

    @Mock
    Feline felineMock;

    private Cat cat;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(felineMock);  // Передаем мок Feline напрямую
    }

    @Test
    public void testGetSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(Arrays.asList("Мясо", "Рыба"));

        Assert.assertEquals(Arrays.asList("Мясо", "Рыба"), cat.getFood());

    }

}

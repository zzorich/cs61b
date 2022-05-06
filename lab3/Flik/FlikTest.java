import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void isSameNumberTest(){
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(10, 10));
        assertTrue(!(Flik.isSameNumber(11, 10)));
        // assertTrue(Flik.isSameNumber(128, 128));
        Integer a = 128;
        Integer b = 128;
        assertTrue(a == b);
    }
}

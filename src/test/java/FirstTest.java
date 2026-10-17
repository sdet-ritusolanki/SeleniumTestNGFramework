import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

        @Test
        public void verifyAddition() {

            int a = 10;
            int b = 20;

            int result = a + b;

            Assert.assertEquals(result, 30);
        }
    }



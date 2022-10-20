package junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    void simpleAssertion() {
        Assertions.assertEquals(1,2);
    }
}

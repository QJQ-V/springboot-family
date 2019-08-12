package demo.springboot.springboothelloworld.web;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloControllerTest {
    @Test
    public void testSatHello() {
        assertEquals("Hello,World!",new HelloController().sayHello());
    }
}

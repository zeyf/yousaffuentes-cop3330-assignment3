package ex46;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class StringCollectorTest {


    @Test
    public void testAddString() {
        StringCollector.addNewString("Hello");
        assertTrue(StringCollector.linearSearchForString("Hello"));
        assertFalse(StringCollector.linearSearchForString("hi"));
    };


}
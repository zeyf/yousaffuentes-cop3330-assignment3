package ex45;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplacerTest {

    @Test
    public static void replaceTermInLine() {
        String str = "Hello my name is zain", newstr = "Hello my name is john";
        StringReplacer sr = new StringReplacer("zain", "john");
        sr.replaceTermInLine(str);
        assertEquals(sr.getNewOutput(), newstr);
    };

}
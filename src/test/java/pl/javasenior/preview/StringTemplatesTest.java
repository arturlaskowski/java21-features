package pl.javasenior.preview;

import org.junit.jupiter.api.Test;

class StringTemplatesTest {

    @Test
    void stringTemplate() {
        String name = "Marek";
        String greeting = STR."Siema \{ name }!";
        System.out.println(greeting);
    }

}



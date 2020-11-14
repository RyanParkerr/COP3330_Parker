  import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecrypterTest {

    @Test
    void testDecrypt1234to0189() {
        Decrypter d = new Decrypter();
        assertEquals("1234", d.decrypt("0189"));
    }

}
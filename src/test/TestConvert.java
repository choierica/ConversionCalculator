package test;
import model.Convert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//public class TestConvert {
//    private Convert c;
//
//    @BeforeEach
//    public void runBefore() throws IOException {
//        c = new Convert();
//    }
//
//    @Test
//    public void testisPositive() {
//        assertFalse(c.isPositive(-1.0));
//        assertTrue(c.isPositive(1.0));
//        assertTrue(c.isPositive(0.0));
//        assertFalse(c.isPositive(-500.21234));
//        assertTrue(c.isPositive(5134.21234));
//    }
//
//}

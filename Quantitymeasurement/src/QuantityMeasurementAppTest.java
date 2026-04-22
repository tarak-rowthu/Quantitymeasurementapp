package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetToFeet_SameValue() {
        assertTrue(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    void testInchToInch_SameValue() {
        assertTrue(new Quantity(1.0, LengthUnit.INCH)
                .equals(new Quantity(1.0, LengthUnit.INCH)));
    }

    @Test
    void testFeetToInch_Equivalent() {
        assertTrue(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(12.0, LengthUnit.INCH)));
    }

    @Test
    void testInchToFeet_Equivalent() {
        assertTrue(new Quantity(12.0, LengthUnit.INCH)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    void testDifferentValues() {
        assertFalse(new Quantity(1.0, LengthUnit.FEET)
                .equals(new Quantity(2.0, LengthUnit.FEET)));
    }

    @Test
    void testNullComparison() {
        assertFalse(new Quantity(1.0, LengthUnit.FEET).equals(null));
    }

    @Test
    void testSameReference() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity(1.0, null);
        });
    }
}
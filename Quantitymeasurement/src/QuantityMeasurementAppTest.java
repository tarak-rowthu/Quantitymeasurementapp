package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetToInchesConversion() {
        assertEquals(12.0,
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testInchesToFeetConversion() {
        assertEquals(2.0,
                Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET),
                1e-6);
    }

    @Test
    void testYardsToFeetConversion() {
        assertEquals(3.0,
                Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET),
                1e-6);
    }

    @Test
    void testCentimeterToInches() {
        assertEquals(0.393701,
                Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testCrossUnitEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testYardEqualsFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testNotEqual() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testNullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(Double.NaN, Length.LengthUnit.FEET);
        });
    }
}
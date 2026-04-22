package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality check
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison using raw values
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    // Conversion (method 1)
    public static Length demonstrateLengthConversion(
            double value, Length.LengthUnit from, Length.LengthUnit to) {

        double converted = Length.convert(value, from, to);
        return new Length(converted, to);
    }

    // Conversion (method 2 - overloaded)
    public static Length demonstrateLengthConversion(
            Length length, Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        // Equality
        System.out.println(demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES));

        // Conversion
        Length result = demonstrateLengthConversion(3.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        System.out.println("Converted: " + result);
    }
}
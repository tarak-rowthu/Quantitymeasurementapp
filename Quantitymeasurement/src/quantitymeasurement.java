package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new com.apps.quantitymeasurement.Quantity(12.0, com.apps.quantitymeasurement.LengthUnit.INCH);

        System.out.println("Are equal? " + q1.equals(q2)); // true
    }
}
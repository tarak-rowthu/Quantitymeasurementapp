package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    // Enum with conversion factors (base unit = inches)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInches;

        LengthUnit(double toInches) {
            this.toInches = toInches;
        }

        public double getConversionFactor() {
            return toInches;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Static conversion API (UC5 requirement)
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        double base = value * from.getConversionFactor();
        return base / to.getConversionFactor();
    }

    // Instance conversion
    public Length convertTo(LengthUnit targetUnit) {
        double newValue = convert(this.value, this.unit, targetUnit);
        return new Length(newValue, targetUnit);
    }

    // Equality with tolerance
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length other = (Length) o;

        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
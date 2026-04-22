public static void main(String[] args) {

    com.apps.quantitymeasurement.Length l1 = new com.apps.quantitymeasurement.Length(1.0, Length.LengthUnit.FEET);
    com.apps.quantitymeasurement.Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

    System.out.println(l1.equals(l2)); // true

    Length l3 = new Length(1.0, Length.LengthUnit.YARDS);
    Length l4 = new Length(36.0, Length.LengthUnit.INCHES);

    System.out.println(l3.equals(l4)); // true
}
package ru.sberbank.java.scool.lab;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class DoubleExTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private DoubleEx doubleEx;

    @org.junit.Before
    public void setUp() {
        doubleEx = new DoubleEx(10d);
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(doubleEx.add(5.55).getValue(), 15.55, 0.0);
        Assert.assertEquals(doubleEx.add(-5.55).getValue(), 4.45, 0.0);
        Assert.assertEquals(doubleEx.add(555).getValue(), 565d, 0.0);
        Assert.assertEquals(doubleEx.add(0).getValue(), 10d, 0.0);
        Assert.assertEquals(doubleEx.add(Integer.MAX_VALUE).getValue(), 2147483657d, 0.0);
        Assert.assertEquals(doubleEx.add(Integer.MIN_VALUE).getValue(), -2147483638d, 0.0);
    }

    @org.junit.Test
    public void subtract() {
        Assert.assertEquals(doubleEx.subtract(5.55).getValue(), 4.45, 0.0);
        Assert.assertEquals(doubleEx.subtract(-5.55).getValue(), 15.55, 0.0);
        Assert.assertEquals(doubleEx.subtract(555).getValue(), -545d, 0.0);
        Assert.assertEquals(doubleEx.subtract(0).getValue(), 10d, 0.0);
        Assert.assertEquals(doubleEx.subtract(Integer.MAX_VALUE).getValue(), -2147483637d, 0.0);
        Assert.assertEquals(doubleEx.subtract(Integer.MIN_VALUE).getValue(), 2147483658d, 0.0);
    }

    @org.junit.Test
    public void multiply() {
        Assert.assertEquals(doubleEx.multiply(5.55).getValue(), 55.5, 0.0);
        Assert.assertEquals(doubleEx.multiply(-5.55).getValue(), -55.5, 0.0);
        Assert.assertEquals(doubleEx.multiply(555).getValue(), 5550d, 0.0);
        Assert.assertEquals(doubleEx.multiply(0).getValue(), 0d, 0.0);
        Assert.assertEquals(doubleEx.multiply(Integer.MAX_VALUE).getValue(), 21474836470d, 0.0);
        Assert.assertEquals(doubleEx.multiply(Integer.MIN_VALUE).getValue(), -21474836480d, 0.0);
    }

    @org.junit.Test
    public void divide() {
        Assert.assertEquals(doubleEx.divide(5.55).getValue(), 1.8018018018018018, 0.0);
        Assert.assertEquals(doubleEx.divide(-5.55).getValue(), -1.8018018018018018, 0.0);
        Assert.assertEquals(doubleEx.divide(555).getValue(), 0.018018018018018018, 0.0);
        Assert.assertEquals(doubleEx.divide(0.0).getValue(), Double.POSITIVE_INFINITY, 0.0);
        exception.expect(ArithmeticException.class);
        doubleEx.divide(0);
    }

    @org.junit.Test
    public void mod() {
        Assert.assertEquals(doubleEx.mod(5.55).getValue(), 4.45, 0.0);
        Assert.assertEquals(doubleEx.mod(-5.55).getValue(), 4.45, 0.0);
        Assert.assertEquals(doubleEx.mod(555).getValue(), 10d, 0.0);
        exception.expect(ArithmeticException.class);
        doubleEx.mod(0);
    }

    @org.junit.Test
    public void pow() {
        Assert.assertEquals(doubleEx.pow(5.55).getValue(), 354813.3892335753, 0.0);
        Assert.assertEquals(doubleEx.pow(-5).getValue(), 0.00001, 0.0);
        Assert.assertEquals(doubleEx.pow(30).getValue(), 1000000000000000000000000000000d, 0.0);
        Assert.assertEquals(doubleEx.pow(0).getValue(), 1d, 0.0);
        Assert.assertEquals(new DoubleEx(0).pow(0).getValue(), 1d, 0.0);
        Assert.assertEquals(new DoubleEx(0).pow(1).getValue(), 0d, 0.0);
    }

    @org.junit.Test
    public void max() {
        Assert.assertEquals(doubleEx.max(5.55).getValue(), 10d, 0.0);
        Assert.assertEquals(doubleEx.max(-5.55).getValue(), 10d, 0.0);
        Assert.assertEquals(doubleEx.max(10.000000000000000001).getValue(), 10.000000000000000001, 0.0);
    }
}
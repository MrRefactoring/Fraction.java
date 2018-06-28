import io.github.mrrefactoring.Fraction;
import org.junit.Assert;
import org.junit.Test;

public class SmallTestsPack extends Assert {

    @Test
    public void testJava_0(){
        assertEquals(new Fraction(1L).toString(), "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJava_1(){
        new Fraction("");
    }

    @Test
    public void testJava_2(){
        assertEquals(new Fraction("+").toString(), "0");
    }

    @Test
    public void testJava_3(){
        assertEquals(new Fraction("0.").toString(), "0");
    }

    @Test
    public void testJava_4(){
        assertEquals(new Fraction(".0").toString(), "0");
    }

    @Test
    public void testJava_5(){
        assertEquals(new Fraction(1, 2).toString(), "0.5");
    }

    @Test
    public void testInverse(){
        assertEquals(new Fraction(1, 2).inverse().toString(), "2");
    }

    @Test
    public void testLong_0(){
        assertEquals(new Fraction(new long[]{1}).toString(), "1");
    }

    @Test
    public void testLong_1(){
        assertEquals(new Fraction(new long[]{1, 2}).toString(), "0.5");
    }

    @Test
    public void testLong_2(){
        assertEquals(new Fraction(new long[]{1, 1}).toString(), "1");
    }

    @Test
    public void testLong_3(){
        assertEquals(new Fraction(new long[]{1, 1, -1}).toString(), "-1");
    }

    @Test
    public void testLong_4(){
        assertEquals(new Fraction(new long[]{-6}).toString(), "-6");
    }

    @Test
    public void testLong_5(){
        assertEquals(new Fraction(new long[]{-4, 4}).toString(), "-1");
    }

    @Test
    public void testLong_6(){
        assertEquals(new Fraction(new long[]{-4, -4}).toString(), "1");
    }

    @Test
    public void testLong_7(){
        assertEquals(new Fraction(new long[]{-4, -4, 1}).toString(), "1");
    }

    @Test
    public void testLong_8(){
        assertEquals(new Fraction(new long[]{-4, -4, -1}).toString(), "-1");
    }

    @Test
    public void testValueOf(){
        assertEquals(new Fraction(1, 2).valueOf(), .5, 0.001);
    }

    @Test
    public void testEqual_0(){
        assertEquals(new Fraction(), new Fraction());
    }

    @Test
    public void testEqual_1(){
        assertNotEquals(new Fraction(1), new Fraction());
    }

    @Test
    public void testEqual_2(){
        assertEquals(new Fraction(), (Object) new Fraction());
    }

    @Test
    public void testEqual_3(){
        assertEquals(new Fraction(), new Fraction().toString());
    }

    @Test
    public void testEqual_4(){
        assertEquals(new Fraction(99), new Fraction(99).toString());
    }

    @Test
    public void testEqual_5(){
        assertNotEquals(new Fraction(-99), new Fraction(99).toString());
    }

    @Test
    public void testEqual_6(){
        assertTrue(new Fraction(99).equals(99));
    }

    @Test
    public void testEqual_7(){
        assertFalse(new Fraction(99).equals(-99));
    }

    @Test
    public void testEqual_8(){
        assertNotEquals("Foo", new Fraction(99));
    }

    @Test
    public void testJava_6(){
        assertEquals(new Fraction(0, 1).toString(), "0");
    }

    @Test(expected = ArithmeticException.class)
    public void testJava_7(){
        assertEquals(new Fraction(0, 0).toString(), "0");
    }

    @Test
    public void test_0(){
        assertEquals(new Fraction().toString(), "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_1(){
        new Fraction("foo");
    }

    @Test
    public void test_2(){
        assertEquals(new Fraction("-").toString(), "0");
    }

    @Test
    public void test_3(){
        assertEquals(new Fraction(0).toString(), "0");
    }

    @Test
    public void test_4(){
        assertEquals(new Fraction(.2).toString(), "0.2");
    }

    @Test
    public void test_5(){
        assertEquals(new Fraction(.333).toString(), "0.333");
    }

    @Test
    public void test_6(){
        assertEquals(new Fraction(1.1).toString(), "1.1");
    }

    @Test
    public void test_7(){
        assertEquals(new Fraction(1.2).toString(), "1.2");
    }

    @Test
    public void test_8(){
        assertEquals(new Fraction(1.3).toString(), "1.3");
    }

    @Test
    public void test_9(){
        assertEquals(new Fraction(1.4).toString(), "1.4");
    }

    @Test
    public void test_10(){
        assertEquals(new Fraction(1.5).toString(), "1.5");
    }

    @Test
    public void test_11(){
        assertEquals(new Fraction(2.555).toString(), "2.555");
    }

    @Test
    public void test_12(){
        assertEquals(new Fraction(" - ").toString(), "0");
    }

    @Test
    public void test_13(){
        assertEquals(new Fraction(".5").toString(), "0.5");
    }

    @Test
    public void test_14(){
        assertEquals(new Fraction("-.5").toString(), "-0.5");
    }

    @Test
    public void test_15(){
        assertEquals(new Fraction("123").toString(), "123");
    }

    @Test
    public void test_16(){
        assertEquals(new Fraction("-123").toString(), "-123");
    }

    @Test
    public void test_17(){
        assertEquals(new Fraction("123.4").toString(), "123.4");
    }

    @Test
    public void test_18(){
        assertEquals(new Fraction("-123.4").toString(), "-123.4");
    }

    @Test
    public void test_19(){
        assertEquals(new Fraction("123.").toString(), "123");
    }

    @Test
    public void test_20(){
        assertEquals(new Fraction("-123.").toString(), "-123");
    }

    @Test
    public void test_21(){
        assertEquals(new Fraction("123.4(56)").toString(), "123.4(56)");
    }

    @Test
    public void test_22(){
        assertEquals(new Fraction("-123.4(56)").toString(), "-123.4(56)");
    }

    @Test
    public void test_23(){
        assertEquals(new Fraction("123.(4)").toString(), "123.(4)");
    }

    @Test
    public void test_24(){
        assertEquals(new Fraction("-123.(4)").toString(), "-123.(4)");
    }

    @Test(expected = ArithmeticException.class)
    public void test_25(){
        new Fraction("0/0");
    }

    @Test(expected = ArithmeticException.class)
    public void test_26(){
        new Fraction("9/0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_27(){
        assertEquals(new Fraction("0/1+0/1").toString(), "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_28(){
        assertEquals(new Fraction("1/9+0/1").toString(), "0.(1)");
    }

    @Test
    public void test_29(){
        assertEquals(new Fraction("123/456").toString(), "0.269(736842105263157894)");
    }

    @Test
    public void test_30(){
        assertEquals(new Fraction("-123/456").toString(), "-0.269(736842105263157894)");
    }

    @Test
    public void test_31(){
        assertEquals(new Fraction("19 123/456").toString(), "19.269(736842105263157894)");
    }

    @Test
    public void test_32(){
        assertEquals(new Fraction("-19 123/456").toString(), "-19.269(736842105263157894)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_33(){
        new Fraction("123.(22)12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_34(){
        new Fraction("123.(((");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_35(){
        new Fraction("123.((");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_36(){
        new Fraction("123.()");
    }

    @Test
    public void test_37(){
        assertEquals(new Fraction("+33.3(3)").toString(), "33.(3)");
    }

    @Test
    public void test_38(){
        assertEquals(new Fraction("3.'09009'").toString(), "3.(09009)");
    }

    @Test
    public void test_39(){
        assertEquals(new Fraction(new int[]{22, 7}).toString(), "3.(142857)");
    }

    @Test
    public void test_40(){
        assertEquals(new Fraction("355/113").toString(), "3.(1415929203539823008849557522123893805309734513274336283185840707964601769911504424778761061946902654867256637168)");
    }

    @Test
    public void test_41(){
        assertEquals(new Fraction("3 1/7").toString(), "3.(142857)");
    }

    @Test
    public void test_42(){
        assertEquals(new Fraction(new int[] {36, -36}).toString(), "-1");
    }

    @Test
    public void test_43(){
        assertEquals(new Fraction("9/12").toString(), "0.75");
    }

    @Test
    public void test_44(){
        assertEquals(new Fraction("0.09(33)").toString(), "0.09(3)");
    }

    @Test
    public void test_45(){
        assertEquals(new Fraction((double) 1 / 2).toString(), "0.5");
    }

    @Test
    public void test_46(){
        assertEquals(new Fraction((double) 1 / 3).toString(), "0.(3)");
    }

    @Test
    public void test_47(){
        assertEquals(new Fraction("0.'3'").toString(), "0.(3)");
    }

    @Test
    public void test_48(){
        assertEquals(new Fraction("0.00002").toString(), "0.00002");
    }

    @Test
    public void test_49(){
        assertEquals(new Fraction((double) 7 / 8).toString(), "0.875");
    }

    @Test
    public void test_50(){
        assertEquals(new Fraction(0.003).toString(), "0.003");
    }

    @Test
    public void test_51(){
        assertEquals(new Fraction(4).toString(), "4");
    }

    @Test
    public void test_52(){
        assertEquals(new Fraction(-99).toString(), "-99");
    }

    @Test
    public void test_53(){
        assertEquals(new Fraction("-92332.1192").toString(), "-92332.1192");
    }

    @Test
    public void test_54(){
        assertEquals(new Fraction("88.92933(12111)").toString(), "88.92933(12111)");
    }

    @Test
    public void test_55(){
        assertEquals(new Fraction("-192322.823(123)").toString(), "-192322.8(231)");
    }

    @Test
    public void test_56(){
        assertEquals(new Fraction("-99.12").mod("0.09(34)").toString(), "-0.07(95)");
    }

    @Test
    public void test_57(){
        assertEquals(new Fraction(.4).div(".1").toString(), "4");
    }

    @Test
    public void test_58(){
        assertEquals(new Fraction(1).sub("-1").toString(), "2");
    }

}


import io.github.mrrefactoring.DivisionByZeroException;
import io.github.mrrefactoring.Fraction;
import io.github.mrrefactoring.OverflowException;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTests extends Assert {


    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_0(){
        new Fraction("");
    }

    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_1(){
        new Fraction("foo");
    }

    @Test  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_2(){
        assertEquals(new Fraction(" 123"), new Fraction(123));
    }

    @Test
    public void test_3(){ /* {"set":0,"expect":0} */
        assertEquals(new Fraction(0).toString(), new Fraction(0).toString());
    }

    @Test
    public void test_4(){ /* {"set":0.2,"expect":"0.2"} */
        assertEquals(new Fraction(0.2).toString(), new Fraction("0.2").toString());
    }

    @Test
    public void test_5(){ /* {"set":0.333,"expect":"0.333"} */
        assertEquals(new Fraction(0.333).toString(), new Fraction("0.333").toString());
    }

    @Test
    public void test_6(){ /* {"set":1.1,"expect":"1.1"} */
        assertEquals(new Fraction(1.1).toString(), new Fraction("1.1").toString());
    }

    @Test
    public void test_7(){ /* {"set":1.2,"expect":"1.2"} */
        assertEquals(new Fraction(1.2).toString(), new Fraction("1.2").toString());
    }

    @Test
    public void test_8(){ /* {"set":1.3,"expect":"1.3"} */
        assertEquals(new Fraction(1.3).toString(), new Fraction("1.3").toString());
    }

    @Test
    public void test_9(){ /* {"set":1.4,"expect":"1.4"} */
        assertEquals(new Fraction(1.4).toString(), new Fraction("1.4").toString());
    }

    @Test
    public void test_10(){ /* {"set":1.5,"expect":"1.5"} */
        assertEquals(new Fraction(1.5).toString(), new Fraction("1.5").toString());
    }

    @Test
    public void test_11(){ /* {"set":2.555,"expect":"2.555"} */
        assertEquals(new Fraction(2.555).toString(), new Fraction("2.555").toString());
    }

    @Test
    public void test_12(){
        assertEquals(new Fraction(" - ").toString(), "0");
    }

    @Test
    public void test_13(){ /* {"set":".5","expect":"0.5"} */
        assertEquals(new Fraction(".5").toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_14(){ /* {"set":"-.5","expect":"-0.5"} */
        assertEquals(new Fraction("-.5").toString(), new Fraction("-0.5").toString());
    }

    @Test
    public void test_15(){ /* {"set":"123","expect":"123"} */
        assertEquals(new Fraction("123").toString(), new Fraction("123").toString());
    }

    @Test
    public void test_16(){ /* {"set":"-123","expect":"-123"} */
        assertEquals(new Fraction("-123").toString(), new Fraction("-123").toString());
    }

    @Test
    public void test_17(){ /* {"set":"123.4","expect":"123.4"} */
        assertEquals(new Fraction("123.4").toString(), new Fraction("123.4").toString());
    }

    @Test
    public void test_18(){ /* {"set":"-123.4","expect":"-123.4"} */
        assertEquals(new Fraction("-123.4").toString(), new Fraction("-123.4").toString());
    }

    @Test
    public void test_19(){ /* {"set":"123.","expect":"123"} */
        assertEquals(new Fraction("123.").toString(), new Fraction("123").toString());
    }

    @Test
    public void test_20(){ /* {"set":"-123.","expect":"-123"} */
        assertEquals(new Fraction("-123.").toString(), new Fraction("-123").toString());
    }

    @Test
    public void test_21(){ /* {"set":"123.4(56)","expect":"123.4(56)"} */
        assertEquals(new Fraction("123.4(56)").toString(), new Fraction("123.4(56)").toString());
    }

    @Test
    public void test_22(){ /* {"set":"-123.4(56)","expect":"-123.4(56)"} */
        assertEquals(new Fraction("-123.4(56)").toString(), new Fraction("-123.4(56)").toString());
    }

    @Test
    public void test_23(){ /* {"set":"123.(4)","expect":"123.(4)"} */
        assertEquals(new Fraction("123.(4)").toString(), new Fraction("123.(4)").toString());
    }

    @Test
    public void test_24(){ /* {"set":"-123.(4)","expect":"-123.(4)"} */
        assertEquals(new Fraction("-123.(4)").toString(), new Fraction("-123.(4)").toString());
    }

    @Test(expected = DivisionByZeroException.class)  // todo {io.github.mrrefactoring.Fraction.DivisionByZero}
    public void test_25(){
        new Fraction("0/0");
    }

    @Test(expected = DivisionByZeroException.class)  // todo {io.github.mrrefactoring.Fraction.DivisionByZero}
    public void test_26(){
        new Fraction("9/0");
    }

    @Test
    public void test_27(){ /* {"label":"0/1+0/1","set":"0/1","param":"0/1","expect":"0"} */
        assertEquals(new Fraction("0/1").toString(), new Fraction("0").toString());
    }

    @Test
    public void test_28(){ /* {"label":"1/9+0/1","set":"1/9","param":"0/1","expect":"0.(1)"} */
        assertEquals(new Fraction("1/9").toString(), new Fraction("0.(1)").toString());
    }

    @Test(expected = OverflowException.class)
    public void test_29(){
        assertEquals(new Fraction("123/456").toString(), new Fraction("0.269(736842105263157894)").toString());
    }

    @Test(expected = OverflowException.class)
    public void test_30(){
        assertEquals(new Fraction("-123/456").toString(), new Fraction("-0.269(736842105263157894)").toString());
    }

    @Test(expected = OverflowException.class)
    public void test_31(){
        assertEquals(new Fraction("19 123/456").toString(), new Fraction("19.269(736842105263157894)").toString());
    }

    @Test(expected = OverflowException.class)
    public void test_32(){
        assertEquals(new Fraction("-19 123/456").toString(), new Fraction("-19.269(736842105263157894)").toString());
    }

    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_33(){
        new Fraction("123.(22)123");
    }

    @Test
    public void test_34(){ /* {"set":"+33.3(3)","expect":"33.(3)"} */
        assertEquals(new Fraction("+33.3(3)").toString(), new Fraction("33.(3)").toString());
    }

    @Test
    public void test_35(){ /* {"set":"3.'09009'","expect":"3.(09009)"} */
        assertEquals(new Fraction("3.'09009'").toString(), new Fraction("3.(09009)").toString());
    }

    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_36(){
        new Fraction("123.(((");
    }

    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_37(){
        new Fraction("123.((");
    }

    @Test(expected = IllegalArgumentException.class)  // todo {io.github.mrrefactoring.Fraction.InvalidParameter}
    public void test_38(){
        new Fraction("123.()");
    }

    @Test
    public void test_40(){ /* {"set":[22,7],"expect":"3.(142857)"} */
        assertEquals(new Fraction(new int[]{22,7}).toString(), new Fraction("3.(142857)").toString());
    }

    @Test
    public void test_42(){ /* {"set":"3 1/7","expect":"3.(142857)"} */
        assertEquals(new Fraction("3 1/7").toString(), new Fraction("3.(142857)").toString());
    }

    @Test
    public void test_43(){ /* {"set":[36,-36],"expect":"-1"} */
        assertEquals(new Fraction(new int[]{36,-36}).toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_44(){ /* {"set":"9/12","expect":"0.75"} */
        assertEquals(new Fraction("9/12").toString(), new Fraction("0.75").toString());
    }

    @Test
    public void test_45(){ /* {"set":"0.09(33)","expect":"0.09(3)"} */
        assertEquals(new Fraction("0.09(33)").toString(), new Fraction("0.09(3)").toString());
    }

    @Test
    public void test_46(){ /* {"set":0.5,"expect":"0.5"} */
        assertEquals(new Fraction(0.5).toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_47(){ /* {"set":0.3333333333333333,"expect":"0.(3)"} */
        assertEquals(new Fraction(0.3333333333333333).toString(), new Fraction("0.(3)").toString());
    }

    @Test
    public void test_48(){ /* {"set":"0.'3'","expect":"0.(3)"} */
        assertEquals(new Fraction("0.'3'").toString(), new Fraction("0.(3)").toString());
    }

    @Test
    public void test_49(){ /* {"set":"0.00002","expect":"0.00002"} */
        assertEquals(new Fraction("0.00002").toString(), new Fraction("0.00002").toString());
    }

    @Test
    public void test_50(){ /* {"set":0.875,"expect":"0.875"} */
        assertEquals(new Fraction(0.875).toString(), new Fraction("0.875").toString());
    }

    @Test
    public void test_51(){ /* {"set":0.003,"expect":"0.003"} */
        assertEquals(new Fraction(0.003).toString(), new Fraction("0.003").toString());
    }

    @Test
    public void test_52(){ /* {"set":4,"expect":"4"} */
        assertEquals(new Fraction(4).toString(), new Fraction("4").toString());
    }

    @Test
    public void test_53(){ /* {"set":-99,"expect":"-99"} */
        assertEquals(new Fraction(-99).toString(), new Fraction("-99").toString());
    }

    @Test
    public void test_54(){ /* {"set":"-92332.1192","expect":"-92332.1192"} */
        assertEquals(new Fraction("-92332.1192").toString(), new Fraction("-92332.1192").toString());
    }

    @Test
    public void test_55(){ /* {"set":"88.92933(12111)","expect":"88.92933(12111)"} */
        assertEquals(new Fraction("88.92933(12111)").toString(), new Fraction("88.92933(12111)").toString());
    }

    @Test
    public void test_56(){ /* {"set":"-192322.823(123)","expect":"-192322.8(231)"} */
        assertEquals(new Fraction("-192322.823(123)").toString(), new Fraction("-192322.8(231)").toString());
    }

    @Test
    public void test_57(){  /* {"label":"-99.12 % 0.09(34)","set":"-99.12","fn":"mod","param":"0.09(34)","expect":"-0.07(95)"} */
        assertEquals(new Fraction("-99.12").mod("0.09(34)").toString(), new Fraction("-0.07(95)").toString());
    }

    @Test
    public void test_58(){  /* {"label":"0.4 / 0.1","set":0.4,"fn":"div","param":".1","expect":"4"} */
        assertEquals(new Fraction(0.4).div(".1").toString(), new Fraction("4").toString());
    }

    @Test
    public void test_59(){  /* {"label":"1 / -.1","set":1,"fn":"div","param":"-.1","expect":"-10"} */
        assertEquals(new Fraction(1).div("-.1").toString(), new Fraction("-10").toString());
    }

    @Test
    public void test_60(){  /* {"label":"1 - (-1)","set":1,"fn":"sub","param":"-1","expect":"2"} */
        assertEquals(new Fraction(1).sub("-1").toString(), new Fraction("2").toString());
    }

    @Test
    public void test_61(){  /* {"label":"1 + (-1)","set":1,"fn":"add","param":"-1","expect":"0"} */
        assertEquals(new Fraction(1).add("-1").toString(), new Fraction("0").toString());
    }

    @Test
    public void test_62(){  /* {"label":"-187 % 12","set":"-187","fn":"mod","param":"12","expect":"-7"} */
        assertEquals(new Fraction("-187").mod("12").toString(), new Fraction("-7").toString());
    }

    @Test
    public void test_63(){  /* {"label":"Negate by 99 * -1","set":"99","fn":"mul","param":"-1","expect":"-99"} */
        assertEquals(new Fraction("99").mul("-1").toString(), new Fraction("-99").toString());
    }

    @Test
    public void test_64(){  /* {"set":[20,-5],"expect":"-4","fn":"toFraction","param":true} */
        assertEquals(new Fraction(new int[]{20,-5}).toFraction(true), new Fraction("-4").toFraction(true));
    }

    @Test
    public void test_65(){  /* {"set":[-10,-7],"expect":"1 3/7","fn":"toFraction","param":true} */
        assertEquals(new Fraction(new int[]{-10,-7}).toFraction(true), new Fraction("1 3/7").toFraction(true));
    }

    @Test
    public void test_66(){  /* {"set":[21,-6],"expect":"-3 1/2","fn":"toFraction","param":true} */
        assertEquals(new Fraction(new int[]{21,-6}).toFraction(true), new Fraction("-3 1/2").toFraction(true));
    }

    @Test
    public void test_67(){  /* {"set":"10/78","expect":"5/39","fn":"toFraction","param":true} */
        assertEquals(new Fraction("10/78").toFraction(true), new Fraction("5/39").toFraction(true));
    }

    @Test
    public void test_68(){  /* {"set":"0/91","expect":"0","fn":"toFraction","param":true} */
        assertEquals(new Fraction("0/91").toFraction(true), new Fraction("0").toFraction(true));
    }

    @Test
    public void test_69(){  /* {"set":"-0/287","expect":"0","fn":"toFraction","param":true} */
        assertEquals(new Fraction("-0/287").toFraction(true), new Fraction("0").toFraction(true));
    }

    @Test
    public void test_70(){  /* {"set":"-5/20","expect":"-1/4","fn":"toFraction","param":true} */
        assertEquals(new Fraction("-5/20").toFraction(true), new Fraction("-1/4").toFraction(true));
    }

    @Test
    public void test_71(){  /* {"set":"42/9","expect":"4 2/3","fn":"toFraction","param":true} */
        assertEquals(new Fraction("42/9").toFraction(true), new Fraction("4 2/3").toFraction(true));
    }

    @Test
    public void test_72(){  /* {"set":"71/23","expect":"3 2/23","fn":"toFraction","param":true} */
        assertEquals(new Fraction("71/23").toFraction(true), new Fraction("3 2/23").toFraction(true));
    }

    @Test
    public void test_73(){  /* {"set":"6/3","expect":"2","fn":"toFraction","param":true} */
        assertEquals(new Fraction("6/3").toFraction(true), new Fraction("2").toFraction(true));
    }

    @Test
    public void test_74(){  /* {"set":"28/4","expect":"7","fn":"toFraction","param":true} */
        assertEquals(new Fraction("28/4").toFraction(true), new Fraction("7").toFraction(true));
    }

    @Test
    public void test_75(){  /* {"set":"105/35","expect":"3","fn":"toFraction","param":true} */
        assertEquals(new Fraction("105/35").toFraction(true), new Fraction("3").toFraction(true));
    }

    @Test
    public void test_76(){  /* {"set":"4/6","expect":"2/3","fn":"toFraction","param":true} */
        assertEquals(new Fraction("4/6").toFraction(true), new Fraction("2/3").toFraction(true));
    }

    @Test
    public void test_77(){  /* {"label":"99.(9) + 66","set":"99.(999999)","fn":"add","param":"66","expect":"166"} */
        assertEquals(new Fraction("99.(999999)").add("66").toString(), new Fraction("166").toString());
    }

    @Test
    public void test_79(){  /* {"label":"100 - .91","set":"100","fn":"sub","param":".91","expect":"99.09"} */
        assertEquals(new Fraction("100").sub(".91").toString(), new Fraction("99.09").toString());
    }

    @Test
    public void test_80(){  /* {"label":"381.(33411) % 11.119(356)","set":"381.(33411)","fn":"mod","param":"11.119(356)","expect":"3.275(997225017295217)"} */
        assertEquals(new Fraction("381.(33411)").mod("11.119(356)").toString(), "3.275(997225017295217)");
    }

    @Test
    public void test_81(){  /* {"label":"13/26 mod 1","set":"13/26","fn":"mod","param":"1.000","expect":"0.5"} */
        assertEquals(new Fraction("13/26").mod("1.000").toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_82(){  /* {"label":"381.(33411) % 1","set":"381.(33411)","fn":"mod","param":"1","expect":"0.(33411)"} */
        assertEquals(new Fraction("381.(33411)").mod("1").toString(), new Fraction("0.(33411)").toString());
    }

    @Test
    public void test_84(){  /* {"label":"inverse","set":0.5,"fn":"inverse","expect":"2"} */
        assertEquals(new Fraction(0.5).inverse().toString(), new Fraction("2").toString());
    }

    @Test
    public void test_86(){  /* {"label":"9 % -2","set":9,"fn":"mod","param":"-2","expect":"1"} */
        assertEquals(new Fraction(9).mod("-2").toString(), new Fraction("1").toString());
    }

    @Test
    public void test_87(){  /* {"label":"-9 % 2","set":"-9","fn":"mod","param":"-2","expect":"-1"} */
        assertEquals(new Fraction("-9").mod("-2").toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_88(){  /* {"label":"1 / 195312500","set":"1","fn":"div","param":"195312500","expect":"0.00000000512"} */
        assertEquals(new Fraction("1").div("195312500").toString(), new Fraction("0.00000000512").toString());
    }

    @Test(expected = DivisionByZeroException.class)  // todo {io.github.mrrefactoring.Fraction.DivisionByZero}
    public void test_89(){
        new Fraction(10).div(0);
    }

    @Test
    public void test_90(){  /* {"label":"-3 / 4","set":[-3,4],"fn":"inverse","expect":"-1.(3)"} */
        assertEquals(new Fraction(new int[]{-3,4}).inverse().toString(), new Fraction("-1.(3)").toString());
    }

    @Test

    public void test_91(){
        assertTrue(new Fraction(new int[]{-98,5}).equals("-19.6"));
    }

    @Test

    public void test_92(){
        assertTrue(new Fraction(new int[]{98,-5}).equals("-19.6"));
    }

    @Test

    public void test_93(){
        assertFalse(new Fraction(new int[]{99,88}).equals(new Fraction(new int[]{88,99})));
    }

    @Test

    public void test_94(){
        assertFalse(new Fraction(new int[]{99,-88}).equals(new Fraction(new int[]{9,8})));
    }

    @Test
    public void test_95(){  /* {"label":"12.5","set":12.5,"fn":"add","param":0,"expect":"12.5"} */
        assertEquals(new Fraction(12.5).add(0).toString(), new Fraction("12.5").toString());
    }

    @Test(expected = DivisionByZeroException.class)  // todo {io.github.mrrefactoring.Fraction.DivisionByZero}
    public void test_96(){
        new Fraction(0).inverse();
    }

    @Test
    public void test_97(){  /* {"label":"abs(-100.25)","set":-100.25,"fn":"abs","expect":"100.25"} */
        assertEquals(new Fraction(-100.25).abs().toString(), new Fraction("100.25").toString());
    }

    @Test
    public void test_98(){  /* {"label":"0.022222222","set":"0.0(22222222)","fn":"abs","expect":"0.0(2)"} */
        assertEquals(new Fraction("0.0(22222222)").abs().toString(), new Fraction("0.0(2)").toString());
    }

    @Test

    public void test_99(){
        assertTrue(new Fraction(100.5).divisible("1.5"));
    }

    @Test

    public void test_100(){
        assertFalse(new Fraction(100.6).divisible(1.6));
    }

    @Test

    public void test_101(){
        assertTrue(new Fraction(new int[]{2,3}).divisible(new int[]{1,6}));
    }

    @Test

    public void test_102(){
        assertFalse(new Fraction(new int[]{2,5}).divisible(new int[]{1,6}));
    }

    @Test

    public void test_103(){
        assertFalse(new Fraction(new int[]{2,5}).divisible(0));
    }

    @Test

    public void test_104(){
        assertTrue(new Fraction(0).divisible(6));
    }

    @Test
    public void test_105(){  /* {"label":"fmod(4.55, 0.05)","set":4.55,"fn":"mod","param":0.05,"expect":"0"} */
        assertEquals(new Fraction(4.55).mod(0.05).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_106(){  /* {"label":"fmod(99.12, 0.4)","set":99.12,"fn":"mod","param":"0.4","expect":"0.32"} */
        assertEquals(new Fraction(99.12).mod("0.4").toString(), new Fraction("0.32").toString());
    }

    @Test
    public void test_107(){  /* {"label":"fmod(fmod(1.0,0.1))","set":1,"fn":"mod","param":0.1,"expect":"0"} */
        assertEquals(new Fraction(1).mod(0.1).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_109(){  /* {"label":"ceil(0.4)","set":0.4,"fn":"ceil","expect":"1"} */
        assertEquals(new Fraction(0.4).ceil().toString(), new Fraction("1").toString());
    }

    @Test
    public void test_110(){  /* {"label":"ceil(0.5)","set":0.5,"fn":"ceil","expect":"1"} */
        assertEquals(new Fraction(0.5).ceil().toString(), new Fraction("1").toString());
    }

    @Test
    public void test_111(){  /* {"label":"ceil(0.23, 2)","set":0.23,"fn":"ceil","param":2,"expect":"0.23"} */
        assertEquals(new Fraction(0.23).ceil(2).toString(), new Fraction("0.23").toString());
    }

    @Test
    public void test_112(){  /* {"label":"ceil(0.6)","set":0.6,"fn":"ceil","expect":"1"} */
        assertEquals(new Fraction(0.6).ceil().toString(), new Fraction("1").toString());
    }

    @Test
    public void test_113(){  /* {"label":"ceil(-0.4)","set":-0.4,"fn":"ceil","expect":"0"} */
        assertEquals(new Fraction(-0.4).ceil().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_114(){  /* {"label":"ceil(-0.5)","set":-0.5,"fn":"ceil","expect":"0"} */
        assertEquals(new Fraction(-0.5).ceil().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_115(){  /* {"label":"ceil(-0.6)","set":-0.6,"fn":"ceil","expect":"0"} */
        assertEquals(new Fraction(-0.6).ceil().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_116(){  /* {"label":"floor(0.4)","set":0.4,"fn":"floor","expect":"0"} */
        assertEquals(new Fraction(0.4).floor().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_117(){  /* {"label":"floor(0.4, 1)","set":0.4,"fn":"floor","param":1,"expect":"0.4"} */
        assertEquals(new Fraction(0.4).floor(1).toString(), new Fraction("0.4").toString());
    }

    @Test
    public void test_118(){  /* {"label":"floor(0.5)","set":0.5,"fn":"floor","expect":"0"} */
        assertEquals(new Fraction(0.5).floor().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_119(){  /* {"label":"floor(0.6)","set":0.6,"fn":"floor","expect":"0"} */
        assertEquals(new Fraction(0.6).floor().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_120(){  /* {"label":"floor(-0.4)","set":-0.4,"fn":"floor","expect":"-1"} */
        System.out.println(new Fraction(-0.4));
        assertEquals(new Fraction(-0.4).floor().toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_121(){  /* {"label":"floor(-0.5)","set":-0.5,"fn":"floor","expect":"-1"} */
        assertEquals(new Fraction(-0.5).floor().toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_122(){  /* {"label":"floor(-0.6)","set":-0.6,"fn":"floor","expect":"-1"} */
        assertEquals(new Fraction(-0.6).floor().toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_123(){  /* {"label":"round(0.4)","set":0.4,"fn":"round","expect":"0"} */
        assertEquals(new Fraction(0.4).round().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_124(){  /* {"label":"round(0.5)","set":0.5,"fn":"round","expect":"1"} */
        assertEquals(new Fraction(0.5).round().toString(), new Fraction("1").toString());
    }

    @Test
    public void test_125(){  /* {"label":"round(0.5, 1)","set":0.5,"fn":"round","param":1,"expect":"0.5"} */
        assertEquals(new Fraction(0.5).round(1).toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_126(){  /* {"label":"round(0.6)","set":0.6,"fn":"round","expect":"1"} */
        assertEquals(new Fraction(0.6).round().toString(), new Fraction("1").toString());
    }

    @Test
    public void test_127(){  /* {"label":"round(-0.4)","set":-0.4,"fn":"round","expect":"0"} */
        assertEquals(new Fraction(-0.4).round().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_128(){  /* {"label":"round(-0.5)","set":-0.5,"fn":"round","expect":"0"} */
        assertEquals(new Fraction(-0.5).round().toString(), new Fraction("0").toString());
    }

    @Test
    public void test_129(){  /* {"label":"round(-0.6)","set":-0.6,"fn":"round","expect":"-1"} */
        assertEquals(new Fraction(-0.6).round().toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_130(){  /* {"label":"17402216385200408/5539306332998545","set":[17402216385200408,5539306332998545],"fn":"add","param":0,"expect":"3.141587653589870"} */
        assertEquals(new Fraction(new long[]{17_402_216_385_200_408L, 5_539_306_332_998_545L}).add(0).toString(), new Fraction("3.141587653589870").toString());
    }

    @Test
    public void test_131(){  /* {"label":"17402216385200401/553930633299855","set":[17402216385200400,553930633299855],"fn":"add","param":0,"expect":"31.415876535898660"} */
        System.out.println(new Fraction(new long[]{17_402_216_385_200_400L, 553_930_633_299_855L}).add(0).toString());
        assertEquals(new Fraction(new long[]{17_402_216_385_200_400L, 553_930_633_299_855L}).add(0).toString(), new Fraction("31.415876535898660").toString());
    }

    @Test
    public void test_132(){  /* {"label":"1283191/418183","set":[1283191,418183],"fn":"add","param":0,"expect":"3.068491545567371"} */
        assertEquals(new Fraction(new int[]{1_283_191, 418_183}).add(0).toString(), new Fraction("3.068491545567371").toString());
    }

    @Test
    public void test_133(){  /* {"label":"1.001","set":"1.001","fn":"add","param":0,"expect":"1.001"} */
        assertEquals(new Fraction("1.001").add(0).toString(), new Fraction("1.001").toString());
    }

    @Test
    public void test_134(){  /* {"label":"99+1","set":[99,1],"fn":"add","param":1,"expect":"100"} */
        assertEquals(new Fraction(new int[]{99,1}).add(1).toString(), new Fraction("100").toString());
    }

    @Test
    public void test_135(){  /* {"label":"gcd(5/8, 3/7)","set":[5,8],"fn":"gcd","param":[3,7],"expect":"0.017(857142)"} */
        assertEquals(new Fraction(new int[]{5,8}).gcd(new int[]{3,7}).toString(), new Fraction("0.017(857142)").toString());
    }

    @Test
    public void test_136(){  /* {"label":"gcd(52, 39)","set":52,"fn":"gcd","param":39,"expect":"13"} */
        assertEquals(new Fraction(52).gcd(39).toString(), new Fraction("13").toString());
    }

    @Test
    public void test_137(){  /* {"label":"gcd(51357, 3819)","set":51357,"fn":"gcd","param":3819,"expect":"57"} */
        assertEquals(new Fraction(51357).gcd(3819).toString(), new Fraction("57").toString());
    }

    @Test
    public void test_138(){  /* {"label":"gcd(841, 299)","set":841,"fn":"gcd","param":299,"expect":"1"} */
        assertEquals(new Fraction(841).gcd(299).toString(), new Fraction("1").toString());
    }

    @Test
    public void test_139(){  /* {"label":"gcd(2/3, 7/5)","set":[2,3],"fn":"gcd","param":[7,5],"expect":"0.0(6)"} */
        assertEquals(new Fraction(new int[]{2,3}).gcd(new int[]{7,5}).toString(), new Fraction("0.0(6)").toString());
    }

    @Test
    public void test_140(){  /* {"label":"lcm(-3, 3)","set":-3,"fn":"lcm","param":3,"expect":"3"} */
        assertEquals(new Fraction(-3).lcm(3).toString(), new Fraction("3").toString());
    }

    @Test
    public void test_141(){  /* {"label":"lcm(3,-3)","set":3,"fn":"lcm","param":-3,"expect":"3"} */
        assertEquals(new Fraction(3).lcm(-3).toString(), new Fraction("3").toString());
    }

    @Test
    public void test_142(){  /* {"label":"lcm(0,3)","set":0,"fn":"lcm","param":3,"expect":"0"} */
        assertEquals(new Fraction(0).lcm(3).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_143(){  /* {"label":"lcm(3, 0)","set":3,"fn":"lcm","param":0,"expect":"0"} */
        assertEquals(new Fraction(3).lcm(0).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_144(){  /* {"label":"lcm(0, 0)","set":0,"fn":"lcm","param":0,"expect":"0"} */
        assertEquals(new Fraction(0).lcm(0).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_145(){  /* {"label":"lcm(200, 333)","set":200,"fn":"lcm","param":333,"expect":"66600"} */
        assertEquals(new Fraction(200).lcm(333).toString(), new Fraction("66600").toString());
    }

    @Test
    public void test_146(){  /* {"label":"1 + -1","set":1,"fn":"add","param":-1,"expect":"0"} */
        assertEquals(new Fraction(1).add(-1).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_147(){  /* {"label":"3/10+3/14","set":"3/10","fn":"add","param":"3/14","expect":"0.5(142857)"} */
        assertEquals(new Fraction("3/10").add("3/14").toString(), new Fraction("0.5(142857)").toString());
    }

    @Test
    public void test_148(){  /* {"label":"3/10-3/14","set":"3/10","fn":"sub","param":"3/14","expect":"0.0(857142)"} */
        assertEquals(new Fraction("3/10").sub("3/14").toString(), new Fraction("0.0(857142)").toString());
    }

    @Test
    public void test_149(){  /* {"label":"3/10*3/14","set":"3/10","fn":"mul","param":"3/14","expect":"0.06(428571)"} */
        assertEquals(new Fraction("3/10").mul("3/14").toString(), new Fraction("0.06(428571)").toString());
    }

    @Test
    public void test_150(){  /* {"label":"3/10 / 3/14","set":"3/10","fn":"div","param":"3/14","expect":"1.4"} */
        assertEquals(new Fraction("3/10").div("3/14").toString(), new Fraction("1.4").toString());
    }

    @Test
    public void test_151(){  /* {"label":"1-2","set":"1","fn":"sub","param":"2","expect":"-1"} */
        assertEquals(new Fraction("1").sub("2").toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_152(){  /* {"label":"1--1","set":"1","fn":"sub","param":"-1","expect":"2"} */
        assertEquals(new Fraction("1").sub("-1").toString(), new Fraction("2").toString());
    }

    @Test
    public void test_153(){  /* {"label":"0/1*1/3","set":"0/1","fn":"mul","param":"1/3","expect":"0"} */
        assertEquals(new Fraction("0/1").mul("1/3").toString(), new Fraction("0").toString());
    }

    @Test
    public void test_154(){  /* {"label":"3/10 * 8/12","set":"3/10","fn":"mul","param":"8/12","expect":"0.2"} */
        assertEquals(new Fraction("3/10").mul("8/12").toString(), new Fraction("0.2").toString());
    }

    @Test
    public void test_155(){  /* {"label":".5+5","set":".5","fn":"add","param":5,"expect":"5.5"} */
        assertEquals(new Fraction(".5").add(5).toString(), new Fraction("5.5").toString());
    }

    @Test
    public void test_156(){  /* {"label":"10/12-5/60","set":"10/12","fn":"sub","param":"5/60","expect":"0.75"} */
        assertEquals(new Fraction("10/12").sub("5/60").toString(), new Fraction("0.75").toString());
    }

    @Test
    public void test_157(){  /* {"label":"10/15 / 3/4","set":"10/15","fn":"div","param":"3/4","expect":"0.(8)"} */
        assertEquals(new Fraction("10/15").div("3/4").toString(), new Fraction("0.(8)").toString());
    }

    @Test
    public void test_158(){  /* {"label":"1/4 + 3/8","set":"1/4","fn":"add","param":"3/8","expect":"0.625"} */
        assertEquals(new Fraction("1/4").add("3/8").toString(), new Fraction("0.625").toString());
    }

    @Test
    public void test_159(){  /* {"label":"2-1/3","set":"2","fn":"sub","param":"1/3","expect":"1.(6)"} */
        assertEquals(new Fraction("2").sub("1/3").toString(), new Fraction("1.(6)").toString());
    }

    @Test
    public void test_160(){  /* {"label":"5*6","set":"5","fn":"mul","param":6,"expect":"30"} */
        assertEquals(new Fraction("5").mul(6).toString(), new Fraction("30").toString());
    }

    @Test
    public void test_161(){  /* {"label":"1/2-1/5","set":"1/2","fn":"sub","param":"1/5","expect":"0.3"} */
        assertEquals(new Fraction("1/2").sub("1/5").toString(), new Fraction("0.3").toString());
    }

    @Test
    public void test_162(){  /* {"label":"1/2-5","set":"1/2","fn":"add","param":-5,"expect":"-4.5"} */
        assertEquals(new Fraction("1/2").add(-5).toString(), new Fraction("-4.5").toString());
    }

    @Test
    public void test_163(){  /* {"label":"1*-1","set":"1","fn":"mul","param":-1,"expect":"-1"} */
        assertEquals(new Fraction("1").mul(-1).toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_164(){  /* {"label":"5/10","set":5,"fn":"div","param":10,"expect":"0.5"} */
        assertEquals(new Fraction(5).div(10).toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_165(){  /* {"label":"1/-1","set":"1","fn":"div","param":-1,"expect":"-1"} */
        assertEquals(new Fraction("1").div(-1).toString(), new Fraction("-1").toString());
    }

    @Test
    public void test_166(){  /* {"label":"4/5 + 13/2","set":"4/5","fn":"add","param":"13/2","expect":"7.3"} */
        assertEquals(new Fraction("4/5").add("13/2").toString(), new Fraction("7.3").toString());
    }

    @Test
    public void test_167(){  /* {"label":"4/5 + 61/2","set":"4/5","fn":"add","param":"61/2","expect":"31.3"} */
        assertEquals(new Fraction("4/5").add("61/2").toString(), new Fraction("31.3").toString());
    }

    @Test
    public void test_168(){  /* {"label":"0.8 + 6.5","set":"0.8","fn":"add","param":"6.5","expect":"7.3"} */
        assertEquals(new Fraction("0.8").add("6.5").toString(), new Fraction("7.3").toString());
    }

    @Test
    public void test_169(){  /* {"label":"2/7 inverse","set":"2/7","fn":"inverse","expect":"3.5"} */
        assertEquals(new Fraction("2/7").inverse().toString(), new Fraction("3.5").toString());
    }

    @Test
    public void test_170(){  /* {"label":"neg 1/3","set":"1/3","fn":"neg","expect":"-0.(3)"} */
        assertEquals(new Fraction("1/3").neg().toString(), new Fraction("-0.(3)").toString());
    }

    @Test
    public void test_171(){  /* {"label":"1/2+1/3","set":"1/2","fn":"add","param":"1/3","expect":"0.8(3)"} */
        assertEquals(new Fraction("1/2").add("1/3").toString(), new Fraction("0.8(3)").toString());
    }

    @Test
    public void test_172(){  /* {"label":"1/2+3","set":".5","fn":"add","param":3,"expect":"3.5"} */
        assertEquals(new Fraction(".5").add(3).toString(), new Fraction("3.5").toString());
    }

    @Test
    public void test_173(){  /* {"label":"1/2+3.14","set":"1/2","fn":"add","param":"3.14","expect":"3.64"} */
        assertEquals(new Fraction("1/2").add("3.14").toString(), new Fraction("3.64").toString());
    }

    @Test
    public void test_174(){  /* {"label":"3.5 < 4.1","set":3.5,"fn":"compare","param":4.1,"expect":"-1"} */
        assertEquals(new Fraction(3.5).compareTo(4.1), -1);
    }

    @Test
    public void test_175(){  /* {"label":"3.5 > 4.1","set":4.1,"fn":"compare","param":3.1,"expect":"1"} */
        assertEquals(new Fraction(4.1).compareTo(3.1), 1);
    }

    @Test
    public void test_176(){  /* {"label":"-3.5 > -4.1","set":-3.5,"fn":"compare","param":-4.1,"expect":"1"} */
        assertEquals(new Fraction(-3.5).compareTo(-4.1), 1);
    }

    @Test
    public void test_177(){  /* {"label":"-3.5 > -4.1","set":-4.1,"fn":"compare","param":-3.5,"expect":"-1"} */
        assertEquals(new Fraction(-4.1).compareTo(-3.5), -1);
    }

    @Test
    public void test_178(){  /* {"label":"4.3 == 4.3","set":4.3,"fn":"compare","param":4.3,"expect":"0"} */
        assertEquals(new Fraction(4.3).compareTo(4.3), 0);
    }

    @Test
    public void test_179(){  /* {"label":"-4.3 == -4.3","set":-4.3,"fn":"compare","param":-4.3,"expect":"0"} */
        assertEquals(new Fraction(-4.3).compareTo(-4.3), 0);
    }

    @Test
    public void test_180(){  /* {"label":"-4.3 < 4.3","set":-4.3,"fn":"compare","param":4.3,"expect":"-1"} */
        assertEquals(new Fraction(-4.3).compareTo(4.3), -1);
    }

    @Test
    public void test_181(){  /* {"label":"4.3 == -4.3","set":4.3,"fn":"compare","param":-4.3,"expect":"1"} */
        assertEquals(new Fraction(4.3).compareTo(-4.3), 1);
    }

    @Test
    public void test_182(){  /* {"label":"-0.5^-3","set":-0.5,"fn":"pow","param":-3,"expect":"-8"} */
        assertEquals(new Fraction(-0.5).pow(-3).toString(), new Fraction("-8").toString());
    }

    @Test
    public void test_183(){  /* {"label":"","set":-3,"fn":"pow","param":-3,"expect":"-0.(037)"} */
        assertEquals(new Fraction(-3).pow(-3).toString(), new Fraction("-0.(037)").toString());
    }

    @Test
    public void test_184(){  /* {"label":"-3","set":-3,"fn":"pow","param":2,"expect":"9"} */
        assertEquals(new Fraction(-3).pow(2).toString(), new Fraction("9").toString());
    }

    @Test
    public void test_185(){  /* {"label":"-3","set":-3,"fn":"pow","param":3,"expect":"-27"} */
        assertEquals(new Fraction(-3).pow(3).toString(), new Fraction("-27").toString());
    }

    @Test
    public void test_186(){  /* {"label":"0^0","set":0,"fn":"pow","param":0,"expect":"1"} */
        assertEquals(new Fraction(0).pow(0).toString(), new Fraction("1").toString());
    }

    @Test
    public void test_188(){  /* {"label":"-0.6^4","set":-0.6,"fn":"pow","param":4,"expect":"0.1296"} */
        assertEquals(new Fraction(-0.6).pow(4).toString(), new Fraction("0.1296").toString());
    }

    @Test
    public void test_189(){  /* {"label":"8128371:12394 - 8128371/12394","set":"8128371:12394","fn":"sub","param":"8128371/12394","expect":"0"} */
        assertEquals(new Fraction("8128371:12394").sub("8128371/12394").toString(), new Fraction("0").toString());
    }

    @Test
    public void test_190(){  /* {"label":"3/4 + 1/4","set":"3/4","fn":"add","param":"1/4","expect":"1"} */
        assertEquals(new Fraction("3/4").add("1/4").toString(), new Fraction("1").toString());
    }

    @Test
    public void test_191(){  /* {"label":"1/10 + 2/10","set":"1/10","fn":"add","param":"2/10","expect":"0.3"} */
        assertEquals(new Fraction("1/10").add("2/10").toString(), new Fraction("0.3").toString());
    }

    @Test
    public void test_192(){  /* {"label":"5/10 + 2/10","set":"5/10","fn":"add","param":"2/10","expect":"0.7"} */
        assertEquals(new Fraction("5/10").add("2/10").toString(), new Fraction("0.7").toString());
    }

    @Test
    public void test_193(){  /* {"label":"18/10 + 2/10","set":"18/10","fn":"add","param":"2/10","expect":"2"} */
        assertEquals(new Fraction("18/10").add("2/10").toString(), new Fraction("2").toString());
    }

    @Test
    public void test_194(){  /* {"label":"1/3 + 1/6","set":"1/3","fn":"add","param":"1/6","expect":"0.5"} */
        assertEquals(new Fraction("1/3").add("1/6").toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_195(){  /* {"label":"1/3 + 2/6","set":"1/3","fn":"add","param":"2/6","expect":"0.(6)"} */
        assertEquals(new Fraction("1/3").add("2/6").toString(), new Fraction("0.(6)").toString());
    }

    @Test
    public void test_196(){  /* {"label":"3/4 / 1/4","set":"3/4","fn":"div","param":"1/4","expect":"3"} */
        assertEquals(new Fraction("3/4").div("1/4").toString(), new Fraction("3").toString());
    }

    @Test
    public void test_197(){  /* {"label":"1/10 / 2/10","set":"1/10","fn":"div","param":"2/10","expect":"0.5"} */
        assertEquals(new Fraction("1/10").div("2/10").toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_198(){  /* {"label":"5/10 / 2/10","set":"5/10","fn":"div","param":"2/10","expect":"2.5"} */
        assertEquals(new Fraction("5/10").div("2/10").toString(), new Fraction("2.5").toString());
    }

    @Test
    public void test_199(){  /* {"label":"18/10 / 2/10","set":"18/10","fn":"div","param":"2/10","expect":"9"} */
        assertEquals(new Fraction("18/10").div("2/10").toString(), new Fraction("9").toString());
    }

    @Test
    public void test_200(){  /* {"label":"1/3 / 1/6","set":"1/3","fn":"div","param":"1/6","expect":"2"} */
        assertEquals(new Fraction("1/3").div("1/6").toString(), new Fraction("2").toString());
    }

    @Test
    public void test_201(){  /* {"label":"1/3 / 2/6","set":"1/3","fn":"div","param":"2/6","expect":"1"} */
        assertEquals(new Fraction("1/3").div("2/6").toString(), new Fraction("1").toString());
    }

    @Test
    public void test_202(){  /* {"label":"3/4 * 1/4","set":"3/4","fn":"mul","param":"1/4","expect":"0.1875"} */
        assertEquals(new Fraction("3/4").mul("1/4").toString(), new Fraction("0.1875").toString());
    }

    @Test
    public void test_203(){  /* {"label":"1/10 * 2/10","set":"1/10","fn":"mul","param":"2/10","expect":"0.02"} */
        assertEquals(new Fraction("1/10").mul("2/10").toString(), new Fraction("0.02").toString());
    }

    @Test
    public void test_204(){  /* {"label":"5/10 * 2/10","set":"5/10","fn":"mul","param":"2/10","expect":"0.1"} */
        assertEquals(new Fraction("5/10").mul("2/10").toString(), new Fraction("0.1").toString());
    }

    @Test
    public void test_205(){  /* {"label":"18/10 * 2/10","set":"18/10","fn":"mul","param":"2/10","expect":"0.36"} */
        assertEquals(new Fraction("18/10").mul("2/10").toString(), new Fraction("0.36").toString());
    }

    @Test
    public void test_206(){  /* {"label":"1/3 * 1/6","set":"1/3","fn":"mul","param":"1/6","expect":"0.0(5)"} */
        assertEquals(new Fraction("1/3").mul("1/6").toString(), new Fraction("0.0(5)").toString());
    }

    @Test
    public void test_207(){  /* {"label":"1/3 * 2/6","set":"1/3","fn":"mul","param":"2/6","expect":"0.(1)"} */
        assertEquals(new Fraction("1/3").mul("2/6").toString(), new Fraction("0.(1)").toString());
    }

    @Test
    public void test_208(){  /* {"label":"5/4 - 1/4","set":"5/4","fn":"sub","param":"1/4","expect":"1"} */
        assertEquals(new Fraction("5/4").sub("1/4").toString(), new Fraction("1").toString());
    }

    @Test
    public void test_209(){  /* {"label":"5/10 - 2/10","set":"5/10","fn":"sub","param":"2/10","expect":"0.3"} */
        assertEquals(new Fraction("5/10").sub("2/10").toString(), new Fraction("0.3").toString());
    }

    @Test
    public void test_210(){  /* {"label":"9/10 - 2/10","set":"9/10","fn":"sub","param":"2/10","expect":"0.7"} */
        assertEquals(new Fraction("9/10").sub("2/10").toString(), new Fraction("0.7").toString());
    }

    @Test
    public void test_211(){  /* {"label":"22/10 - 2/10","set":"22/10","fn":"sub","param":"2/10","expect":"2"} */
        assertEquals(new Fraction("22/10").sub("2/10").toString(), new Fraction("2").toString());
    }

    @Test
    public void test_212(){  /* {"label":"2/3 - 1/6","set":"2/3","fn":"sub","param":"1/6","expect":"0.5"} */
        assertEquals(new Fraction("2/3").sub("1/6").toString(), new Fraction("0.5").toString());
    }

    @Test
    public void test_213(){  /* {"label":"3/3 - 2/6","set":"3/3","fn":"sub","param":"2/6","expect":"0.(6)"} */
        assertEquals(new Fraction("3/3").sub("2/6").toString(), new Fraction("0.(6)").toString());
    }

    @Test
    public void test_214(){  /* {"label":"0.006999999999999999","set":0.006999999999999999,"fn":"add","param":0,"expect":"0.007"} */
        assertEquals(new Fraction(0.006999999999999999).add(0).toString(), new Fraction("0.007").toString());
    }

    @Test
    public void test_215(){  /* {"label":"1/7 - 1","set":0.14285714285714285,"fn":"add","param":-1,"expect":"-0.(857142)"} */
        assertEquals(new Fraction(0.14285714285714285).add(-1).toString(), new Fraction("-0.(857142)").toString());
    }

    @Test
    public void test_216(){  /* {"label":"0.0065 + 0.0005","set":0.0065,"fn":"add","param":0.0005,"expect":"0.007"} */
        assertEquals(new Fraction(0.0065).add(0.0005).toString(), new Fraction("0.007").toString());
    }

    @Test
    public void test_217(){  /* {"label":"6.5/.5","set":6.5,"fn":"div","param":0.5,"expect":"13"} */
        assertEquals(new Fraction(6.5).div(0.5).toString(), new Fraction("13").toString());
    }

    @Test
    public void test_218(){  /* {"label":"0.999999999999999999999999999","set":1,"fn":"sub","param":1,"expect":"0"} */
        assertEquals(new Fraction(1).sub(1).toString(), new Fraction("0").toString());
    }

    @Test
    public void test_219(){  /* {"label":"0.5833333333333334","set":0.5833333333333334,"fn":"add","param":0,"expect":"0.58(3)"} */
        assertEquals(new Fraction(0.5833333333333334).add(0).toString(), new Fraction("0.58(3)").toString());
    }

    @Test
    public void test_220(){  /* {"label":"1.75/3","set":0.5833333333333334,"fn":"add","param":0,"expect":"0.58(3)"} */
        assertEquals(new Fraction(0.5833333333333334).add(0).toString(), new Fraction("0.58(3)").toString());
    }

    @Test
    public void test_221(){  /* {"label":"3.3333333333333","set":3.3333333333333,"fn":"add","param":0,"expect":"3.(3)"} */
        assertEquals(new Fraction(3.3333333333333).add(0).toString(), new Fraction("3.(3)").toString());
    }

    @Test
    public void test_222(){  /* {"label":"4.285714285714285714285714","set":4.285714285714286,"fn":"add","param":0,"expect":"4.(285714)"} */
        assertEquals(new Fraction(4.285714285714286).add(0).toString(), new Fraction("4.(285714)").toString());
    }

    @Test
    public void test_223(){  /* {"label":"-4","set":-4,"fn":"neg","param":0,"expect":"4"} */
        assertEquals(new Fraction(-4).neg().toString(), new Fraction("4").toString());
    }

    @Test
    public void test_224(){  /* {"label":"4","set":4,"fn":"neg","param":0,"expect":"-4"} */
        assertEquals(new Fraction(4).neg().toString(), new Fraction("-4").toString());
    }

    @Test
    public void test_225(){  /* {"label":"0","set":0,"fn":"neg","param":0,"expect":"0"} */
        assertEquals(new Fraction(0).neg().toString(), new Fraction("0").toString());
    }


}
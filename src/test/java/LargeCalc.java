import org.junit.Assert;
import org.junit.Test;

public class LargeCalc extends Assert {

    private Fraction x = new Fraction(1123875);
    private Fraction y = new Fraction(1238750184);
    private Fraction z = new Fraction(1657134);

    private Fraction r = new Fraction(77344464613500L, 92063);

    private Fraction sr = x.mul(y).div(z);

    @Test
    public void largeCalcToFraction(){
        assertEquals(x.mul(y).div(z).toFraction(), r.toFraction());
    }

    @Test
    public void largeCalcToString(){
        assertEquals(x.mul(y).div(z).toString(), r.toString());
    }

    @Test
    public void largeCalcEquals(){
        System.out.println(sr.toFraction());
        System.out.println(r.toFraction());
        assertTrue(x.mul(y).div(z).equals(r));
    }

}

package io.github.mrrefactoring; /**
 * @license FractionOld.java v0.0.1 22/06/2018
 * https://github.com/MrRefactoring/Fraction.java
 *
 * Copyright (c) 2018, Vladislav Tupikin (MrRefactoring@yandex.ru)
 * Dual licensed under the MIT or GPL Version 2 licenses.
 **/

/**
 *
 * This class offers the possibility to calculate fractions.
 * You can pass a fraction in different formats. Either as array, as double, as string or as an integer.
 *
 * Array/Object form
 * [ 0 => <nominator>, 1 => <denominator> ]
 * [ n => <nominator>, d => <denominator> ]
 *
 * Integer form
 * - Single integer value
 *
 * Double form
 * - Single double value
 *
 * String form
 * 123.456 - a simple double
 * 123/456 - a string fraction
 * 123.'456' - a double with repeating decimal places
 * 123.(456) - synonym
 * 123.45'6' - a double with repeating last place
 * 123.45(6) - synonym
 *
 * Example:
 *
 * io.github.mrrefactoring.Fraction f = new io.github.mrrefactoring.Fraction("9.4'31'");
 * f.mul(new int[] {-4, 3}).div(4.9);
 *
 */

public class Fraction implements Comparable{

    // Maximum search depth for cyclic rational numbers. 2000 should be more than enough.
    // Example: 1/7 = 0.(142857) has 6 repeating decimal places.
    // If MAX_CYCLE_LEN gets reduced, long cycles will not be detected and toString() only gets the first 10 digits
    public static int MAX_CYCLE_LEN = 2000;
    public static boolean REDUCE = false;

    public long n = 0L;
    public long d = 1L;
    public int s = 1;

    private Parser parser = new Parser();

    // region Constructors region

    public Fraction(){}

    public Fraction(Fraction fraction){
        set(parser.parse(fraction.toArray()));
    }

    // region Strings input data

    public Fraction(String expression){
        this.set(this.parser.parse(expression));
    }

    public Fraction(String[] expression){
        this.set(this.parser.parse(expression));
    }

    public Fraction(String nominator, String denominator){
        this.set(this.parser.parse(nominator, denominator));
    }

    // endregion

    // region Numbers input data

    public Fraction(Number number){
        this.set(this.parser.parse(number));
    }

    public Fraction(Number[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(Number nominator, Number denominator){
        this.set(this.parser.parse(nominator, denominator));
    }

    // region Primitives types

    public Fraction(byte[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(short[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(int[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(long[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(double[] number){
        this.set(this.parser.parse(number));
    }

    public Fraction(float[] number){
        this.set(this.parser.parse(number));
    }

    // endregion

    // endregion

    // endregion

    // region Basic arithmetic operations

    // region Add operation

    /**
     * Adds two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction(2, 3).add("14.9") => 467 / 30
     **/
    public Fraction add(Fraction fraction){
        return new Fraction(
                this.s * this.n * fraction.d + fraction.s * this.d * fraction.n,
                this.d * fraction.d
        );
    }

    public Fraction add(Number number){
        return this.add(new Fraction(number));
    }

    public Fraction add(Number[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(String expression){
        return this.add(new Fraction(expression));
    }

    public Fraction add(String[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(byte[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(short[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(int[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(long[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(double[] number){
        return this.add(new Fraction(number));
    }

    public Fraction add(float[] number){
        return this.add(new Fraction(number));
    }

    // endregion

    // region Sub operation

    /**
     * Subtracts two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction(2, 3).add("14.9") => -427 / 30
     **/
    public Fraction sub(Fraction fraction){
        return new Fraction(
                this.s * this.n * fraction.d - fraction.s * this.d * fraction.n,
                this.d * fraction.d
        );
    }

    public Fraction sub(Number number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(Number[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(String expression){
        return this.sub(new Fraction(expression));
    }

    public Fraction sub(String[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(byte[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(short[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(int[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(long[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(double[] number){
        return this.sub(new Fraction(number));
    }

    public Fraction sub(float[] number){
        return this.sub(new Fraction(number));
    }

    // endregion

    // region Mul operation

    /**
     * Multiplies two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction("-17.(345)").mul(3) => 5776 / 111
     **/
    public Fraction mul(Fraction fraction){
        long[] firstFraction = this.toArray();
        long[] secondFraction = fraction.toArray();
        for (int i = 0; i < firstFraction.length; i++) {
            firstFraction[i] *= secondFraction[i];
        }
        return new Fraction(firstFraction);
    }

    public Fraction mul(Number number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(Number[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(String expression){
        return this.mul(new Fraction(expression));
    }

    public Fraction mul(String[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(byte[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(short[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(int[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(long[] number) {
        return this.mul(new Fraction(number));
    }
    public Fraction mul(double[] number){
        return this.mul(new Fraction(number));
    }

    public Fraction mul(float[] number){
        return this.mul(new Fraction(number));
    }

    // endregion

    // region Div operation

    /**
     * Divides two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction("-17.(345)").inverse().div(3)
     **/
    public Fraction div(Fraction fraction){
        long[] firstFraction = this.toArray();
        long[] secondFraction = fraction.toArray();
        firstFraction[0] *= secondFraction[1];
        firstFraction[1] *= secondFraction[0];
        firstFraction[2] *= secondFraction[2];
        return new Fraction(firstFraction);
    }

    public Fraction div(Number number){
        return this.div(new Fraction(number));
    }

    public Fraction div(Number[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(String expression){
        return this.div(new Fraction(expression));
    }

    public Fraction div(String[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(byte[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(short[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(int[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(long[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(double[] number){
        return this.div(new Fraction(number));
    }

    public Fraction div(float[] number){
        return this.div(new Fraction(number));
    }

    // endregion

    // endregion

    // region Math operation

    /**
     * Calculates the absolute value
     *
     * Ex: new io.github.mrrefactoring.Fraction(-4).abs() => 4
     **/
    public Fraction abs(){
        if (this.s < 0)
            return this.neg();
        return this.clone();
    }

    /**
     * Inverts the sign of the current fraction
     *
     * Ex: new io.github.mrrefactoring.Fraction(-4).neg() => 4
     **/
    public Fraction neg(){
        long[] fraction = this.toArray();
        fraction[2] = -fraction[2];
        return new Fraction(fraction);
    }

    /**
     * Gets the inverse of the fraction, means numerator and denumerator are exchanged
     *
     * Ex: new io.github.mrrefactoring.Fraction(new int[]{-3, 4}).inverse() => -4 / 3
     **/
    public Fraction inverse(){
        return new Fraction(new long[]{this.d, this.n, this.s});
    }

    // region mod methods region

    public Fraction mod(){
        return new Fraction(this.s * this.n % this.d, 1);
    }

    /**
     * Calculates the modulo of two rational numbers - a more precise fmod
     *
     * Ex: new io.github.mrrefactoring.Fraction('4.(3)').mod(new int[]{7, 8}) => (13/3) % (7/8) = (5/6)
     **/
    public Fraction mod(Fraction fraction){
        if (fraction.n == 0 && this.d == 0)
            new Fraction(0,0);  // ZeroDivisionException
        /*
        * First silly attempt, kinda slow
        *
        return that["sub"]({
        "n": num["n"] * Math.floor((this.n / this.d) / (num.n / num.d)),
        "d": num["d"],
        "s": this["s"]
        });*/

        /*
        * New attempt: a1 / b1 = a2 / b2 * q + r
        * => b2 * a1 = a2 * b1 * q + b1 * b2 * r
        * => (b2 * a1 % a2 * b1) / (b1 * b2)
        */
        return new Fraction(
                this.s * (fraction.d * this.n) % (fraction.n * this.d),
                fraction.d * this.d
        );
    }

    public Fraction mod(String expression){
        return this.mod(new Fraction(expression));
    }

    public Fraction mod(String[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(Number number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(Number[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(Number nominator, Number denominator){
        return this.mod(new Fraction(nominator, denominator));
    }

    public Fraction mod(byte[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(short[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(int[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(long[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(double[] number){
        return this.mod(new Fraction(number));
    }

    public Fraction mod(float[] number){
        return this.mod(new Fraction(number));
    }

    // endregion

    /**
     * Calculates the fraction to some integer exponent
     *
     * Ex: new io.github.mrrefactoring.Fraction(-1, 2).pow(-3) => -8
     */
    public Fraction pow(double exp){
        if (exp < 0)
            return new Fraction(Math.pow(this.s * this.d, -exp), Math.pow(this.n, -exp));
        else
            return new Fraction(Math.pow(this.s * this.n, exp), Math.pow(this.d, exp));
    }

    // region Greatest common divisor

    /**
     * Calculates the fractional gcd of two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction(5,8).gcd(3,7) => 1/56
     */
    public Fraction gcd(Fraction fraction){
        // gcd(a / b, c / d) = gcd(a, c) / lcm(b, d)
        return new Fraction(gcdAlgorithm(fraction.n, this.n) * gcdAlgorithm(fraction.d, this.d), fraction.d * this.d);
    }

    public Fraction gcd(String expression){
        return this.gcd(new Fraction(expression));
    }

    public Fraction gcd(String[] number){
        return this.gcd(new Fraction(number));
    }

    public Fraction gcd(Number number){
        return this.gcd(new Fraction(number));
    }

    public Fraction gcd(Number[] number){
        return this.gcd(new Fraction(number));
    }

    public Fraction gcd(byte[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(short[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(int[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(long[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(double[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(float[] fraction){
        return this.gcd(new Fraction(fraction));
    }

    public Fraction gcd(Number nominator, Number denominator){
        return this.gcd(new Fraction(nominator, denominator));
    }

    private double gcdAlgorithm(Number a, Number b){  // main realisation
        double aa = a.doubleValue();
        double bb = b.doubleValue();
        if (aa == 0)
            return bb;
        if (bb == 0)
            return aa;

        while (true) {
            aa %= bb;
            if (aa == 0)
                return bb;
            bb %= aa;
            if (bb == 0)
                return aa;
        }
    }

    // endregion

    // region Least common multiple

    /**
     * Calculates the fractional lcm of two rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction(5,8).lcm(3,7) => 15
     */
    public Fraction lcm(Fraction fraction){
        // lcm(a / b, c / d) = lcm(a, c) / gcd(b, d)

        if (fraction.n == 0 && this.n == 0) {
            return new Fraction(0);
        }
        return new Fraction(fraction.n * this.n, gcdAlgorithm(fraction.n, this.n) * gcdAlgorithm(fraction.d, this.d));
    }

    public Fraction lcm(String expression){
        return this.lcm(this.gcd(new Fraction(expression)));
    }

    public Fraction lcm(String[] number){
        return this.lcm(new Fraction(number));
    }

    public Fraction lcm(Number number){
        return this.lcm(new Fraction(number));
    }

    public Fraction lcm(Number[] number){
        return this.lcm(new Fraction(number));
    }

    public Fraction lcm(byte[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(short[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(int[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(long[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(double[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(float[] fraction){
        return this.lcm(new Fraction(fraction));
    }

    public Fraction lcm(Number nominator, Number denominator){
        return this.lcm(new Fraction(nominator, denominator));
    }

    // endregion

    /**
     * Calculates the ceil of a rational number
     *
     * Ex: new io.github.mrrefactoring.Fraction("4.(3)").ceil() => (5 / 1)
     **/
    public Fraction ceil(){
        return this.ceil(0);
    }

    public Fraction ceil(double places){
        places = Math.pow(10, places);
        return new Fraction(Math.ceil(places * this.valueOf()), places);
    }

    /**
     * Calculates the floor of a rational number
     *
     * Ex: new io.github.mrrefactoring.Fraction("4.(3)").floor() => (4 / 1)
     **/
    public Fraction floor(){
        return this.floor(0);
    }

    public Fraction floor(double places){
        places = Math.pow(10, places);
        return new Fraction(Math.floor(places * this.valueOf()), places);
    }

    /**
     * Rounds a rational numbers
     *
     * Ex: new io.github.mrrefactoring.Fraction("4.(3)").round() => (4 / 1)
     **/
    public Fraction round(){
        return this.round(0);
    }

    public Fraction round(double places){
        places = Math.pow(10, places);
        return new Fraction(Math.round(places * this.s * this.n / this.d), places);
    }

    // endregion

    // region Other functionality

    // region Divisible region

    public boolean divisible(Fraction fraction){
        return !((fraction.n * this.d) == 0 || ((this.n * fraction.d) % (fraction.n * this.d)) != 0);
    }

    public boolean divisible(Number number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(Number[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(String number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(String[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(Number nominator, Number denominator){
        return this.divisible(new Fraction(nominator, denominator));
    }

    public boolean divisible(byte[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(short[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(int[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(long[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(double[] number){
        return this.divisible(new Fraction(number));
    }

    public boolean divisible(float[] number){
        return this.divisible(new Fraction(number));
    }

    // endregion

    public long[] toArray(){
        return new long[] {this.n, this.d, this.s};
    }

    public double valueOf(){
        return (double) this.s * (double) this.n / (double) this.d;
    }

    public double toDecimal(){
        return this.valueOf();
    }

    public Fraction simplify(){
        return this.simplify(0.001);
    }

    public Fraction simplify(double eps){
        long[] cont = this.abs().toArray();

        for (int i = 0; i < cont.length; i++) {
            Fraction tmp = rec(slice(cont, 0, i + 1));
            if (tmp.sub(this.abs()).abs().valueOf() > eps)
                return tmp.mul(this.s);
        }
        return this;

    }

    /**
     * Returns a latex representation of a io.github.mrrefactoring.Fraction object
     *
     * Ex: new io.github.mrrefactoring.Fraction("1.'3'").toLatex() => "\frac{4}{3}"
     **/
    public String toLatex(){
        return this.toLatex(false);
    }

    public String toLatex(boolean excludeWhole){
        String str = "";
        long n = this.n;
        long d = this.d;
        double whole = Math.floor(n / d);

        if (this.s < 0)
            str += '-';

        if (d == 1)
            return str + n;

        if (excludeWhole && whole > 0){
            str += whole;
            n %= d;
        }

        str += "\\frac{";
        str += n;
        str += "}{";
        str += d;
        str += "}";

        return str;
    }

    /**
     * Gets a string representation of the fraction
     * The optional boolean parameter indicates if you want to exclude the whole part. "1 1/3" instead of "4/3"
     */
    public String toFraction(){
        return toFraction(false);
    }

    public String toFraction(boolean excludeWhole){
        String str = "";
        long n = this.n;
        long d = this.d;
        double whole = Math.floor(n / d);

        if (this.s < 0)
            str += '-';

        if (d == 1)
            return str + n;

        if (excludeWhole && whole > 0){
            str += (long) whole;
            str += " ";
            n %= d;
        }

        str += n;
        str += '/';
        str += d;

        return str;
    }

    // endregion

    // region Overrides

    /**
     * Check if two rational numbers are the same
     *
     * Ex: new io.github.mrrefactoring.Fraction(19.6).equals(new int[]{98, 5});
     **/
    @Override
    public boolean equals(Object o) {
        parser = new Parser();
        long[] fraction;
        try {
            fraction = new Fraction(parser.parse(o)).toArray();
        } catch (IllegalArgumentException|ArithmeticException e){
            return false;
        }
        long[] thisFraction = this.toArray();
        for (int i = 0; i < thisFraction.length; i++)
            if (thisFraction[i] != fraction[i])
                return false;
        return true;
    }

    /**
     * Check if two rational numbers are the same
     *
     * Ex: new io.github.mrrefactoring.Fraction(19.6).compareTo(new int[]{98, 5});
     **/
    @Override
    public int compareTo(Object o) {
        Fraction fraction = new Fraction(parser.parse(o));
        double t = (this.s * this.n * fraction.d - fraction.s * fraction.n * this.d);
        //return (0 < t) - (t < 0);
        if (t < 0)
            return -1;
        else if (0 < t)
            return 1;
        else
            return 0;
    }

    @Override
    protected Fraction clone() {
        return new Fraction(this.toArray());
    }

    /**
     * Creates a string representation of a fraction with all digits
     *
     * Ex: new io.github.mrrefactoring.Fraction("100.'91823'").toString() => "100.(91823)"
     **/
    @Override
    public String toString() {
        long n = this.n;
        long d = this.d;

        if (!REDUCE){
            long g = (long) this.gcdAlgorithm(n, d);
            n /= g;
            d /= g;
        }

        int dec = 15; // 15 = decimal places when no repetition
        int cycleLength = cycleLength(n, d);  // Cycle length
        int cycleOff = cycleStart(n, d, cycleLength);  // Cycle start

        StringBuilder string = this.s == -1 ? new StringBuilder("-"): new StringBuilder();

        string.append(n / d);

        n %= d;
        n *= 10;

        if (n != 0)
            string.append('.');

        if (cycleLength != 0){

            for (int i = cycleOff; i > 0; i--){
                string.append(n / d);
                n %= d;
                n *= 10;
            }

            string.append('(');

            for (int i = cycleLength; i > 0; i--){
                string.append(n / d);
                n %= d;
                n *= 10;
            }

            string.append(')');

        } else {
            for (long i = dec; n != 0 && i-- != 0;){
                string.append(n / d);
                n %= d;
                n *= 10;
            }
            if (string.toString().lastIndexOf("0") == string.toString().length() - 1 && this.n != 0){  // todo very bad way
                return string.toString().substring(0, string.toString().length() - 1);
            }
        }
        return string.toString();
    }

    // endregion

    // region Helpers

    private void set(Number[] fraction){
        if (fraction[0].longValue() >= Long.MAX_VALUE || fraction[1].longValue() >= Long.MAX_VALUE)
            throw new OverflowException("io.github.mrrefactoring.Fraction values overflow");
        double gcd = !Fraction.REDUCE ? this.gcdAlgorithm(fraction[0].longValue(), fraction[1].longValue()): 1;
        this.n = (long) (fraction[0].longValue() / gcd);
        this.d = (long) (fraction[1].longValue() / gcd);
        this.s = fraction[2].intValue();
        if (this.d == 0)
            throw new DivisionByZeroException();
        if (this.n == 0)
            this.s = 1;
    }

    private Fraction rec(long[] a){
        if (a.length == 1)
            return new Fraction(a);
        return rec(slice(a, 1)).inverse().add(a[0]);
    }

    private long[] slice(long[] array, int startIndex){
        long[] result = new long[array.length - 1 - startIndex];
        for (int i = 0; i < array.length - startIndex; i++)
            result[i] = array[i + startIndex];
        return result;
    }

    private long[] slice(long[] array, int startIndex, int endIndex){
        long[] result = new long[array.length - 1 - startIndex - endIndex];
        for (int i = 0; i < array.length - startIndex - endIndex; i++)
            result[i] = array[i + startIndex];
        return result;
    }

    private long modpow(long b, long e, long m){
        long r = 1;
        for (; e > 0; b = (b * b) % m, e >>= 1){
            if (e % 2 == 1){
                r = (r * b) % m;
            }
        }
        return r;
    }

    private int cycleLength(long n, long d){
        while (d % 2 == 0) d /= 2;
        while (d % 5 == 0) d /= 5;

        if (d == 1)  // Catch non-cyclic numbers
            return 0;

        // If we would like to compute really large numbers quicker, we could make use of Fermat's little theorem:
        // 10^(d-1) % d == 1
        // However, we don't need such large numbers and MAX_CYCLE_LEN should be the capstone,
        // as we want to translate the numbers to strings.

        long rem = 10 % d;
        int t = 1;

        for (; rem != 1; t++){
            rem = rem * 10 % d;
            if (t > MAX_CYCLE_LEN)
                return 0;
        }
        return t;
    }

    private int cycleStart(long n, long d, int cycle){
        long rem1 = 1;
        long rem2 = modpow(10, cycle, d);

        for (int t = 0; t < 300; t++){  // s < ~log10(Number.MAX_VALUE)
            // Solve 10^s == 10^(s+t) (mod d)
            if (rem1 == rem2)
                return t;

            rem1 = rem1 * 10 % d;
            rem2 = rem2 * 10 % d;
        }
        return 0;
    }

    // endregion

}

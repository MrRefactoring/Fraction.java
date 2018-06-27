import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private long n = 0L;
    private long d = 0L;
    private int s = 1;

    public Number[] parse(Object o){
        if (o.getClass() == String.class)
            return parse((String) o);
        if (o.getClass() == Number.class ||
            o.getClass() == Integer.class||
            o.getClass() == Byte.class ||
            o.getClass() == Short.class ||
            o.getClass() == Long.class ||
            o.getClass() == Double.class ||
            o.getClass() == Float.class
            ) return parse((Number) o);
        if (o.getClass() == Number[].class ||
            o.getClass() == Integer[].class||
            o.getClass() == Byte[].class ||
            o.getClass() == Short[].class ||
            o.getClass() == Long[].class ||
            o.getClass() == Double[].class ||
            o.getClass() == Float[].class
            ) return parse((Number[]) o);
        if (
            o.getClass() == int[].class||
            o.getClass() == byte[].class ||
            o.getClass() == short[].class ||
            o.getClass() == long[].class ||
            o.getClass() == double[].class ||
            o.getClass() == float[].class
            ) return parse((double[]) o);
        if (o.getClass() == Fraction.class)
            return parse(((Fraction) o).toArray());
        throw new IllegalArgumentException("Can not cast to fraction object");
    }

    // region String parse region

    public Number[] parse(String expression){
        int i = 0;  // iterator for parts
        String[] parts = separate(expression);
        if (parts.length == 0)
            throw new IllegalArgumentException("Wrong input string (" + expression + ")");

        if (parts[i].equals("-")){  // Check for minus sign at the beginning
            this.s = -1;
            i++;
        } else if (parts[i].equals("+"))  // Check for plus sign at the beginning
            i++;

        if (parts.length == i + 1) {  // Check if it's just a simple number "1234"
            return new Number[]{Math.abs(assign(parts[i])), 1L, this.s};
        }

        long v = 0, w = 0, x = 0;
        double y = 1, z = 1;

        if (parts.length > i && (parts[i].equals(".") || parts[i + 1].equals("."))){  // Check if it's a decimal number

            if (!parts[i].equals("."))
                v = assign(parts[i++]);
            i++;

            // Check for decimal places
            try {
                if (parts.length > i && (
                        parts.length == i + 1 ||
                                parts[i + 1].equals("(") && parts[i + 3].equals(")") ||
                                parts[i + 1].equals("'") && parts[i + 3].equals("'"))
                        ){
                    w = assign(parts[i]);
                    y = Math.pow(10, parts[i].length());
                    i++;
                }

                // Check for repeating places
                if (parts.length > i && (
                        parts[i].equals("(") && parts[i + 2].equals(")") ||
                                parts[i].equals("'") && parts[i + 2].equals("'")
                )){
                    x = assign(parts[i + 1]);
                    z = Math.pow(10, parts[i + 1].length()) - 1;
                    i += 3;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                throw new IllegalArgumentException("Wrong input string (" + expression + ")");
            }

        } else if (parts.length > i + 1 && (parts[i + 1].equals("/") || parts[i + 1].equals(":"))){  // Check for a simple fraction "123/456" or "123:456"
            w = assign(parts[i]);
            y = assign(parts[i + 2], 1);
            i += 3;
        } else if (parts.length > i + 3 && (parts[i + 1].equals(" ") && parts[i + 3].equals("/"))){  // Check for a complex fraction "123 1/2"
            v = assign(parts[i]);
            w = assign(parts[i + 2]);
            y = assign(parts[i + 4], 1);
            i += 5;
        }

        if (parts.length <= i){  // Check for more tokens on the stack
            this.d = (long) (y * z);
            this.n = (long) (x + d * v + z * w);
            if (this.n < 0)
                this.n = -this.n;
            if (this.d < 0)
                this.d = -this.d;
        } else {
            throw new IllegalArgumentException("Wrong input string (" + expression + ")");
        }
        return new Number[]{this.n, this.d, this.s};
    }

    public Number[] parse(String[] expression){
        switch (expression.length){
            case 1:
                return parse(expression[0]);
            case 2:
                return parse(expression[0], expression[1]);
            case 3:{
                Number[] fraction = parse(expression[0], expression[1]);
                fraction[2] = parse(expression[2])[2];
                return fraction;
            }
            default:
                throw new IllegalArgumentException(Arrays.toString(expression) + " argument is illegal");
        }
    }

    public Number[] parse(String nominator, String denominator){
        Number[] n = parse(nominator);
        Number[] d = parse(denominator);

        this.n = n[0].longValue() * d[1].longValue();
        this.d = n[1].longValue() * d[0].longValue();
        this.s = n[2].intValue() * d[2].intValue();

        return new Number[]{this.n, this.d, this.s};
    }

    // region Helpers

    private String[] separate(String expression){
        List<String> list = new ArrayList<>();
        int last = 0;

        expression = expression.trim();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '+'  ||
                    chars[i] == '-'  ||
                    chars[i] == ' '  ||
                    chars[i] == '('  ||
                    chars[i] == ')'  ||
                    chars[i] == '/'  ||
                    chars[i] == '\'' ||
                    chars[i] == '.'  ||
                    chars[i] == ':'
                    ){
                if (i - last > 0)
                    list.add(expression.substring(last, i));
                list.add(String.valueOf(chars[i]));
                last = i + 1;
            }
        }

        if (last != expression.length())
            list.add(expression.substring(last, expression.length()));
        String[] result = new String[0];
        return list.toArray(result);
    }

    private long assign(String a){
        return assign(a, this.s);
    }

    private long assign(String a, int s){
        try {
            return Long.parseLong(a) * s;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Wrong input string or string include overflow values");
        }
    }

    // endregion

    // endregion

    // region Number parse region

    /**
     * Used this method for getting numerator and denominator from decimal fraction
     *
     * Using Farey Sequences
     * https://www.johndcook.com/blog/2010/10/20/best-rational-approximation/
     *
     * @param number - Number value for approximation
     * @return Number array of [nominator, denominator, sign]
     */
    public Number[] parse(Double number){
        if (number < 0){
            this.s = -1;
            number = -number;
        } else
            this.s = 1;

        if (number % 1 == 0){
            this.n = number.longValue();
            this.d = 1L;
        } else if (number > 0) {
            double z = 1;
            if (number >= 1) {
                z = Math.pow(10, Math.floor(1 + Math.log(number) / Math.log10(10)));
                number /= z;
            }

            final int N = 10000000;
            int a = 0, b = 1;
            int c = 1, d = 1;

            while (b <= N && d <= N) {
                final double m = (double) (a + c) / (b + d);

                if (number == m) {
                    if (b + d <= N) {
                        this.n = a + c;
                        this.d = b + d;
                    } else if (d > b) {
                        this.n = c;
                        this.d = d;
                    } else {
                        this.n = a;
                        this.d = b;
                    }
                    break;
                } else {
                    if (number > m) {
                        a += c;
                        b += d;
                    } else {
                        c += a;
                        d += b;
                    }

                    if (b > N) {
                        this.n = c;
                        this.d = d;
                    } else {
                        this.n = a;
                        this.d = b;
                    }

                }
            }
            this.n *= z;
        }
        return new Number[]{this.n, this.d, this.s};
    }

    public Number[] parse(Number number){  // Only int, long, short, byte values
        if (number.getClass() == Double.class || number.getClass() == Float.class)  // If double or float
            return parse(number.doubleValue());
        this.n = number.longValue();
        this.d = 1L;
        this.s = this.n < 0 ? -1: 1;
        if (this.n < 0)
            this.n = -this.n;
        return new Number[]{this.n, this.d, this.s};
    }

    public Number[] parse(Double nominator, Double denominator){
        Number[] n = parse(nominator);
        Number[] d = parse(denominator);

        this.n = n[0].longValue() * d[1].longValue();
        this.d = n[1].longValue() * d[0].longValue();
        this.s = n[2].intValue() * d[2].intValue();

        return new Number[]{this.n, this.d, this.s};
    }

    public Number[] parse(Number nominator, Number denominator){  // Only int, long, short, byte values
        if (nominator.getClass() == Double.class || nominator.getClass() == Float.class ||  // If double or
                denominator.getClass() == Double.class || denominator.getClass() == Float.class)  // Float
            return parse(nominator.doubleValue(), denominator.doubleValue());
        this.n = nominator.longValue();
        this.d = denominator.longValue();
        this.s = 1;
        if (this.n < 0){
            this.s = -this.s;
            this.n = -this.n;
        }
        if (this.d < 0){
            this.s = -this.s;
            this.d = -this.d;
        }
        return new Number[]{this.n, this.d, this.s};
    }

    public Number[] parse(Number[] fraction){
        if (fraction.length == 1)
            return parse(fraction[0]);
        if (fraction.length == 2)
            return parse(fraction[0], fraction[1]);
        if (fraction.length == 3){
            Number[] f = parse(fraction[0], fraction[1]);
            f[2] = f[2].intValue() * fraction[2].intValue();
            return f;
        }
        throw new IllegalArgumentException("Wrong input string (" + Arrays.toString(fraction) + ")");
    }

    public Number[] parse(byte[] fraction){
        long[] array = new long[fraction.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = fraction[i];
        }
        return parse(array);
    }

    public Number[] parse(short[] fraction){
        long[] array = new long[fraction.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = fraction[i];
        }
        return parse(array);
    }

    public Number[] parse(int[] fraction){
        long[] array = new long[fraction.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = fraction[i];
        }
        return parse(array);
    }

    public Number[] parse(double[] fraction){
        Number[] array = new Number[fraction.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = fraction[i];
        }
        return parse(array);
    }

    public Number[] parse(float[] fraction){
        Number[] array = new Number[fraction.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = fraction[i];
        }
        return parse(array);
    }

    public Number[] parse(long[] fraction){
        if (fraction.length == 3)
            return new Number[] {fraction[0], fraction[1], fraction[2]};
        if (fraction.length == 1)
            return parse(fraction[0]);
        if (fraction.length == 2)
            return parse(fraction[0], fraction[1]);
        throw new IllegalArgumentException("Wrong input string (" + Arrays.toString(fraction) + ")");
    }

    // endregion

}


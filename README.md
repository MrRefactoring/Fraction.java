[![Build Status](https://travis-ci.org/MrRefactoring/Fraction.java.svg?branch=master)](https://travis-ci.org/MrRefactoring/Fraction.java)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](http://opensource.org/licenses/MIT)
# Fraction.java - ℚ in Java

Fraction is a rational number library written in Java


Tired of imprecise numbers represented by doubles, which have to store rational and irrational numbers like PI or sqrt(2) the same way? Obviously the following problem is preventable:

```java
1 / 98 * 98 // = 0.9999999999999999
```

If you need more precision or just want a fraction as a result, have a look at *Fraction.js*:

```java
new Fraction(1).div(98).mul(98) // = 1
```

Internally, numbers are represented as *numerator / denominator*, which adds just a little overhead. However, the library is written with performance in mind and outperforms any other implementation.

Convert decimal to fraction
===
The simplest job for fraction.js is to get a fraction out of a decimal:
```java
Fraction x = new Fraction(1.88);
Fraction res = x.toFraction(true); // String "1 22/25"
```

Examples / Motivation
===
A simple example might be

```java
Fraction f = new Fraction("9.4'31'"); // 9.4313131313131...
f.mul(new int[]{-4, 3}).mod("4.'8'"); // 4.88888888888888...
```
The result is

```java
System.out.println(f.toFraction()); // -4154 / 1485
```
You could of course also access the sign (s), numerator (n) and denominator (d) on your own:
```java
f.s * f.n / f.d = -1 * 4154 / 1485 = -2.797306...
```

If you would try to calculate it yourself, you would come up with something like:

```java
(9.4313131 * (-4 / 3)) % 4.888888 = -2.797308133...
```

Quite okay, but yea - not as accurate as it could be.


Laplace Probability
===
Simple example. What's the probability of throwing a 3, and 1 or 4, and 2 or 4 or 6 with a fair dice?

P({3}):
```java
Fraction p = new Fraction(new int[]{3}.length, 6).toString(); // 0.1(6)
```

P({1, 4}):
```java
Fraction p = new Fraction(new int[]{1, 4}.length, 6).toString(); // 0.(3)
```

P({2, 4, 6}):
```java
Fraction p = new Fraction(new int[]{2, 4, 6}.length, 6).toString(); // 0.5
```

Convert degrees/minutes/seconds to precise rational representation:
===

57+45/60+17/3600
```java
int deg = 57; // 57°
int min = 45; // 45 Minutes
int sec = 17; // 17 Seconds

new Fraction(deg).add(min, 60).add(sec, 3600).toString() // -> 57.7547(2)
```
            
Rational approximation of irrational numbers
===

Now it's getting messy ;d To approximate a number like *sqrt(5) - 2* with a numerator and denominator, you can reformat the equation as follows: *pow(n / d + 2, 2) = 5*.

Then the following algorithm will generate the rational number besides the binary representation.

```java
String x = "/";
String s = "";
Fraction a = new Fraction(0);
Fraction b = new Fraction(1);
for (int n = 0; n <= 10; n++) {

    Fraction c = new Fraction(a).add(b).div(2);

    System.out.println(n + "\t" + a.toFraction() + "\t" + b.toFraction() + "\t" + c.toFraction() + "\t" + x);

    if (c.add(2).pow(2).compareTo(5) < 0) {
        a = c;
        x = "1";
    } else {
        b = c;
        x = "0";
    }
    s += x;
}
System.out.println(s);
```

The result is

```
n   a[n]        b[n]        c[n]            x[n]
0   0/1         1/1         1/2             /
1   0/1         1/2         1/4             0
2   0/1         1/4         1/8             0
3   1/8         1/4         3/16            1
4   3/16        1/4         7/32            1
5   7/32        1/4         15/64           1
6   15/64       1/4         31/128          1
7   15/64       31/128      61/256          0
8   15/64       61/256      121/512         0
9   15/64       121/512     241/1024        0
10  241/1024    121/512     483/2048        1
```
Thus the approximation after 11 iterations of the bisection method is *483 / 2048* and the binary representation is 0.00111100011 (see [WolframAlpha](http://www.wolframalpha.com/input/?i=sqrt%285%29-2+binary))


Get the exact fractional part of a number
---
```java
Fraction f = new Fraction("-6.(3416)");
System.out.println(f.mod(1).abs().toString()); // Will print 0.(3416)
```

Mathematical correct modulo
---
The behaviour on negative congruences is different to most modulo implementations in computer science. Even the *mod()* function of Fraction.js behaves in the typical way. To solve the problem of having the mathematical correct modulo with Fraction.js you could come up with this:

```java
int a = -1;
double b = 10.99;

System.out.println(new Fraction(a)
  .mod(b).toString()); // Not correct, usual Modulo

System.out.println(new Fraction(a)
  .mod(b).add(b).mod(b).toString()); // Correct! Mathematical Modulo
```

fmod() impreciseness circumvented
---
It turns out that Fraction.java outperforms almost any fmod() implementation, including Java itself, [php.js](http://phpjs.org/functions/fmod/), C++, Python, JavaScript and even Wolframalpha due to the fact that numbers like 0.05, 0.1, ... are infinite decimal in base 2.

The equation *fmod(4.55, 0.05)* gives *0.04999999999999957*, wolframalpha says *1/20*. The correct answer should be **zero**, as 0.05 divides 4.55 without any remainder.


Parser
===

Any function (see below) as well as the constructor of the *Fraction* class parses its input and reduce it to the smallest term.

You can pass either Arrays, Bytes, Shorts, Integers, Longs, Floats, Doubles or Strings.

Arrays
---
```java
new Fraction(numerator, denominator);
new Fraction(new Number[]{numerator, denominator});
new Fraction(new byte[]{numerator, denominator});
new Fraction(new short[]{numerator, denominator});
new Fraction(new int[]{numerator, denominator});
new Fraction(new long[]{numerator, denominator});
new Fraction(new float[]{numerator, denominator});
new Fraction(new double[]{numerator, denominator});
```

Integers
---
```java
new Fraction(123);
```

Doubles
---
```java
new Fraction(55.4);
```

Strings
---
```java
new Fraction("123.45");
new Fraction("123/45"); // A rational number represented as two decimals, separated by a slash
new Fraction("123:45"); // A rational number represented as two decimals, separated by a colon
new Fraction("4 123/45"); // A rational number represented as a whole number and a fraction
new Fraction("123.'456'"); // Note the quotes, see below!
new Fraction("123.(456)"); // Note the brackets, see below!
new Fraction("123.45'6'"); // Note the quotes, see below!
new Fraction("123.45(6)"); // Note the brackets, see below!
```

Two arguments
---
```java
new Fraction(3, 2); // 3/2 = 1.5
```

Attributes
===

The Fraction object allows direct access to the numerator, denominator and sign attributes. It is ensured that only the sign-attribute holds sign information so that a sign comparision is only necessary against this attribute.

```java
Fraction f = new Fraction("-1/2");
System.out.println(f.n); // Numerator: 1
System.out.println(f.d); // Denominator: 2
System.out.println(f.s); // Sign: -1
```

Functions
===

Fraction abs()
---
Returns the actual number without any sign information

Fraction neg()
---
Returns the actual number with flipped sign in order to get the additive inverse

Fraction add(n)
---
Returns the sum of the actual number and the parameter n

Fraction sub(n)
---
Returns the difference of the actual number and the parameter n

Fraction mul(n)
---
Returns the product of the actual number and the parameter n

Fraction div(n)
---
Returns the quotient of the actual number and the parameter n

Fraction pow(exp)
---
Returns the power of the actual number, raised to an integer exponent.
*Note:* Rational exponents are planned, but would slow down the function a lot, because of a kinda slow root finding algorithm, whether the result will become irrational. So for now, only integer exponents are implemented.

Fraction mod(n)
---
Returns the modulus (rest of the division) of the actual object and n (this % n). It's a much more precise [fmod()](#fmod-impreciseness-circumvented) if you will. Please note that *mod()* is just like the modulo operator of most programming languages. If you want a mathematical correct modulo, see [here](#mathematical-correct-modulo).

Fraction mod()
---
Returns the modulus (rest of the division) of the actual object (numerator mod denominator)

Fraction gcd(n)
---
Returns the fractional greatest common divisor

Fraction lcm(n)
---
Returns the fractional least common multiple

Fraction ceil([places=0])
---
Returns the ceiling of a rational number (rounded up)

Fraction floor([places=0])
---
Returns the floor of a rational number (rounded down)

Fraction round([places=0])
---
Returns the rational number rounded (normal round)

Fraction inverse()
---
Returns the multiplicative inverse of the actual number (n / d becomes d / n) in order to get the reciprocal

Fraction simplify([eps=0.001])
---
Simplifies the rational number under a certain error threshold. Ex. `0.333` will be `1/3` with `eps=0.001`

boolean equals(n)
---
Check if two numbers are equal

int compareTo(n)
---
Compare two numbers.
```
result < 0: n is greater than actual number
result > 0: n is smaller than actual number
result = 0: n is equal to the actual number
```

boolean divisible(n)
---
Check if two numbers are divisible (n divides this)

double valueOf()
---
Returns a decimal representation of the fraction

double toNumber()
---
Returns a decimal representation of the fraction (Equivalent `valueOf()`)

String toString()
---
Generates an exact string representation of the actual object, including repeating decimal places of any length.

String toLatex(excludeWhole=false)
---
Generates an exact LaTeX representation of the actual object.

The optional boolean parameter indicates if you want to exclude the whole part. "1 1/3" instead of "4/3"

String toFraction(excludeWhole=false)
---
Gets a string representation of the fraction

The optional boolean parameter indicates if you want to exclude the whole part. "1 1/3" instead of "4/3"

long[] toContinued()
---
Gets an array of the fraction represented as a continued fraction. The first element always contains the whole part.

```java
Fraction f = new Fraction("88/33");
long[] c = f.toContinued(); // [2, 1, 2]
```

long[] toArray()
---
Get an array of fraction. [nominator, denominator, sign]

```java
Fraction f = new Fraction(1, 2);
long[] c = f.toArray();  // [1, 2, 1]
```

Fraction clone()
---
Creates a copy of the actual Fraction object

Options
===

The library should work without configuring anything. However, there is one global option:

```java
Fraction.REDUCE = <true|false>
```

It tells Fraction.java whether to reduce the fraction or not. 

```java
// Normal behavior
Fraction f = new Fraction(3, 6);
System.out.println(f.toFraction()); // 1/2

// Disable fraction reduction
Fraction.REDUCE = false;
Fraction g = new Fraction(3, 6);
System.out.println(g.toFraction()); // 3/6

// Back to normal behavior
Fraction.REDUCE = true;
Fraction h = new Fraction(g);
System.out.println(h.toFraction()); // 1/2
```

Exceptions
===
If a really hard error occurs (parsing error, division by zero), *Fraction.java* throws exceptions! Please make sure you handle them correctly.


Installation
===
Installing Fraction.java is as easy as cloning this repo or download lib from `builds` folder


Precision
===
Fraction.java tries to circumvent floating point errors, by having an internal representation of numerator and denominator. As it relies on Java, there is also a limit. The biggest number representable is `|Long.MAX_VALUE / 1|` and the smallest is `|1 / Long.MAX_VALUE|`, with `Long.MAX_VALUE=9007199254740991`.

Testing
===
If you plan to enhance the library, make sure you add test cases and all the previous tests are passing. You can test the library with

```
gradle check
```


Copyright and licensing
===
Copyright (c) 2018, [Tupikin Vladislav](https://MrRefactoring.githib.io/)
Dual licensed under the MIT or GPL Version 2 licenses.

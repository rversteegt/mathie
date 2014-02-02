# Mathie
## Description
Mathie is a mathematical expression framework. It creates expression graphs (http://gerritdrost.com/2013/09/mathematical-expression-graphs) and provides an easy way to interface with them. With Mathie you can set up a framework of expressions sharing variables and quickly recalculate their values while the variables change.
## Little boiler-plate!
Using annotations and some injection code, Mathie makes it possible to use expressions in a class without writing lots of boilerplate code.
## Quick
Mathie's focus is quick (re-)evaluation, not fast parsing(although that's still pretty quick as well).
## Extendable
Need a function or operator not implemented? You can easily extend Mathie to do so!
# Examples
## Bare java
```java
public class MathieTest {

	public MathieTest() {
		ExpressionEnvironment t = new ExpressionEnvironment();

		Expression e = t.getExpression("2*x");

		// when variables are initialized, they are set to 1.0
		System.out.println(e);

		// let's get that variable object
		Variable x = t.getVariable("x");
		x.set(5.0);

		// Re-evaluation is done automagically
		System.out.println(e);
	}
}
```
## Using annotations
```java
public class MathieTest implements Injectable {

	@Env
	private ExpressionEnvironment env;

	@Expr("16/x")
	private Expression exp1;

	@Var(name = "x", val = 2.0)
	private Variable x;

	public MathieTest() {
		// you could even integrate this little chunk of code into a superclass, but then you can't extend any other
		// classes.
		Injector.inject(this);
	}

	@Override
	public void injectionDone() {
		// x = 2 since we set it to be that, so 16/2 = 8.
		System.out.println(exp1);
		x.set(8.0);
		// 16.0/8.0 obviously is 2.0
		System.out.println(exp1);
	}
}
```

# License
Mathie uses the MIT license. More info: 
* [the LICENSE-file](LICENSE)
* [tldrlegal.com](http://www.tldrlegal.com/license/mit-license)
* [opensource.org](http://www.opensource.org/licenses/mit-license.php)

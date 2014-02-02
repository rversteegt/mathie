package gerritdrost.com.apps.mathie.defaults.operator;

import static org.junit.Assert.assertEquals;
import gerritdrost.com.apps.mathie.ExpressionEnvironment;
import gerritdrost.com.apps.mathie.config.Configuration;
import gerritdrost.com.apps.mathie.operator.Operator;
import gerritdrost.com.apps.mathie.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PowerOperatorTest {

	ExpressionEnvironment mathieEnv;

	@Before
	public void setup() {
		mathieEnv = new ExpressionEnvironment(new Configuration() {

			@Override
			public Collection<Operator> getOrderedOperators() {
				return Arrays.asList(new Operator[] { new PowerOperator(), new ValueOperator() });
			}

			@Override
			public Collection<Pair<String, Double>> getDefaultVariables() {
				return new ArrayList<Pair<String, Double>>();
			}

		});
	}

	@Test
	public void checkDefault() {
		assertEquals(mathieEnv.getExpression("3^4")
								.getValue(), 81.0, 0.0);
	}

	@Test
	public void checkNested() {
		assertEquals(mathieEnv.getExpression("(3^2)^2")
								.getValue(), 81.0, 0.0);
	}

	/**
	 * Something to the power of 0 should be 1.
	 */
	@Test
	public void checkToZero() {
		assertEquals(mathieEnv.getExpression("10^0")
								.getValue(), 1.0, 0.0);

	}

	/**
	 * Checks for the right operator associativity (pun intended). When the operator associativity is right, the result
	 * will be 512. When it is left (thus wrong), the result is 64.
	 */
	@Test
	public void checkAssociativity() {
		assertEquals(mathieEnv.getExpression("2^3^2")
								.getValue(), 512.0, 0.0);
	}

	@After
	public void tearDown() {

	}
}

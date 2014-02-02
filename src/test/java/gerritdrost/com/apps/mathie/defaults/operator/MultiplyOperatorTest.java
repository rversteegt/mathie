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
public class MultiplyOperatorTest {

	ExpressionEnvironment mathieEnv;

	@Before
	public void setup() {
		mathieEnv = new ExpressionEnvironment(new Configuration() {

			@Override
			public Collection<Operator> getOrderedOperators() {
				return Arrays.asList(new Operator[] { new MultiplyOperator(), new ValueOperator() });
			}

			@Override
			public Collection<Pair<String, Double>> getDefaultVariables() {
				return new ArrayList<Pair<String, Double>>();
			}

		});
	}

	@Test
	public void checkMultiplyOperator() {
		assertEquals(mathieEnv.getExpression("2*3")
								.getValue(), 6.0, 0.0);

		assertEquals(mathieEnv.getExpression("4*3*2")
								.getValue(), 24.0, 0.0);

		assertEquals(mathieEnv.getExpression("(6*3)*3")
								.getValue(), 54.0, 0.0);
	}

	@After
	public void tearDown() {

	}
}

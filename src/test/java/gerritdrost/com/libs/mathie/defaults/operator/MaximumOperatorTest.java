package gerritdrost.com.libs.mathie.defaults.operator;

import static org.junit.Assert.assertEquals;
import gerritdrost.com.libs.mathie.ExpressionEnvironment;
import gerritdrost.com.libs.mathie.config.Configuration;
import gerritdrost.com.libs.mathie.operator.Operator;
import gerritdrost.com.libs.mathie.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MaximumOperatorTest {

	ExpressionEnvironment mathieEnv;
	
	@Before
	public void setup() {
		mathieEnv = new ExpressionEnvironment(new Configuration() {

			@Override
			public Collection<Operator> getOrderedOperators() {
				return Arrays.asList(new Operator[] { new MaximumOperator(), new ValueOperator() });
			}

			@Override
			public Collection<Pair<String, Double>> getDefaultVariables() {
				return new ArrayList<Pair<String, Double>>();
			}

		});
	}

	@Test
	public void checkDefault() {
		assertEquals(4.0, mathieEnv.getExpression("max(4,2)")
									.getValue(), 0.0);
	}

	@Test
	public void checkNested() {
		assertEquals(8.0, mathieEnv.getExpression("max(2,max(4,8))")
									.getValue(), 0.0);
	}

	@Test
	public void checkMultipleParameters() {
		assertEquals(8.0, mathieEnv.getExpression("max(2,max(4,8),7,5,1,3)")
									.getValue(), 0.0);
	}

	@After
	public void tearDown() {

	}
}
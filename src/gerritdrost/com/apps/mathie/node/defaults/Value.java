package gerritdrost.com.apps.mathie.node.defaults;

import gerritdrost.com.apps.mathie.expression.Expression;

public class Value
		extends Expression {

	public Value(double value) {
		super(new Expression[0]);
		this.value = value;
	}

	@Override
	public void recalculate() {

	}

}

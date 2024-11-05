package rpc;

public class DefaultExpressionValue<T> implements IExpressionValue {

	private String name;
	private ExpressionType type;
	private T value;
	
	public DefaultExpressionValue(String name, ExpressionType type, T value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public ExpressionType getType() {
		return type;
	}

	@Override
	public int readAsInteger() {
		if (type.isIntegralType()) {
			return (int)value;
		}
		
		throw new RuntimeException("Expression is not an integral value");
	}

	@Override
	public String readAsString() {
		if (type.isStringType()) {
			return (String)value;
		}
		
		throw new RuntimeException("Expression is not a string value");
	}

}

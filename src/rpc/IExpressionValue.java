package rpc;

public interface IExpressionValue {

	String getName();

	ExpressionType getType();
	
	int readAsInteger();
	
	String readAsString();
	
}

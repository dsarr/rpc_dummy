package rpc;

import java.util.List;


public interface IRpcCommand {

	String getFullyQualifiedName(); //
	
	List<IExpressionValue> getArguments();
	
	ExpressionType getReturnType();
}

package rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicRpcCommand implements IRpcMessage {

	private String fullQName;
	List<IExpressionValue> arguments;
	ExpressionType returnType = ExpressionType.VOID;
	
	
	public BasicRpcCommand(String fullQName) {
		this.fullQName = Objects.requireNonNull(fullQName, "require rpc method full qualified nane");
	}
	
	//assume called in correct order
	BasicRpcCommand withArgument(IExpressionValue arg) {
		if (arguments == null) {
			arguments = new ArrayList<>();
		}
		
		arguments.add(arg);
		
		return this;
	}
	
	BasicRpcCommand withReturnType(ExpressionType type) {
		returnType = type;
		return this;
	}
	
	@Override
	public String getFullyQualifiedName() {
		return fullQName;
	}

	@Override
	public List<IExpressionValue> getArguments() {
		return arguments;
	}

	@Override
	public ExpressionType getReturnType() {
		return returnType;
	}

	/**
	 * Dummy Serialization
	 */
	@Override
	public byte[] serialize() {
		
		StringBuilder sb = new StringBuilder(fullQName);
		
		if (arguments != null) {
			for (IExpressionValue arg : arguments) {
				sb.append(arg.getName()).append(": ").append(arg.readAsString());
			}
		}
		
		return sb.toString().getBytes();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(fullQName);

		
		if (arguments != null) {
			sb.append("(");
			for (IExpressionValue arg : arguments) {
				sb.append(arg.getName()).append(": ");
				if(arg.getType().isIntegralType()) {
					sb.append(arg.readAsInteger());
				} else if(arg.getType().isStringType()) {
					sb.append(arg.readAsString());
				}
				sb.append(", ");
			}
			sb.append(")");
		}
		
		return sb.toString();
	}
}

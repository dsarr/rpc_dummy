package rpc;

import java.util.Objects;

public class DummyRpcService {
	
	private IConnection connection;
	
	public DummyRpcService(IConnection connection) {
		this.connection = Objects.requireNonNull(connection, "Remote connection can't be null");
	}
	
	String hello() {
		DummyRpcCmdListener cmdListener = new DummyRpcCmdListener();
		connection.send(new BasicRpcCommand("DummyRpcService.hello")
				.withReturnType(ExpressionType.STRING), cmdListener);
		
		String res = cmdListener.get().readAsString();
		System.out.println("ClientRPC: received Rpc command result: " + res);

		return res;
	}
	
	int add (int a, int b) {
		DummyRpcCmdListener cmdListener = new DummyRpcCmdListener();
		connection.send(new BasicRpcCommand("DummyRpcService.add")
				.withArgument(new DefaultExpressionValue<Integer>("a", ExpressionType.INT, a))
				.withArgument(new DefaultExpressionValue<Integer>("b", ExpressionType.INT, b))
				.withReturnType(ExpressionType.INT), cmdListener);
		
		int res = cmdListener.get().readAsInteger();
		System.out.println("ClientRPC: received Rpc command result: " + res);

		return res;
	}
	
}

package rpc;

public class FakeServer {
	
	public void connect() {
		System.out.println("FakeServer: ready to receive incoming requests");
	}
	
	public void disconnect() {
		System.out.println("FakeServer: client disconnected");
	}
	
	public IExpressionValue processRequest(IMessage message) {
		
		//assume that decoding the IMessage will deduce it is an RPC call
		IRpcMessage rpcMessage = (IRpcMessage)message;
		
		switch (rpcMessage.getFullyQualifiedName()) {
		case "DummyRpcService.hello":
			return hello(rpcMessage);
		case "DummyRpcService.add":
			return add(rpcMessage);
		default:
			//dummy failure handling
			return new DefaultExpressionValue<Integer>("Rpc_failed", ExpressionType.VOID, -1);
		}
	}
	
	public IExpressionValue hello(IRpcCommand cmd) {
		System.out.println("FakeServer processing Rpc command: " + cmd);
		String res = hello();
		System.out.println("FakeServer Rpc result: " + res);

		return new DefaultExpressionValue<String>("hello_returnVal", ExpressionType.STRING, res);
	}
	
	public IExpressionValue add(IRpcCommand cmd /*int a, int b*/) {
		System.out.println("FakeServer processing Rpc command: " + cmd);
		
		int a = cmd.getArguments().get(0).readAsInteger();
		int b = cmd.getArguments().get(1).readAsInteger();
		int res = add(a, b);
		System.out.println("FakeServer Rpc result: " + res);
		
		return new DefaultExpressionValue<Integer>("add_returnVal", ExpressionType.INT, res);
	}
	
	String hello() {
		return "Greetings!";
	}
	
	int add(int a, int b) {
		return a + b;
	}
	
}


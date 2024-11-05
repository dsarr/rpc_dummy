package rpc;

public class RpcTest {

	
	public static void main(String args[]) {
		
		FakeServer server = new FakeServer();
		server.connect();
		
		IConnection httpRequestor = new HttpRequestor(server);
		
		DummyRpcService rcpService = new DummyRpcService(httpRequestor);
		
		
		String greeting = rcpService.hello();
		int addRes1   = rcpService.add(1, 2);
		//int addRes2   = rcpService.add(3, 4);
		//int addRes3   = rcpService.add(2, 11);
		
	}
}

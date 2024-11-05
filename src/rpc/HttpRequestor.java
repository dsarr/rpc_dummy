package rpc;

import java.util.Objects;

public class HttpRequestor implements IConnection, IHttpRequestor {

	FakeServer server;
	
	public HttpRequestor(FakeServer server) {
		this.server = Objects.requireNonNull(server, "requires a non null server");
	}

	@Override
	public void connect() {
		System.out.println("Connecting to remote server");
	}

	@Override
	public void disconnect() {
		System.out.println("Disonnecting from remote server");
	}
	
	@Override
	public void post(String message) {
		send(new DummyHttpMessage(message), new DummyRpcCmdListener());
	}

	@Override
	public String get(String message) {
		var listener = new DummyRpcCmdListener();
		send(new DummyHttpMessage(message), listener);
		return listener.get().readAsString();
	}

	@Override
	public void post(IMessage message) {
		// TODO should encode IMessage to Http format
		send(message, new DummyRpcCmdListener());
	}

	@Override
	public String get(IMessage message) {
		// TODO should encode IMessage to Http format
		return null;
	}

	@Override
	public void send(IMessage message, ICmdListener listener) {
		System.out.println("ClientRPC: sending HttpRpc command: " + message);
		// TODO should encode IMessage to Http format
		IExpressionValue retVal = server.processRequest(message);
		
		if (listener != null) {
			listener.onSuccess(retVal);
		}		
	}
	
	
	private class DummyHttpMessage implements IMessage {

		private String message;
		
		public DummyHttpMessage(String message) {
			this.message =  message;
		}
		
		@Override
		public byte[] serialize() {
			return message.getBytes();
		}
	}
	
}

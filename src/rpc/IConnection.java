package rpc;

public interface IConnection {
	
	void connect(/*connection settings*/);
	
	void disconnect();
	
	//boolean isConnected();
	
	void send(IMessage message, ICmdListener listener);
}

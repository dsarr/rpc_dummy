package rpc;

public interface IHttpRequestor {
	
	void post(String message);
	
	void post(IMessage message);
		
	String get(String message);
	
	String get(IMessage message);

}

package rpc;

public interface ICmdListener {
	
	void onFailure(String errMessage);
	
	void onSuccess(IExpressionValue cmdReturnValue);
	
	IExpressionValue get();
}
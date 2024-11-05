package rpc;


public class DummyRpcCmdListener implements ICmdListener {

	//private IRpcCommand cmd;
	private IExpressionValue cmdReturnValue;
	

	@Override
	public void onFailure(String errMessage) {
		System.out.println("Rpc Cmd failed");
	}

	@Override
	public void onSuccess(IExpressionValue cmdReturnValue) {
		this.cmdReturnValue = cmdReturnValue;
		//notify data are ready
	}

	@Override
	public IExpressionValue get() {
		//block until data ready
		return cmdReturnValue;
	}
	
}

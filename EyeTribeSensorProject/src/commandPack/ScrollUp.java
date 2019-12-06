package commandPack;

public class ScrollUp extends CommandAttribute{
	
	private int pixelCount ;

	public ScrollUp(int pixelCount) {
		super();
		this.pixelCount = pixelCount;
	}

	public int getPixelCount() {
		return pixelCount;
	}

	public void setPixelCount(int pixelCount) {
		this.pixelCount = pixelCount;
	}

	@Override
	String getCommandAttributeAsString() {
		// TODO Auto-generated method stub
		return null;
	}

}

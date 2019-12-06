package commandPack;

public class ScrollDown extends CommandAttribute {

	private int pixelCount ;
	
	public int getPixelCount() {
		return pixelCount;
	}

	public void setPixelCount(int pixelCount) {
		this.pixelCount = pixelCount;
	}

	public ScrollDown(int pixelCount) {
		super();
		this.pixelCount = pixelCount;
	}

	@Override
	String getCommandAttributeAsString() {
		// TODO Auto-generated method stub
		return null;
	}

}

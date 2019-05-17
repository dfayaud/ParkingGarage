package model;

public class Lot {

	private int length;
	private int width;

	public Lot(int length, int width) {
		super();
		this.length = length;
		this.width = width;
		determineSizeCategory(width);
	}

	private void determineSizeCategory(int width) {
		
		
		int lotSize = 0;
		
		if(width >= 42 && width < 52) {
			lotSize += 1;
		}
		if(width >= 52 && width < 84) {
			lotSize += 2;
		}
		if(width >= 84 && width < 94) {
			lotSize += 3;
		}
		if(width >=94 && width < 136) {
			lotSize += 4;
			
		}
		
		}
	
	
}

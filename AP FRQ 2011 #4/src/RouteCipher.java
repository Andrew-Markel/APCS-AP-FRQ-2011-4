
public class RouteCipher {

	private String[][] letterBlock;
	private int numRows;
	private int numCols;
	
	private void fillBlock(String str) {
		letterBlock = new String[numRows][numCols];
		int count = 0;
		for (int r = 0; r < numRows; r++) {
			for(int c = 0; c < numCols; c++) {
				letterBlock[r][c] = str.length() <= count ? "A" : str.substring(count,count+1);
				count ++;
			}
		}
	}
	
	private String encryptBlock() {
		String str = "";
		for (int c = 0; c < numCols; c ++) {
			for (int r = 0; r < numRows; r ++) {
				str += letterBlock[r][c];
			}
		}
		return str;
	}
	
	public String encryptMessage(String message) {
		String str = "";
		
		//
		numRows = 2;
		numCols = 3;
		
		while (message.length() > 0) {
			if(message.length() >= numRows * numCols) {
				fillBlock(message.substring(0, numRows * numCols));
				message = message.substring(numCols * numCols-1);
			}
			else {
				fillBlock(message);
				message = "";
			}
			str += encryptBlock();
		}
		
		return str;
	}
}

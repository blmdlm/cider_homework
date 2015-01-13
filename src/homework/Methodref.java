package homework;
/**
 * Methodref info
 * @author JG91901
 *
 */
public class Methodref {
	private String lineNum;
	private String nameAndTpyeIndex;
	
	
	@Override
	public String toString() {
		return "Methodref [lineNum=" + lineNum + ", nameAndTpyeIndex="
				+ nameAndTpyeIndex + "]";
	}
	public Methodref(String lineNum, String nameAndTpyeIndex) {
		super();
		this.lineNum = lineNum;
		this.nameAndTpyeIndex = nameAndTpyeIndex;
	}
	public String getLineNum() {
		return lineNum;
	}
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	public String getNameAndTpyeIndex() {
		return nameAndTpyeIndex;
	}
	public void setNameAndTpyeIndex(String nameAndTpyeIndex) {
		this.nameAndTpyeIndex = nameAndTpyeIndex;
	}
	
	
}

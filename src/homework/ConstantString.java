package homework;
/**
 * basic CONSTANT_Utf8
 * @author JG91901
 *
 */
public class ConstantString {
	private String lineNum;
	private String name;
	
	public ConstantString(String lineNum, String name) {
		super();
		this.lineNum = lineNum;
		this.name = name;
	}
	@Override
	public String toString() {
		return "ConstantString [lineNum=" + lineNum + ", name=" + name + "]";
	}
	public String getLineNum() {
		return lineNum;
	}
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

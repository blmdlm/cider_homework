package homework;
/**
 * NameAndType_info 
 * @author JG91901
 *
 */
public class NameAndType {
	private String lineNum;
	private String nameIndex;
	private String typeIndex;
	
	public NameAndType(){
		
	}
	@Override
	public String toString() {
		return "NameAndType [lineNum=" + lineNum + ", nameIndex=" + nameIndex
				+ ", typeIndex=" + typeIndex + "]";
	}
	public NameAndType(String lineNum, String nameIndex, String typeIndex) {
		super();
		this.lineNum = lineNum;
		this.nameIndex = nameIndex;
		this.typeIndex = typeIndex;
	}
	public String getLineNum() {
		return lineNum;
	}
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	public String getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(String nameIndex) {
		this.nameIndex = nameIndex;
	}
	public String getTypeIndex() {
		return typeIndex;
	}
	public void setTypeIndex(String typeIndex) {
		this.typeIndex = typeIndex;
	}
	
	
}

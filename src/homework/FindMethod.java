package homework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.tools.classfile.ClassFile;
import com.sun.tools.classfile.ConstantPool;
import com.sun.tools.classfile.ConstantPool.CPInfo;
import com.sun.tools.classfile.ConstantPoolException;

/**
 * search a method in a class file
 * 
 * @author JG91901
 *
 */

public class FindMethod {
	public static void main(String[] args) throws IOException,
			ConstantPoolException {

		// capture user's input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the method: ");
		String input = scanner.nextLine();
		//

		//
		ClassFile cf = ClassFile.read(new File(
				"G:\\homework\\java\\homework\\bin\\homework\\Boy.class"));
		searchMethodInClass(cf, input);

	}

	public static void searchMethodInClass(ClassFile cf, String input) {
		List<ConstantString> csList = new ArrayList<>();
		List<NameAndType> natList = new ArrayList<>();
		List<Methodref> meList = new ArrayList<>();
		ConstantPool constant_pool = cf.constant_pool;
		// int size = constant_pool.size();
		int i = 0;
		String temp;
		int start;
		int end;
		Iterable<CPInfo> entries = constant_pool.entries();
		for (CPInfo cpInfo : entries) {

			i++;
			temp = cpInfo.toString();
			if (cpInfo.getTag() == 1) {// CONSTANT_Utf8_info

				if (!temp.contains("\"")) {
					continue;
				}
				start = temp.indexOf('"');
				end = temp.lastIndexOf('"');
				csList.add(new ConstantString(i + "", temp.substring(start + 1,
						end)));
			} else if (cpInfo.getTag() == 12) { // CONSTANT_NameAndType_info
				NameAndType nat = new NameAndType();
				nat.setLineNum(i + "");

				start = temp.indexOf(':');
				end = temp.indexOf(',');
				nat.setNameIndex(temp.substring(start + 2, end));
				start = temp.lastIndexOf(":");
				end = temp.lastIndexOf("]");
				nat.setTypeIndex(temp.substring(start + 2, end));
				natList.add(nat);
			} else if (cpInfo.getTag() == 10) { // CONSTANT_Methodref_info
				start = temp.lastIndexOf(":");
				end = temp.lastIndexOf("]");
				// System.out.println(temp.substring(start+2, end));
				meList.add(new Methodref(i + "", temp.substring(start + 2, end)));
			}

		}
		// judge the method is invoked or not
		if (inCS(input, csList, natList, meList)) {
			System.out.println(input + " is invoked");
		} else {
			System.out.println(input + " is not invoked");
		}
	}

	/**
	 * judge the input name of method is invoked or not
	 * 
	 * @param input
	 * @param cs
	 * @return
	 */
	public static boolean inCS(String input, List<ConstantString> cs,
			List<NameAndType> nat, List<Methodref> me) {
		int count = cs.size();
		for (int i = 0; i < count; i++) {
			if (cs.get(i).getName().equals(input)) {
				String csNum = cs.get(i).getLineNum();
				return inNAT(csNum, nat, me);
			}
		}
		return false;

	}

	/**
	 * judge csNum is invoked or not
	 * 
	 * @param csNum
	 * @param nat
	 * @return
	 */
	public static boolean inNAT(String csNum, List<NameAndType> nat,
			List<Methodref> me) {
		int count = nat.size();
		for (int i = 0; i < count; i++) {
			if (nat.get(i).getNameIndex().equals(csNum)) {
				String natNum = nat.get(i).getLineNum();
				return inMe(natNum, me);
			}
		}

		return false;

	}

	/**
	 * judge natNum is invoked or not
	 * 
	 * @param natNum
	 * @param me
	 * @return
	 */
	public static boolean inMe(String natNum, List<Methodref> me) {
		int count = me.size();

		for (int i = 0; i < count; i++) {
			if (me.get(i).getNameAndTpyeIndex().equals(natNum)) {
				return true;
			}
		}
		return false;

	}

}

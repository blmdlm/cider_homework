package homework;

import java.io.File;

import com.sun.tools.classfile.ClassFile;
import com.sun.tools.classfile.ConstantPoolException;
public class FindMethod {
	public static void main(String[] args) {
		
		ClassFile cf=ClassFile.read(new File("G:\\homework\\java\\homework\\bin\\homework\\Boy.class"));
		System.out.println(cf.constant_pool.get(1).toString());
		
		
	}
}

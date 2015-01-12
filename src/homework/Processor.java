package homework;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * 
 * set PATH=E:\jdk\bin javac -classpath G:\homework\java\homework\bin -processor
 * homework.Processor Boy.java
 * 
 * @author blmdlm
 *
 */

@SupportedAnnotationTypes(value = "*")
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {
	public static final String ANNOTATION_TYPE = "eventbus.EventListener";

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Set<? extends Element> roots = roundEnv.getRootElements();

		for (Element element : roots) {
			System.out.println(element.getKind() + " "
					+ element.getSimpleName() + " " + element.getModifiers());
			List<? extends Element> list = element.getEnclosedElements();

			for (Element element2 : list) {
				System.out.println();
				System.out.print("种类 " + element2.getKind());
				System.out.print("\t");
				System.out.print("修饰符 " + element2.getModifiers());
				System.out.print("\t");
				System.out.print("名称 " + element2.getSimpleName());
				System.out.print("\t");
				if (!element2.getKind().toString().equals("FIELD")) {

					System.out.print("(参数列表...)返回值 " + element2.asType());

				} else {

					System.out.print("类型 " + element2.asType());
				}

			}
		}

		return false;
	}

}

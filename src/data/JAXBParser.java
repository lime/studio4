package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.*;

import model.CourseHierarchyNode;
import model.StudyProgram;

public class JAXBParser {
	private static final Class<? extends CourseHierarchyNode> ROOT_CLASS = StudyProgram.class;

	public static CourseHierarchyNode getCourseHierarchy(String filename) {

		CourseHierarchyNode root;

		try {
			// setup object mapper using the CourseHierarchy class
			JAXBContext context = JAXBContext
					.newInstance(JAXBParser.ROOT_CLASS);
			// parse the XML and return an instance of the CourseHierarchy class
			root = (CourseHierarchyNode) context.createUnmarshaller()
					.unmarshal(new FileInputStream(filename));

			return root;

		} catch (JAXBException e) {
			System.err.println("error parsing xml: ");
			e.printStackTrace();
			// force quit
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err
					.println("xml file " + filename + " could not be found: ");
			e.printStackTrace();
			System.exit(1);
		}

		return null;
	}

	public static void main(String[] args) {
		CourseHierarchyNode xml = JAXBParser
				.getCourseHierarchy("src/data/kurssit.xml");

		while (xml != null) {
			System.out.println(xml);
			xml = xml.getChild(0);
		}
	}
}

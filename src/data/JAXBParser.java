package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.*;

import model.StudyProgram;
import model.StudyProgram;

public class JAXBParser {
	public static StudyProgram getCourseHierarchy(String filename) {
		
		StudyProgram hierarchy;

		try {
			// setup object mapper using the CourseHierarchy class
			JAXBContext context = JAXBContext
					.newInstance(StudyProgram.class);
			// parse the XML and return an instance of the CourseHierarchy class
			hierarchy = (StudyProgram) context.createUnmarshaller().unmarshal(
					new FileInputStream(filename));
			
			return hierarchy;
			
		} catch (JAXBException e) {
			System.err.println("error parsing xml: ");
			e.printStackTrace();
			// force quit
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("xml file " + filename +" could not be found: ");
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		StudyProgram xml = JAXBParser.getCourseHierarchy("src/data/kurssit.xml");
		
		System.out.println(xml.getYears().size());
		System.out.println(xml.getYears().get(0).getEctsCredits());
	}
}

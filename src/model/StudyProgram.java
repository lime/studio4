package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

/**
 * Represents the root element of the XML data file.
 * 
 */
@XmlRootElement(name = "studies")
public class StudyProgram extends CourseHierarchyNode {
	/**
	 * The name of the study program.
	 */
	@XmlAttribute(required = false)
	private String name;

	/**
	 * The list of study years included in the program.
	 */
	@XmlElement(name = "year")
	private List<Year> years = new ArrayList<Year>();

	@Override
	public List<Year> getChildren() {
		return this.getYears();
	}

	public String getName() {
		return this.name;
	}

	public List<Year> getYears() {
		return this.years;
	}
}

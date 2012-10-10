package model;

import java.net.URL;
import java.util.List;

import javax.xml.bind.annotation.*;

public class Course extends CourseHierarchyNode {
	/**
	 * Number of ECTS credits granted for the course.
	 */
	@XmlAttribute(name = "noppa")
	int ectsCredits;
	/**
	 * Course code
	 */
	@XmlAttribute(name = "code")
	String courseCode;
	/**
	 * Name of the course
	 */
	@XmlElement
	String name;

	@Override
	public List<CourseHierarchyNode> getChildren() {
		return null;
	}

	@Override
	public int getWeight() {
		return this.ectsCredits;
	}
}

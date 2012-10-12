package model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

public class Department extends CourseHierarchyNode {
	/**
	 * Name of the department.
	 */
	@XmlAttribute
	private String name;
	/**
	 * Number of ECTS credits granted for the included courses.
	 */
	@XmlAttribute(name = "noppa")
	private int ectsCredits;
	/**
	 * 
	 */
	@XmlElement(name = "course")
	private List<Course> courses = new ArrayList<Course>();

	@Override
	public List<Course> getChildren() {
		return this.getCourses();
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return this.courses;
	}

	/**
	 * @return the ectsCredits
	 */
	public int getEctsCredits() {
		return this.ectsCredits;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL() {
		// TODO Auto-generated method stub
		return null;
	}
}

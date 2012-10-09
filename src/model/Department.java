package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

public class Department {
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
}

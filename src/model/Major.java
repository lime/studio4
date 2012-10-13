package model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Major extends CourseHierarchyNode{
	
	/**
	 * Name of the major.
	 */
	@XmlAttribute
	private String name;
	/**
	 * Number of ECTS credits granted for the included courses.
	 */
	@XmlAttribute(name = "noppa")
	private int ectsCredits;

	
	@XmlElement(name = "course")
	private List<Course> courses = new ArrayList<Course>();

	@Override
	public List<Course> getChildren() {
		return this.courses;
	}

	@Override
	public String getTitle() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return "Opintopisteet: " + this.ectsCredits;

	}

	@Override
	public URL getURL() {
		return null;
	}

	/* (non-Javadoc)
	 * @see model.CourseHierarchyNode#getWeight()
	 */
	@Override
	public int getWeight() {
		return super.getWeight();
	}

}

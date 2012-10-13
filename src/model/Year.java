package model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

public class Year extends CourseHierarchyNode {
	/**
	 * Year identifier, usually number in order.
	 */
	@XmlAttribute
	private int id;
	/**
	 * Number of ECTS credits granted for the included courses.
	 */
	@XmlAttribute(name = "noppa")
	private int ectsCredits;
	/**
	 * List of departments offering courses during the year.
	 */
	@XmlElement(name = "department")
	private List<Department> departments = new ArrayList<Department>();
	/**
	 * List of major subjects with courses during the year.
	 */
	@XmlElement(name = "major")
	private List<Major> majors = new ArrayList<Major>();

	@Override
	public List<? extends CourseHierarchyNode> getChildren() {
		if(!this.departments.isEmpty()) {
			return this.departments;
		} else if(!this.majors.isEmpty()){
			return this.majors;
		} else {
			return null;
		}
		
	}


	public int getEctsCredits() {
		return this.ectsCredits;
	}

	/* Getters and setters */
	public int getId() {
		return this.id;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Vuosi " + this.id;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		if(!this.departments.isEmpty()) {
			return "Opintopisteet: " + this.ectsCredits;
		} else {
			return null;
		}

	}

	@Override
	public URL getURL() {
		// TODO Auto-generated method stub
		return null;
	}

}
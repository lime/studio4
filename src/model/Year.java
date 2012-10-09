package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

public class Year {
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

	public List<Department> getDepartments() {
		return this.departments;
	}

	public int getEctsCredits() {
		return this.ectsCredits;
	}

	/* Getters and setters */
	public int getId() {
		return this.id;
	}

}
package model;

import java.net.URL;
import javax.xml.bind.annotation.*;

public class Course {
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
	/**
	 * Web page URL for the course information site.
	 */
	@XmlElement
	URL url;
}

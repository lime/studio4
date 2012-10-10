/**
 * 
 */
package view;

import data.JAXBParser;
import model.CourseHierarchyNode;
import processing.core.PApplet;

/**
 *
 */
@SuppressWarnings("serial")
public class CourseVisualizationApplet extends PApplet {
	
	private static final String DATA_FILENAME = "";
	
	private CourseHierarchyNode courseData;
	
	@Override
	public void draw() {
		this.background(255);
		
		this.drawCircles(courseData);
	}

	private void drawCircles(CourseHierarchyNode data) {
	}

	@Override
	public void setup() {
		this.size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
	}
}

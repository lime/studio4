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
<<<<<<< HEAD
		
		this.drawCircles(courseData);
	}

	private void drawCircles(CourseHierarchyNode data) {
=======
		rect(598, 50, 200, 500, 20, 20);
>>>>>>> Ikkunan koko + inforectangle
	}
	

	@Override
	public void setup() {
<<<<<<< HEAD
		this.size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
=======
		this.size(800, 600);
>>>>>>> Ikkunan koko + inforectangle
	}
}

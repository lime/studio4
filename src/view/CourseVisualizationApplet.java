/**
 * 
 */
package view;

import java.util.List;

import data.JAXBParser;
import model.CourseHierarchyNode;
import processing.core.PApplet;

/**
 *
 */
@SuppressWarnings("serial")
public class CourseVisualizationApplet extends PApplet {
	
	private static final String DATA_FILENAME = "data/kurssit.xml";
	
	private CourseHierarchyNode courseData;
	
	@Override
	public void draw() {

		this.background(255);

		this.fill(22, 220, 230);
		this.drawCircle(courseData);

	}

	private void drawCircles(CourseHierarchyNode data) {
	}
	


	void drawCircle(CourseHierarchyNode parentNode) {
		
		float edellinenKulma=0;
		List<? extends CourseHierarchyNode> children = parentNode.getChildren();
		for(int i=0; i<children.size(); i++) {
		
		float kulma = 2*PI*children.get(i).getWeight()/parentNode.getWeight();
		this.arc(400, 300, 250, 250
				, edellinenKulma, kulma);
		fill(22, 220, 230);
		
		edellinenKulma = 2*PI*children.get(i).getWeight()/parentNode.getWeight();
		
		System.out.println("CourseVisualizationApplet.drawCircle() "+children);
		}
		
		
	}

	@Override
	public void setup() {
		this.size(800, 600);
		
		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
		this.size(800, 600);
	}
}

/**
 * 
 */
package view;

import java.util.List;

import data.JAXBParser;
import model.CourseHierarchyNode;
import processing.core.PApplet;
import processing.core.PFont;

/**
 *
 */
@SuppressWarnings("serial")
public class CourseVisualizationApplet extends PApplet {

	private static final String DATA_FILENAME = "data/kurssit.xml";

	private CourseHierarchyNode courseData;
	private CourseHierarchyNode selectedNode;

	private ArcSegment courseSegment;

	@Override
	public void draw() {

		this.background(0);


		// draw infobox

		
//		PFont fontA = loadFont("Arial");
//		textFont(fontA, 12);
		textSize(12);
		textAlign(CENTER);
		fill(51);
		
		
		
		rect(598, 50, 200, 500, 20, 20);

		this.fill(22, 220, 230);
		this.drawInfobox(selectedNode);
		//this.pushMatrix();
		//this.translate(width/3, height/2);
		this.courseSegment.drawSegment(this);
		//this.popMatrix();
	}


	private void drawInfobox(CourseHierarchyNode displayNode) {
		// save the current matrix state
		this.pushMatrix();
		this.translate(598, 50);

		this.rect(0, 0, 200, 500, 20, 20);

		String title = displayNode.getTitle();
		if (title == null) {
			title = "Untitled";
		}

		this.fill(0);
		this.text(title, 5, 20, 174, 490);

		// reset matrix
		this.popMatrix();
	}

	@Override
	public void setup() {
		this.size(800, 600);
		this.colorMode(HSB);
		this.smooth();
		
		int start = 0;
		int stop = 360;
		int colorHue = 150;
		int colorSat = 50;

		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
		this.selectedNode = this.courseData;
		
		courseSegment = new ArcSegment(this.courseData, width/3, height/2, ArcSegment.ARC_SIZE, start,
				stop, colorHue, colorSat, 0, null);
	}


	CourseHierarchyNode getSelected() {
		return this.selectedNode;
	}


	void setSelected(CourseHierarchyNode node) {
		this.selectedNode = node;
	}
}

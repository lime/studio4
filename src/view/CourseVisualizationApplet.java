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
	private CourseHierarchyNode selectedNode;

	private ArcSegment courseSegment;

	@Override
	public void draw() {

		this.background(255);

		// draw infobox
		this.fill(22, 220, 230);
		this.drawInfobox(selectedNode);
		this.pushMatrix();
		this.translate(width/3, height/2);
		this.courseSegment.drawSegment(this);
		this.popMatrix();
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
		this.fill(255);
		this.text(title, 0, 0);
		// reset matrix
		this.popMatrix();
	}

	private void drawCircles(CourseHierarchyNode data) {
	}

	void drawCircle(CourseHierarchyNode parentNode) {

		
		
		float edellinenKulma = 0;
		List<? extends CourseHierarchyNode> children = parentNode.getChildren();
		for (int i = 0; i < children.size(); i++) {

			float kulma = 2 * PI * children.get(i).getWeight()
					/ parentNode.getWeight();
			this.arc(400, 300, 250, 250, edellinenKulma, kulma);
			fill(22, 220, 230);

			edellinenKulma = 2 * PI * children.get(i).getWeight()
					/ parentNode.getWeight();

		}

	}

	@Override
	public void setup() {
		this.size(800, 600);
		this.colorMode(HSB);
		
		int size = 200;
		int start = 0;
		int stop = 360;
		int colorHue = 0;
		int colorSat = 255;

		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
		this.selectedNode = this.courseData;
		
		courseSegment = new ArcSegment(this.courseData, 0, 0, size, size, start,
				stop, colorHue, colorSat, 0);
	}
}

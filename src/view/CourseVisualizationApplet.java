/**
 * 
 */
package view;

import java.net.URL;
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

	private ArcSegment rootSegment;

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
		this.rootSegment.drawSegment(this);
		//this.popMatrix();
	}


	private void drawInfobox(CourseHierarchyNode displayNode) {
		// save the current matrix state
		this.pushMatrix();
		this.translate(598, 50);

		this.rect(0, 0, 200, 500, 20, 20);

		String title = displayNode.getTitle();
		String desc = displayNode.getDescription();
		URL url = displayNode.getURL();
		title = title == null ? "Untitled" : title;
		desc = desc == null ? "" : desc;

		this.fill(0);
		this.text(title, 5, 20, 174, 150);
		this.text(desc, 5, 150, 174, 490);

		// reset matrix
		this.popMatrix();
	}

	@Override
	public void setup() {
		size(900, 600);
		this.colorMode(HSB);
		this.smooth();
		
		int colorHue = 150;
		int colorSat = 50;

		this.courseData = JAXBParser.getCourseHierarchy(DATA_FILENAME);
		this.selectedNode = this.courseData;
		
		/*this.setRootSegment( new ArcSegment(this.courseData, width/3, height/2, start,
				stop, colorHue, colorSat, 0, null) );*/
				
		this.setRootSegment(colorHue, colorSat, null);
	}


	CourseHierarchyNode getSelected() {
		return this.selectedNode;
	}

	void setSelected(CourseHierarchyNode node) {
		this.selectedNode = node;
	}
	
	void setRootSegment(int colorHue, int colorSat, ArcSegment parent) {
		
		this.rootSegment = new ArcSegment(this.selectedNode, width/3, height/2, 0,
				360, colorHue, colorSat, 0, parent);
		//segment.setNewAngle(0, 360);
		//segment.setNewLevel(0);

	}


	/**
	 * @return the rootSegment
	 */
	public ArcSegment getRootSegment() {
		return rootSegment;
	}


	void setRootSegment(ArcSegment existing) {
		this.setRootSegment(existing.colorHue, existing.colorSat, existing.getParent());
	}

	public static void main(String args[])
    {
      PApplet.main(new String[] { view.CourseVisualizationApplet.class.getName() });
    }

}

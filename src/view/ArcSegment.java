package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;

import model.CourseHierarchyNode;

class ArcSegment {

	static final int ARC_SIZE = 100;
	private List<ArcSegment> children;
	final int x, y; // arc origin
	final int size;
	final int start, stop; // angle start and stop in degrees
	final int colorHue;
	final int colorSat;
	final int level;
	private int angleSize;
	private CourseHierarchyNode data;

	public ArcSegment(CourseHierarchyNode data, int x, int y, int size, int start, int stop, int colorHue, int colorSat, int level) {

		this.data = data;
		
		this.children = new LinkedList<ArcSegment>();
		this.x = x;
		this.y = y;
		this.size = size;
		this.start = start;
		this.stop = stop;
		this.angleSize = Math.abs(this.start - this.stop);
		this.colorHue = colorHue;
		this.colorSat = colorSat;
		this.level = level;

		if (this.data.hasChildren()) {
			System.out.println("ArcSegment.ArcSegment() " + this.data);
			addChildren(this.data);
		}
	}

	private void addChildren(CourseHierarchyNode parentNode) {

		int newSat = this.colorSat + 50;
		int newSize = this.size + ARC_SIZE;
		int newStart = this.start;
		int newStop = this.start;
		int newHue = this.colorHue + 5;

		// iterate through all child data and create arc segments for them
		for (CourseHierarchyNode childData : parentNode.getChildren()) {
			
			float weightRelation = childData.getWeight() / (float) parentNode.getWeight();
			int newAngleSize = (int)Math.ceil( this.angleSize * weightRelation); //TODO
			newStart = newStop;
			newStop += newAngleSize;
			newHue = (int) (newHue + 255 * weightRelation * this.angleSize / 360) % 255 ;

			this.children.add(new ArcSegment(childData, this.x, this.y, newSize,
					newStart, newStop, newHue, newSat, this.level + 1));
		}
	}

	void drawSegment(CourseVisualizationApplet applet) {
		//System.out.println("ArcSegment.drawSegment() SIZE: " + this.children.size());
		//System.out.println("ArcSegment.drawSegment() angle from " + this.start +" to "+this.stop+" at level "+this.level);
		for (ArcSegment child : this.children) {
			child.drawSegment(applet);
		}
		//check for hover
		this.checkHover(applet);
		if(this.data.equals(applet.getSelected())){
			applet.fill(this.colorHue, 255, 255);
		} else {
			applet.fill(this.colorHue, this.colorSat, (this.level+2) * 40);
		}
		applet.noStroke();
		applet.arc(this.x, this.y, this.size, this.size, PApplet.radians(this.start),
				PApplet.radians(this.stop));
	}

	private void checkHover(CourseVisualizationApplet applet) {
		if(new Random().nextDouble() < 0.0005) { //FIXME if mouse over
			applet.setSelected(this.data);
		}
	}
}

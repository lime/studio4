package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;

import model.CourseHierarchyNode;

class ArcSegment {

	private List<ArcSegment> children;
	final int x, y; // arc origin
	int start, stop; // angle start and stop in degrees
	final int colorHue;
	final int colorSat;
	int level;
	private CourseHierarchyNode data;
	private ArcSegment parent;

	public ArcSegment(CourseHierarchyNode data, int x, int y,
			int start, int stop, int colorHue, int colorSat, int level,
			ArcSegment parent) {

		this.data = data;
		this.parent = parent;

		this.children = new LinkedList<ArcSegment>();
		this.x = x;
		this.y = y;
		this.start = start;
		this.stop = stop;
		this.colorHue = colorHue;
		this.colorSat = colorSat;
		this.level = level;

		if (this.data.hasChildren()) {
			// System.out.println("ArcSegment.ArcSegment() " + this.data);
			addChildren(this.data);
		}

	}

	private int angleSize() {
		return Math.abs(this.start - this.stop);
	}
	
	private int size() {
		return (int) ( 80 * this.level + Math.pow(2, this.level) * 40 );
		//return 150 * (this.level + 1);
	}
	

	private void addChildren(CourseHierarchyNode parentNode) {

		int newSat = this.colorSat + 50;
		
		int newStart = this.start;
		int newStop = this.start;
		int newHue = this.colorHue + 5;

		// iterate through all child data and create arc segments for them
		for (CourseHierarchyNode childData : parentNode.getChildren()) {

			float weightRelation = childData.getWeight()
					/ (float) parentNode.getWeight();
			int newAngleSize = (int) Math.floor(this.angleSize() * weightRelation); // TODO
			newStart = newStop;
			newStop += newAngleSize;
			newHue = (int) (newHue + 255 * weightRelation * this.angleSize()
					/ 360) % 255;

			this.children.add(new ArcSegment(childData, this.x, this.y,
				 newStart, newStop, newHue, newSat, this.level + 1,
					this));
		}
	}

	void drawSegment(CourseVisualizationApplet applet) {
		// System.out.println("ArcSegment.drawSegment() SIZE: " +
		// this.children.size());
		// System.out.println("ArcSegment.drawSegment() angle from " +
		// this.start +" to "+this.stop+" at level "+this.level);
		for (ArcSegment child : this.children) {
			child.drawSegment(applet);
		}
		// check for hover
		this.checkHover(applet);
		if (this.data.equals(applet.getSelected())) {
			applet.fill(this.colorHue, 100, 255);
		} else {
			applet.fill(this.colorHue, (this.level + 3) * 40,
					(this.level + 3) * 40);
		}
		applet.noStroke();
		applet.arc(this.x, this.y, size(), size(),
				PApplet.radians(this.start), PApplet.radians(this.stop) );
	}

	private void checkHover(CourseVisualizationApplet applet) {
		if (mouseOver(applet)) {
			applet.setSelected(this.data);

			//NOTE: mouse press not implemented because of unresolved bugs
			/*if (applet.mousePressed) {
				if (this.equals(applet.getRootSegment()) && this.parent != null) {
					applet.setRootSegment(this.parent);
				} else {
					System.out.println("ArcSegment.checkHover() " + applet.getRootSegment().data.getTitle());
					applet.setRootSegment(this);
				}
			}*/
		}
	}

	void setNewAngle(int start, int stop) {
		int newStart = this.start = start;
		int newStop = this.start = stop;
		System.out.println("ArcSegment.setNewAngle() " + this.angleSize() +  " " + this.start + " " + this.stop);

		
		/*for (ArcSegment child : this.children) {
			float weightRelation = child.data.getWeight()
					/ (float) this.data.getWeight();
			int newAngleSize = (int) Math.ceil(this.angleSize() * weightRelation); // TODO
			newStart = newStop;
			newStop += newAngleSize;
			child.setNewAngle(newStart, newStop);
		}*/
	}
	
	void setNewLevel(int level) {
		this.level = level;
		for (ArcSegment child : this.children) {
			child.setNewLevel(level +1 );
		}
	}

	/**
	 * Test to see if mouse is over this arc
	 * 
	 * @param applet
	 */
	boolean mouseOver(CourseVisualizationApplet applet) {
		float disX = this.x - applet.mouseX;
		float disY = this.y - applet.mouseY;
		double mouseAngle = PApplet
				.degrees((float) (Math.atan2(disY, disX) + Math.PI));

		boolean insideCircle = Math.sqrt(Math.pow(disX, 2) + Math.pow(disY, 2)) < size() / 2;
		boolean outsideParentCircle = this.level == 0
				|| Math.sqrt(Math.pow(disX, 2) + Math.pow(disY, 2)) > parent.size() / 2;
		boolean insideAngle = mouseAngle > this.start && mouseAngle < this.stop;
		// System.out.println("ArcSegment.mouseOver() " + mouseAngle + " " +
		// this.start);

		if (insideCircle && outsideParentCircle && insideAngle) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the parent
	 */
	public ArcSegment getParent() {
		return parent;
	}

}

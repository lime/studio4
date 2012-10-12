package view;

import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;

import model.CourseHierarchyNode;

class ArcSegment {

	private static final int ARC_SIZE = 100;
	private List<ArcSegment> children;
	final int x, y; // arc origin
	final int w, h; // arc size
	final int start, stop; // angle start and stop in degrees
	final int colorHue;
	final int colorSat;
	final int level;
	private int angleSize;

	public ArcSegment(CourseHierarchyNode parentNode, int x, int y, int w,
			int h, int start, int stop, int colorHue, int colorSat, int level) {

		this.children = new LinkedList<ArcSegment>();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.start = start;
		this.stop = stop;
		this.angleSize = Math.abs(this.start - this.stop);
		this.colorHue = colorHue;
		this.colorSat = colorSat;
		this.level = level;

		if (parentNode.hasChildren()) {
			System.out.println("ArcSegment.ArcSegment() " + parentNode);
			addChildren(parentNode);
		}
	}

	private void addChildren(CourseHierarchyNode parentNode) {

		int newSat = this.colorSat;
		int newW = this.w + ARC_SIZE;
		int newH = this.h + ARC_SIZE;
		int newStart = this.start;
		int newStop = this.start;

		// iterate through all child data and create arc segments for them
		for (CourseHierarchyNode childData : parentNode.getChildren()) {
			
			float weightRelation = childData.getWeight() / (float) parentNode.getWeight();
			int newAngleSize = Math.round( this.angleSize * weightRelation); //TODO
			newStart = newStop;
			newStop += newAngleSize;
			int newHue = this.colorHue + 10;

			this.children.add(new ArcSegment(childData, this.x, this.y, newW,
					newH, newStart, newStop, newHue, newSat, this.level + 1));
		}
	}

	void drawSegment(PApplet applet) {
		System.out.println("ArcSegment.drawSegment() SIZE: " + this.children.size());
		for (ArcSegment child : this.children) {			
			child.drawSegment(applet);
		}
		applet.fill(this.colorHue, this.colorSat, 255);
		applet.arc(this.x, this.y, this.w, this.h, PApplet.radians(this.start),
				PApplet.radians(this.stop));
	}

	/*void drawChildSegments(PApplet applet) {
		for (int i = 0; i < children.size(); i++) {

			float kulma = 2 * PI * children.get(i).getWeight()
					/ parentNode.getWeight();
			this.arc(400, 300, 250, 250, edellinenKulma, kulma);
			fill(22, 220, 230);

			edellinenKulma = 2 * PI * children.get(i).getWeight()
					/ parentNode.getWeight();

		}
	}*/
}

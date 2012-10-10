/**
 * 
 */
package view;

import processing.core.PApplet;

/**
 *
 */
public class CourseVisualizationApplet extends PApplet {
	@Override
	public void draw() {
		this.background(255);
		this.drawCircle();
	}

	@Override
	public void setup() {
		this.size(800, 600);
	}
	
	void drawCircle() {
		
		arc(400, 300, 250, 250, 0, HALF_PI);
		fill(22, 220, 230);
		
	}
}

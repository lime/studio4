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
		ellipse(20, 20, 20, 20);
	}

	@Override
	public void setup() {
		this.size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}

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
		rect(598, 50, 200, 500, 20, 20);
	}
	

	@Override
	public void setup() {
		this.size(800, 600);
	}
}

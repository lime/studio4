/**
 * 
 */
package model;

import java.util.List;

/**
 * A node in the course hierarchy.
 */
public abstract class CourseHierarchyNode {

	public CourseHierarchyNode getChild(int index) {
		if (this.getChildren() == null) {
			return null;
		} else {
			return this.getChildren().get(index);
		}
	}

	public abstract List<? extends CourseHierarchyNode> getChildren();

}

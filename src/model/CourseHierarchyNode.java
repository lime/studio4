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
		
	public int getWeight() {
		int weight = 0;
		for(CourseHierarchyNode child : this.getChildren()) {
			weight += child.getWeight();
		}
		return weight;
	}

}

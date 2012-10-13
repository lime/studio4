/**
 * 
 */
package model;

import java.net.URL;
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
	
	public final boolean hasChildren() {
		return this.getChildren() != null;
	}
		
	public int getWeight() {
		int weight = 0;
		for(CourseHierarchyNode child : this.getChildren()) {
			weight += child.getWeight();
		}
		return weight;
	}
	
	/**
	 * 
	 * @return the title or name of the node
	 */
	public abstract String getTitle();
	
	/**
	 * 
	 * @return the description text of the node
	 */
	public abstract String getDescription();
	
	/**
	 * @return the URL of the node if one exists, otherwise null
	 */
	public abstract URL getURL();
}

/**
 * 
 */
package model;

import java.awt.geom.Arc2D;
import java.util.List;

import com.sun.crypto.provider.ARCFOURCipher;

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

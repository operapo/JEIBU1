package frameModule;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**@author Eric Song
*@since 9/25/2017
*@category pane setup.
*@Description
*Always Pane class goes first. PP{@code} mid-low to high.
*/

class Explorer extends BaseSetupModule{
	
	
@Override
public void add_on_Run(JFrame j,Container container,int width,int height) {
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
	JTree jtree = new JTree(root);
	JTable table;
	Vector<Object> header;
	JScrollPane[] jcp = new JScrollPane[2];
	jcp[0] = new JScrollPane(jtree);
	jcp[0].setPreferredSize(new Dimension(width/2-(width/8),height));
	JSplitPane jsp = new JSplitPane();
	jsp.setRightComponent(new DrawComponent());
	jsp.setLeftComponent(jcp[0]);
    container.add("Center",jsp);
    j.validate();  
	
}}

class Buter extends BaseSetupModule{

	@Override
	public void add_on_Run(JFrame j, Container container, int width, int height) {
		container.add(new JButton("click me"));
		j.validate();
		
	}
	}


public class Pane extends BaseSetupModule {

	
	@Override
	public void add_on_Run(JFrame j, Container container, int width, int height) {
		// TODO Auto-generated method stub
		
	}

}

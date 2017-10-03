package frameModule;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



class JMBarSetup extends JMenuBar{ 
	
	private JFrame frame;
	private List<JMenuSetup> jml;
	public JMenuSetup[] jmenu;
	
	/**
	 * Default
	 */
	JMBarSetup(JFrame j,JMenuSetup... menu){
		jml = new ArrayList<>();
		this.frame = j;
		for(JMenuSetup jm:menu){
			this.add(jm);
			jml.add(jm);
		}
		this.jmenu = new JMenuSetup[jml.size()];
		jml.toArray(jmenu);
		
		j.validate();
	}
	
	public void addMenu(JMenuSetup... menu){
		
		for(JMenuSetup jm:menu){
			this.add(jm);
			jml.add(jm);
		}
		this.jmenu = new JMenuSetup[jml.size()];
		jml.toArray(jmenu);
		frame.validate();
	}
	
}

class JMenuSetup extends JMenu{
	
	
	public JMenuItem[] JMI;
	private List<JMenuItem> JMISetup;
	/**
	 * 
	 * @param menu
	 * @param m
	 * default menu setup
	 */
	 JMenuSetup(String name,JMenuItem...m){
		JMISetup = new ArrayList<>();
		this.setText(name);
		this.JMI=m;
	    for(JMenuItem jmi:m){
	    	this.add(jmi);
	       JMISetup.add(jmi);
	    }
	   JMI =  new JMenuItem[JMISetup.size()];
	   JMISetup.toArray(JMI);
	}
	 public void addMenuItem(JMenuItem...m){
		 for(JMenuItem jmi:m){
			 this.add(jmi);
			 JMISetup.add(jmi);
		 }
		 JMI = new JMenuItem[JMISetup.size()];
		 JMISetup.toArray(JMI);
	 }
}

class JMISetup{
JMenuItem[] jmenuitem;
	/**
	 * Display what JMI added. default is false.
	 */
	JMISetup(JMenuSetup mbs,boolean showDisplay){
		if(showDisplay = true)for(JMenuItem jmi: mbs.JMI)System.out.println(jmi.toString()); 
		jmenuitem = mbs.JMI;
	}
	/**
	 * Display what JMI added. default is false.
	 */
	JMISetup(JMenuSetup mbs){
		jmenuitem = mbs.JMI;
		System.out.println(mbs);
	}
	
	
	
}
//Frame Section
abstract class FrameDefault extends BaseFrameModule implements action{
	
	/**@description 
	 * Default Frame Style
	 * always starts with jmbs. 
	 * ex* jmbs = new JMBarSetup(...);
	 */
	FrameDefault(){
		jmbs= new JMBarSetup(this);
		super.MenuStyle();
		super.ActionHelper();
		actionRunSetup();
	}
	
	@Override
	protected void addSetup() {}
	@Override
	public void actionRunSetup() {}

	@Override
	public void actionSetup() {}
	
}

class FrameRegular extends FrameDefault {

	@Override
	protected void addSetup() {
		this.jmbs.addMenu(new JMenuSetup("File",new JMenuItem("Open"),new JMenuItem("Close")));
		super.addSetup();
	}

	@Override
	public void actionRunSetup() {
		jMenuItemSetup[0].addActionListener(e->{System.out.println("cool");});
	}	
}

//Example
class FrameSpecial extends FrameDefault{

	@Override
	protected void addSetup() {
		this.jmbs.addMenu(new JMenuSetup("File", new JMenuItem("Open"),new JMenuItem("Close")));
		super.addSetup();
	}

	@Override
	public void actionRunSetup() {
		this.jMenuItemSetup[0].addActionListener(e->{new Pane().BaisicConfiguration(new FrameSpecial(), 500, 500, new Explorer(),true);});
		this.jMenuItemSetup[1].addActionListener(e->{this.dispose();});
		super.actionRunSetup();
	}
	
}


interface action{
	public void actionRunSetup();
	public void actionSetup();
}

public class FrameStyle{

	
}

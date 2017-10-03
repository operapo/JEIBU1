package frameModule;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public abstract class BaseFrameModule extends JFrame{
	protected JMBarSetup jmbs;//default.
	public JMenuSetup[] jMbSetup;
	public JMenuItem [] jMenuItemSetup;
    protected void MenuStyle(){this.addSetup();super.setJMenuBar(jmbs);}
    protected void ActionHelper(){
    	jMbSetup = jmbs.jmenu;
    	jMenuItemSetup = jmbs.jmenu[0].JMI;
    	List<String> nameList = new ArrayList<>();
    	List<String> itemList = new ArrayList<>();
    	for(JMenuSetup jms: jMbSetup){
    	     nameList.add(jms.getText().trim());
    	     for(JMenuItem jmi:jms.JMI){
    	    	 itemList.add(jmi.getText().trim());
    	     }
    	}
    };
    protected abstract void addSetup();
   
}

package frameModule;

import java.awt.Color;
/**
 * Author:Eric S.
 */
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.InputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class TestPaneExample {

}

//DrawInsert Area

abstract class DrawInsert extends BaseSetupModule {	
	protected JComponent[] jc;
	@Override
	public void add_on_Run(JFrame j, Container container, int width, int height) {
		EventQueue.invokeLater(()->{
	    //j.setLayout(new FlowLayout(FlowLayout.RIGHT));
		j.setTitle("DrawTest");
		InsertComponent(j,this.jc);
		});}
	private void InsertComponent(JFrame j, JComponent... jc) {
		for(JComponent jcm : jc){
			j.add(jcm);}
		j.validate();
	}
	public void componentSetup(JComponent... jc){
		this.jc = jc;
	}
}

class DrawerExample2 extends DrawInsert{
	
}

class DrawerExample extends DrawInsert{
	DrawerExample(){
		JSlider r = new JSlider();
		JSlider r1 = new JSlider();
		JPanel j = new JPanel();
				j.add(r);
				j.add(r1);
		componentSetup(j);
		
//		r.addChangeListener(e->{
//			System.out.println(r.getValue());
//		});
	r.setSize(200,200);
	r.addChangeListener(e->{System.out.println("fisrt "+r.getValue());});
	r1.addChangeListener(e->{System.out.println("second "+r1.getValue());});
	}
}

class Drawer extends DrawInsert{
	private JFrame jp;
	@Override
	public void add_on_Run(JFrame j, Container container, int width, int height) {

		this.jp=j;
		super.add_on_Run(j, container, width, height);
	}
	Drawer(){
	
	JComboBox<String> faceCombo = new JComboBox<>();
	faceCombo.addItem("");
	faceCombo.addItem("EUichanSOng");
	JPanel k= new JPanel();
	k.add(faceCombo);
	k.setLayout(new FlowLayout(FlowLayout.RIGHT));
	faceCombo.addActionListener(e->{
		if(faceCombo.getSelectedIndex() ==0)System.out.println("EuichanSelected");
		else if(faceCombo.getSelectedIndex()==1)System.out.println("EuichanSelected2");
	});
	
	componentSetup(k);
	}
	
}

//Mouse
class MouseComponent extends JComponent{
	public MouseComponent(){
		addMouseListener(new MouseHandler());
	}
	private class MouseHandler extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("euichan");
			super.mouseClicked(arg0);
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent arg0) {
			// TODO Auto-generated method stub
			super.mouseWheelMoved(arg0);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			System.out.println("euichan2");
			super.mousePressed(arg0);
		}
		
	}
}


class DrawTest extends DrawInsert{
	private JFrame jp;
	@Override
	public void add_on_Run(JFrame j, Container container, int width, int height) {
		jp=j;
		super.add_on_Run(j, container, width, height);
	}

	private JPanel jj;
	DrawTest(){
 
		JPanel j = new JPanel();
		this.jj = j;
		j.setSize(100,100);
		//j.add(new DrawComponent());
		JButton jb = new JButton("wow");
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info:infos){
		makeButton(info.getName(),info.getClassName());
		
		}
		jb.addActionListener(e->{
			j.setBackground(Color.BLACK);
		});
		j.add(jb);
		componentSetup(j);
		
	}
	
	public void makeButton(String name,String className){
		JButton button = new JButton(name);
		jj.add(button);
		button.addActionListener(e->{
			try{
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this.jp);
			}catch(Exception e4){
				e4.printStackTrace();
			}
		});
	}
}

class DrawComponent extends JComponent{
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2= (Graphics2D)g; 
				Shape s = new Rectangle(100, 100, 100, 100);

				String message ="Hello!";
				Font f = new Font("Serif",Font.BOLD,36);
				g2.setPaint(Color.red);
				g2.setFont(f);
				g2.drawString(message, 100, 100);
				super.paintComponent(g);
			
				//draw the enclosed eclipse
	}	
}

	


package frameModule;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

abstract class BaseSetupModule {
	public int			width, height;
	public JFrame		frame;
	public Container	container;

	public abstract void add_on_Run(JFrame j, Container container, int width, int height);

	private void run() {
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	};

	public void BaisicConfiguration(JFrame frame, int width, int height, BaseSetupModule module, boolean center) {

		this.width = width;
		this.height = height;
		this.frame = frame;
		this.container = this.frame.getContentPane();
		this.frame.setSize(width, height);
		if (center == true) {
			Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation(display.width / 2 - (width / 2), display.height / 2 - (height / 2));
		} else {
			frame.setLocation(0, 0);
		}

		run();
		module.add_on_Run(this.frame, this.container, this.width, this.height);
	}

}
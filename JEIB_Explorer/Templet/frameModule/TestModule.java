package frameModule;

import java.util.logging.Logger;

public class TestModule {
public static void main(String args[]){

Logger.getGlobal().info("Run");
//new Pane().BaisicConfiguration(new FrameSpecial(),700, 500,new Explorer(),true);//<--this should choose which module will be applied.
new Pane().BaisicConfiguration(new FrameSpecial(), 1000, 500, new Explorer(), true);

	
}

}

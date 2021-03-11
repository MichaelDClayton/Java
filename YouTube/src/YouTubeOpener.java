import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class YouTubeOpener extends TimerTask {

	public static void main(String[] args) {
		
		//Timer t1 = new Timer();
		//t1.schedule(new YouTubeOpener(), 0,60000);
		playInChrome();
		
	}
	
	public void run() {
		
		String uri = "*************";

		try {
			URI currentURI = new URI(uri);
			if(Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().browse(currentURI);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void playInChrome() {
		
		try {
	        while (true) {

	    		try {
	    			Runtime.getRuntime().exec(new String[]{"/usr/bin/open", "-a", "/Applications/Google Chrome.app", "https://youtu.be/tFAQ_nU75pg"});
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		
	            Thread.sleep(5 * 180000);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

		
		
		
		

	}
}

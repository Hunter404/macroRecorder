package recorder;

import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class ScrollRecorder implements NativeMouseWheelListener {
	private String filepath;
	
	public ScrollRecorder(String filepath){
		this.filepath = filepath;
	}
	
	@Override
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filepath, true));
            
            int notch = e.getWheelRotation();
            out.write("Scroll " + notch);
            out.newLine();
            out.close();
	    }
	    catch (IOException iox) {
	            System.err.println("Error writing.");
	            System.err.println(iox.getMessage());
	
	            System.exit(1);
	    }		
	}

}

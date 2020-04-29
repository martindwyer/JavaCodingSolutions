package mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * Administrator view This view observes all plans through interaction with the
 * model and through callbacks from plans as they change.
 */
import java.awt.Frame;
import java.awt.event.WindowEvent; 		//for CloseListener()
import java.awt.event.WindowAdapter; 	//for CloseListener()
import java.util.Observable; 			//for update();
import java.util.Date;
import java.sql.Timestamp;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AdminView implements java.util.Observer {

    // attributes as must be visible within class
    private JTextArea responsejTextArea1;
    public WERSController controller;

    /**
     * Construct an Administrator view
     */
    public AdminView() {
        System.out.println("AdminView()" + this);

        // frame in constructor and not an attribute as doesn't need to be
        // visible to whole class
        Frame frame = new Frame("Walden Emergency Response System");
        // panel in constructor and not an attribute as doesn't need to be
        // visible to whole class
        frame.addWindowListener(new CloseListener());
        frame.setSize(400, 600);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        frame.setPreferredSize(new java.awt.Dimension(557, 277));
        frame.setTitle("WERS Admin View");
        {
            // CHANGED for OBSERVER IMPLEMENTATION
            responsejTextArea1 = new JTextArea();
            JScrollPane jsp = new JScrollPane(responsejTextArea1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            responsejTextArea1.setLayout(new FlowLayout());
            frame.add(jsp);
            //responsejTextArea1.setPreferredSize(new java.awt.Dimension(557, 95));
            
        }

    }

    /**
     * Called from the Model(s) (i.e. plans with changes
     */
    public void update(Observable obs, Object obj) {
        
        // CHANGED for OBSERVER IMPLEMENTATION
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        if( obj == "new responder") {
            this.responsejTextArea1.append("New responder window opened at " + ts + "\n----------\n");
        } else {
            this.responsejTextArea1.append("Response plan provided at " + ts + "\n");           
            this.responsejTextArea1.append("Response plan details: \n\n " + obj + "\n----------\n");
        }

    }

    public static class CloseListener extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    public void init(String viewsData) {
        responsejTextArea1.setText(viewsData);
    }

    public void addController(WERSController myController) {
        this.controller = myController;
        System.out.println("AdminView      : adding controller " + controller);

    }

}

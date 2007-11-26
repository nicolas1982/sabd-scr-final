/*
 * MyInternalFrame.java
 *
 * Created on 17 de noviembre de 2007, 19:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package layout.frame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sergio
 */
public class MyInternalFrame extends JInternalFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int xOffset = 30, yOffset = 30;
    
    public MyInternalFrame(String name, JPanel panel) {
        super(name,  // name
              true, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable

        panel.setVisible(true);
        this.getContentPane().add(panel);
        pack();
    }
   
}

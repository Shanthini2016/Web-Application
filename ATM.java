import java.awt.*;
import java.awt.event.*;
import atm.ATM;
import simulation.Simulation;

/** Main program class for the application version of the ATM simulation.
 *  Create an instance of the ATM, put it in a frame, and then let the GUI
 *  do the work.
 */
 
public class ATMMain
{
    public static void main(String[] args)
    {
        ATM theATM = new ATM(42, "VIT VELLORE", "HDFC",
                             null /* We're not really talking to a bank! */);
        Simulation theSimulation = new Simulation(theATM);
        
      
        
        Frame mainFrame = new Frame("ATM Simulation");
        mainFrame.add(theSimulation.getGUI());
        
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem quitItem = new MenuItem("Quit", new MenuShortcut('Q'));
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        mainFrame.setMenuBar(menuBar);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        new Thread(theATM).start();
 
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
    
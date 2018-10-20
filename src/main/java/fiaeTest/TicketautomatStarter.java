package fiaeTest;




import javax.swing.*;

import fiaeTest.gui.MainFrame;

public class TicketautomatStarter {
  
    static MainFrame gui;
    static Ticketautomat ticketAutomat;
    public static void main(String[] args) {
        
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui = new MainFrame();
                ticketAutomat = new Ticketautomat((TicketautomatListener) gui);
                gui.setAutomat(ticketAutomat);
                gui.setVisible(true);
            }
        });
        
    }
}
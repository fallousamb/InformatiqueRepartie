package village;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * API du monde des fourmis
 */
public class APIMonde extends Frame
    implements ActionListener, WindowListener {


    private Panel ivjContentsPane;

    private static World ivjMonde;

    int w=600,h=600;
    

    public APIMonde() {

        ivjContentsPane = null;
        ivjMonde = this.getMonde1();
        initialize();
    }
    
    public APIMonde(String title) {
        super(title);

        ivjContentsPane = null;

        ivjMonde = this.getMonde1();

    }
    
    public void actionPerformed(ActionEvent e) {
      
    }
    
 
   
    
   
    
    
    
    
    private Panel getContentsPane() {
        if(ivjContentsPane == null)
            try {
                ivjContentsPane = new Panel();
                ivjContentsPane.setName("ContentsPane");
                ivjContentsPane.setLayout(null);
                getContentsPane().add(getMonde1(), getMonde1().getName());
              
            }
            catch(Throwable ivjExc) {
                handleException(ivjExc);
            }
        return ivjContentsPane;
    }
    
  
    
    private World getMonde1() {
        if(ivjMonde == null)
            try {
                    ivjMonde = new World(w,h);
                    ivjMonde.setName("Monde1");
                    ivjMonde.setLayout(null);
                    ivjMonde.setBackground(Color.white);
                    ivjMonde.setBounds(0, 0, w, h);
            }
            catch(Throwable ivjExc) {
                    handleException(ivjExc);
            }
        return ivjMonde;
    }

    public static World getMonde() {
        return ivjMonde;
    }
    
   
    
    private void handleException(Throwable throwable) {
    }
    
      
    public void initialize() {
        setName("Le monde des fourmiz");
        setLayout(new BorderLayout());
        setSize(w,h);
        setBackground(Color.WHITE);
        setResizable(false);
        add(getContentsPane(), "Center");
        
    }
    
    public void windowActivated(WindowEvent windowevent) {
    }
    
    public void windowClosed(WindowEvent windowevent) {
    }
    
    public void windowClosing(WindowEvent e) {
            
    }
    
    public void windowDeactivated(WindowEvent windowevent) {
    }
    
    public void windowDeiconified(WindowEvent windowevent) {
    }
    
    public void windowIconified(WindowEvent windowevent) {
    }
    
    public void windowOpened(WindowEvent windowevent) {
    }
    
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ch10_3 extends JFrame{
    public ch10_3(){
        setTitle("ch10_3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        JLabel j = new JLabel("Love Java");
        c.add(j);
        c.setFocusable(true);
        c.requestFocus();

        c.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    String text = j.getText();
                    if(text.equals("Love Java")){
                        j.setText("avaJ evoL");
                    }
                    else{
                        j.setText("Love Java");
                    }
                }
            } 
        });

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch10_3();
    }
}

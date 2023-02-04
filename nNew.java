import javax.swing.*;
import java.awt.*;

public class nNew extends JPanel {
    private static int Width=500;
    private static int Height=500;
    public nNew(){
        this.setPreferredSize(new Dimension(Width, Height));
    }
    @Override
    public void paintComponent(Graphics g){
        // Painting here
        g.setColor(Color.black);
        int x=0, y=0;
        for (int i=0; i<8; i++){
            g.drawLine(x,y,Width,y );
            y+=Height/7;
        }
        y = 0;
        for (int i=0; i<8; i++){
            g.drawLine(x,y,x,Height );
            x+=Width/7;
        }
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("nNew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new nNew());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
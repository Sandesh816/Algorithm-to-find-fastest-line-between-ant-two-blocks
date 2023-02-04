import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class nNew extends JPanel {
    private static int Width=700;
    private static int Height=700;
    public nNew(){
        this.setPreferredSize(new Dimension(Width, Height));
    }
    @Override
    public void paintComponent(Graphics G){
        // Painting here
        Graphics2D g = (Graphics2D) G;
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

        System.out.println("Please input the starting X-point of your box (Must be in 50s): ");
        Scanner X1 = new Scanner(System.in);
        int x1 = X1.nextInt();
        System.out.println("Please input the starting Y-point of your box (Must be in 50s): ");
        Scanner Y1 = new Scanner(System.in);
        int y1 = Y1.nextInt();
        System.out.println("Please input the final X-point of your box (Must be in 50s): ");
        Scanner X2 = new Scanner(System.in);
        int x2 = X2.nextInt();
        System.out.println("Please input the final Y-point of your box (Must be in 50s): ");
        Scanner Y2 = new Scanner(System.in);
        int y2 = Y2.nextInt();

        paintBoxes(x1,y1,g);
        paintBoxes(x2,y2,g);

        while (x1!=x2 || y1!=y2){
            x1 = values(x1,y1,x2,y2)[0];
            y1= values(x1,y1,x2,y2)[1];
            paintBoxes(x1,y1,g);
        }
    }
    public void paintBoxes(int x, int y, Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect(x-50, y-50, 100,100);
    }
    public static int[] values(int x1, int y1, int x2, int y2){
        int [] array = new int[2];
        if (x1==x2){array[0]=x1;}
        if (x2>x1){array[0]=x1+100;}
        if (x2<x1){array[0]=x1-100;}
        System.out.println("Done with X");
        if (y1==y2){array[1]=y1;}
        if (y2>y1){array[1]=y1+100;}
        if (y2<y1){array[1]=y1-100;}
        System.out.println("Done with Y");
        return array;
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

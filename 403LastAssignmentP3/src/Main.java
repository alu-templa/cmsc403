import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setLocation(((dimension.width - 500) / 2), ((dimension.height - 200) / 2));
        frame.setSize(500, 200);
        frame.setResizable(false);
        Container contentPane = frame.getContentPane();
        RaceTrack raceTrack = new RaceTrack();

        frame.setPreferredSize(new Dimension(500, 200));
        frame.pack();

        contentPane.add(raceTrack, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}

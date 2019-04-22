import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceTrack extends JPanel implements ActionListener {

    Car car1;
    Car car2;
    Car car3;

    private JButton start;
    private JButton pause;
    private JButton reset;

    Thread firstThread;
    Thread secondThread;
    Thread thirdThread;

    final Timer timer;
    boolean isRunning;

    public RaceTrack(){
        this.car1 = new Car(25, 50);
        this.car2 = new Car(25, 75);
        this.car3 = new Car(25, 100);

        timer = new Timer(50, null);
        this.isRunning = true;

        ActionListener startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!car1.isDriving()){
                    JOptionPane.showMessageDialog(car1, "First Car Wins!");
                    timer.stop();
                }
                else if(!car2.isDriving()){
                    JOptionPane.showMessageDialog(car2, "Second Car Wins!");
                    timer.stop();
                }
                else if(!car3.isDriving()){
                    JOptionPane.showMessageDialog(car3, "Third Car Wins!");
                    timer.stop();
                }
                else {
                    if(isRunning) {
                        firstThread.run();
                        secondThread.run();
                        thirdThread.run();
                        repaint();
                    }
                }
            }
        };

        timer.addActionListener(startListener);

        firstThread = new Thread(car1);
        secondThread = new Thread(car2);
        thirdThread = new Thread(car3);

        this.start = new JButton("Start");
        this.pause = new JButton("Pause");
        this.reset = new JButton("Reset");

        start.addActionListener(this);
        pause.addActionListener(this);
        reset.addActionListener(this);

        start.setActionCommand("Start");
        pause.setActionCommand("Pause");
        reset.setActionCommand("Reset");

        add(start);
        add(pause);
        add(reset);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(57, 60, 375, 12);
        g.fillRect(57, 85, 375, 12);
        g.fillRect(57, 110, 375, 12);

        car1.paintComponent(g);
        car2.paintComponent(g);
        car3.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if(action.equals("Start")){
            isRunning = true;
            if (!timer.isRunning()) {
                timer.start();
            }
        }else if(action.equals("Pause")) {
            isRunning = false;
        }else if(action.equals("Reset")) {
            isRunning = false;
            car1.xPosition = 25;
            car2.xPosition = 25;
            car3.xPosition = 25;
            repaint();
        }
    }
}

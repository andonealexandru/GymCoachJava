import javax.swing.*;

public class Main {
    static JFrame frame = new JFrame ("GymCoach");

    public static void changeCurrentPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.repaint();
        frame.revalidate();
    }

    public static void main (String[] args) {
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new FirstPagePanel());
        frame.pack();
        frame.setVisible (true);
    }
}
package Sygma.Component;

import javax.swing.*;
import java.awt.*;

public class PanelRound extends JPanel {

    private int cornerRadius = 50; // Radius for rounded corners

    public PanelRound() {
        super();
        setOpaque(false); // Makes the background transparent to apply custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable anti-aliasing for smoother corners

        // Set the background color
        g2.setColor(getBackground());

        // Draw rounded rectangle
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Optional: Draw a border for the panel
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }

    // Getter and setter for corner radius (optional)
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        PanelRound roundedPanel = new PanelRound();
        roundedPanel.setBackground(Color.LIGHT_GRAY); // Set background color for the panel
        frame.add(roundedPanel);

        frame.setVisible(true);
    }
}

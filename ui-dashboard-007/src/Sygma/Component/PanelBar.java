package Sygma.Component;

import javax.swing.*;
import java.awt.*;

public class PanelBar extends JPanel {

    private Color backgroundColor;
    private int cornerRadius = 15; // Default corner radius

    public PanelBar() {
        super();
        setOpaque(false); // Makes the background transparent so we can draw the rounded rectangle
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius); // Arc size for the rounded corners
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;

        // Set anti-aliasing for smoother edges
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);

        graphics.setColor(Color.decode("#C0C0C0"));
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Repaint the panel to reflect the changes
    }
}

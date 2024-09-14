package Sygma.Component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public Panel() {
        setOpaque(false);  // Ensures transparency for rounded corners
    }

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the background with rounded corners
        g2.setColor(getBackground());
        g2.fill(createRoundShape());

        g2.dispose();
    }

    private Area createRoundShape() {
        int width = getWidth();
        int height = getHeight();

        // Top-left corner rounding
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundTopLeft, roundTopLeft));
        
        // Top-right corner rounding
        area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundTopRight, roundTopRight)));
        
        // Bottom-left corner rounding
        area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundBottomLeft, roundBottomLeft)));
        
        // Bottom-right corner rounding
        area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundBottomRight, roundBottomRight)));
        
        return area;
    }
}

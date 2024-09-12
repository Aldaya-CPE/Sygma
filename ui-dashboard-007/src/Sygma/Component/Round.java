package Sygma.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Round extends JPanel {

    private Color backgroundColor;
    private int roundTopLeft = 50; // More rounded default for top-left corner
    private int roundTopRight = 50; // More rounded default for top-right corner
    private int roundBottomLeft = 50; // More rounded default for bottom-left corner
    private int roundBottomRight = 50; // More rounded default for bottom-right corner

    public Round() {
        super();
        setOpaque(false); // Makes the background transparent so we can draw the rounded rectangle
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        // Set anti-aliasing for smoother edges
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }

        // Create a rounded shape using individual corner radii
        Shape roundedShape = createRoundedShape(width, height);
        
        // Fill the rounded shape
        graphics.fill(roundedShape);

        // Draw outline of the rounded shape
        graphics.setColor(Color.decode("#C0C0C0"));
        graphics.draw(roundedShape);

        graphics.dispose();
    }

    // Create a rounded shape with individual corner radii
    private Shape createRoundedShape(int width, int height) {
        // Top-left corner
        Area area = new Area(new RoundRectangle2D.Double(0, 0, roundTopLeft * 2, roundTopLeft * 2, roundTopLeft, roundTopLeft));
        
        // Top-right corner
        area.add(new Area(new RoundRectangle2D.Double(width - roundTopRight * 2, 0, roundTopRight * 2, roundTopRight * 2, roundTopRight, roundTopRight)));
        
        // Bottom-left corner
        area.add(new Area(new RoundRectangle2D.Double(0, height - roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft * 2, roundBottomLeft, roundBottomLeft)));
        
        // Bottom-right corner
        area.add(new Area(new RoundRectangle2D.Double(width - roundBottomRight * 2, height - roundBottomRight * 2, roundBottomRight * 2, roundBottomRight * 2, roundBottomRight, roundBottomRight)));
        
        // Add rectangles to fill the gaps between corners
        area.add(new Area(new Rectangle2D.Double(roundTopLeft, 0, width - roundTopLeft - roundTopRight, roundTopLeft))); // Top rectangle
        area.add(new Area(new Rectangle2D.Double(roundBottomLeft, height - roundBottomLeft, width - roundBottomLeft - roundBottomRight, roundBottomLeft))); // Bottom rectangle
        area.add(new Area(new Rectangle2D.Double(0, roundTopLeft, roundTopLeft, height - roundTopLeft - roundBottomLeft))); // Left rectangle
        area.add(new Area(new Rectangle2D.Double(width - roundTopRight, roundTopRight, roundTopRight, height - roundTopRight - roundBottomRight))); // Right rectangle
        area.add(new Area(new Rectangle2D.Double(roundTopLeft, roundTopLeft, width - roundTopLeft - roundTopRight, height - roundTopLeft - roundBottomRight))); // Center rectangle

        return area;
    }

    // Getters and setters for the corner radii
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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }
}

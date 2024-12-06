package oopfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.JPasswordField;

public class RoundedPasswordField extends JPasswordField implements Serializable {

    private Color backgroundColor = Color.WHITE;
    private Color borderColor = Color.GRAY;
    private int radius = 15; // Default corner radius

    // No-argument constructor for NetBeans
    public RoundedPasswordField() {
        super();
        setOpaque(false); // Makes the background transparent for rounded corners
    }

    public RoundedPasswordField(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    // Getters and Setters for NetBeans Property Inspector
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background with rounded corners
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Draw obscured password text inside the rounded background
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded border
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

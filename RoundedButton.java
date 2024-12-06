package oopfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton implements Serializable {

    private Color backgroundColor = Color.WHITE;
    private Color borderColor = Color.GRAY;
    private Color hoverColor = new Color(179, 250, 160);
    private Color clickColor = new Color(152, 184, 144);
    private int radius = 20;

    private boolean isHovered = false;
    private boolean isClicked = false;

    // No-argument constructor for NetBeans
    public RoundedButton() {
        super();
        setOpaque(false); // Make the background transparent for rounded corners
        setFocusPainted(false); // Remove focus painting

        // Mouse listeners to change color on hover and click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isClicked = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isClicked = false;
                repaint();
            }
        });
    }

    // Getters and setters for the properties to use in NetBeans' Properties window
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

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        repaint();
    }

    public Color getClickColor() {
        return clickColor;
    }

    public void setClickColor(Color clickColor) {
        this.clickColor = clickColor;
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

        // Set the background color based on the button's state
        if (isClicked) {
            g2.setColor(clickColor);
        } else if (isHovered) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(backgroundColor);
        }

        // Draw rounded rectangle for the button background
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Draw rounded border
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No need for default border painting since custom border is drawn in paintComponent
    }
}

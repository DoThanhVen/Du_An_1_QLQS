/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClass;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import JavaClass.StatusType;

public class TableStatus extends JLabel {

    public StatusType getType() {
        return type;
    }

    public TableStatus() {
        setForeground(Color.WHITE);
    }

    private StatusType type;

    public void setType(StatusType type) {
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (type != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g;
            if (type == StatusType.PENDING) {
                g = new GradientPaint(0, 0, new Color(255, 153, 152), 0, getHeight(), new Color(255, 0, 0));
            } else {
                g = new GradientPaint(0, 0, new Color(20, 194, 15), 0, getHeight(), Color.GREEN);
            }
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
        }
        super.paintComponent(grphcs);
    }
}


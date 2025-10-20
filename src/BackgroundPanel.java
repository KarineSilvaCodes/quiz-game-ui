package src;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    private Color overlayColor = new Color(60, 0, 120, 90); // azul-roxo translúcido

    public BackgroundPanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            // desenha a imagem de fundo
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // aplica o filtro translúcido
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(overlayColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }

    // opcional: mudar a cor do filtro dinamicamente
    public void setOverlayColor(Color color) {
        this.overlayColor = color;
        repaint();
    }
}

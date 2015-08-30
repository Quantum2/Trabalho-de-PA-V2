/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
class JanelaPrincipal extends JPanel {

    private Jogo jogo;
    private FrameLayout frameLayout;
    private JButton b1 = new JButton("Novo Jogo"), b2 = new JButton("Carregar Jogo"), b3 = new JButton("Sair");

    private JPanel painelFundo = new JPanel(new BorderLayout()) {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            try {
                Image iconeDaJanela = ImageIO.read(new File("./imagens/background.jpg"));
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(iconeDaJanela, 0, 0, this.getWidth(), this.getHeight(), null);
                g2d.dispose();
            } catch (IOException excepcao) {
                System.out.println("Erro na imagem!" + excepcao);
            }
        }
    };

    public JanelaPrincipal(Jogo jogo, FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
        this.jogo = jogo;
        addComponents();
        repaint();
        validate();
    }

    private void addComponents() {
        
    }

    void setJogo(Jogo jogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public JButton getB3() {
        return b3;
    }

    public void setB3(JButton b3) {
        this.b3 = b3;
    }
}
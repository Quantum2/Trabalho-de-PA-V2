/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel(), p8 = new JPanel(), p9 = new JPanel(), p0 = new JPanel();

        JPanel p4 = new JPanel(), p5 = new JPanel(), p6 = new JPanel(), p7 = new JPanel();

        JPanel p10 = new JPanel(), p11 = new JPanel(), p12 = new JPanel(), pLabel = new JPanel();

        JLabel titulo = new JLabel();

        this.add(painelFundo, new FlowLayout());
        p0.setOpaque(false);
        p1.setOpaque(false);
        p8.setOpaque(false);
        p2.setOpaque(false);
        titulo.setText("Milky Way Express");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 100));
        p2.add(titulo);
        p3.setOpaque(false);
        painelFundo.setOpaque(false);
        painelFundo.add(p1, BorderLayout.CENTER);
        painelFundo.add(p0, BorderLayout.WEST);
        painelFundo.add(p8, BorderLayout.EAST);
        painelFundo.add(p2, BorderLayout.NORTH);
        painelFundo.add(p3, BorderLayout.SOUTH);
        painelFundo.setPreferredSize(new Dimension(1370, 734));

        p2.setPreferredSize(new Dimension(150, 250));
        p0.setPreferredSize(new Dimension(550, 50));
        p8.setLayout(new GridLayout(10, 1));

        p1.setLayout(new GridLayout(13, 1));
        p1.add(p4, new FlowLayout());
        p1.add(p6, new FlowLayout());
        p1.add(p7, new FlowLayout());

        p4.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p4.add(b1);
        p6.add(b2);
        p7.add(b3);
        b1.setPreferredSize(new Dimension(150, 25));
        b2.setPreferredSize(new Dimension(150, 25));
        b3.setPreferredSize(new Dimension(100, 25));
        b3.addActionListener(new ListenerSair());

        p8.add(pLabel, new FlowLayout());
        p8.add(p11, new FlowLayout());
        p8.add(p10, new FlowLayout());
        p8.add(p12, new FlowLayout());
        p8.add(p9, new FlowLayout());

        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);
        pLabel.setOpaque(false);

        p8.setPreferredSize(new Dimension(500, 50));

        this.add(painelFundo);
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public JPanel getPainelFundo() {
        return painelFundo;
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

    class ListenerSair implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Sair", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}

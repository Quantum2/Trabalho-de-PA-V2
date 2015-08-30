/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
class PainelJogo extends JPanel implements Observer {

    Jogo jogo;
    int t=0;
    private JButton Upgrade = new JButton("Upgrade");
    private JButton Compra = new JButton("Compra");
    private JButton Vender = new JButton("Vender");
    private JButton Opcao_1 = new JButton("Opcao 1");
    private JButton Opcao_2 = new JButton("Opcao 2");
    private JButton Opcao_3 = new JButton("Opcao 3");
    private JButton Opcao_4 = new JButton("Opcao 4");
    private JButton Guardar = new JButton("Guardar Jogo");
    private JButton turno = new JButton("Terminar Turno");
    private JButton Desistir = new JButton("Desistir");
    private JButton Recomecar = new JButton("Recomecar");
    JPanel fundo = new JPanel(new BorderLayout()), oeste = new JPanel();
    JPanel este = new JPanel(new BorderLayout());
    JPanel norte = new JPanel(new BorderLayout());
    JPanel CartasTab = new JPanel(), CartasTab2 = new JPanel(), boxCartas = new JPanel();
    JPanel estecimo = new JPanel();
    JPanel estemeio = new JPanel();
    JPanel esteSul = new JPanel();
    JLabel texto = new JLabel("                               ");
    JLabel texto1 = new JLabel("                               ");
    JLabel texto2 = new JLabel("                               ");
    JLabel texto3 = new JLabel("                               ");
    JLabel texto4 = new JLabel("                               ");
    JLabel texto5 = new JLabel("                               ");
    JLabel esptk1 = new JLabel("       ");
    JLabel esptk2 = new JLabel("       ");
    JLabel esptk3 = new JLabel("       ");
    JLabel cartasBaralho;
    JLabel cartasDescartadas;
    JLabel l1 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel no = new JLabel(), jogador = new JLabel();
    CardLayout cardManager;
    JPanel game;
    JPanel norteoeste = new JPanel(), nortecentro = new JPanel();
    JLabel dados = new JLabel();
    
      private JPanel painelFundo = new JPanel(new BorderLayout()) {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            try {
                Image iconeDaJanela = ImageIO.read(new File("./imagens/background.jpg"));
                //g.drawImage(iconeDaJanela, 0, 0, this); 
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(iconeDaJanela, 0, 0, this.getWidth(), this.getHeight(), null);
                g2d.dispose();
            } catch (IOException excepcao) {
                System.out.println("Erro na imagem!" + excepcao);
            }
        }
    };

    public PainelJogo(Jogo jogo, CardLayout cardManager, JPanel game) {
        this.cardManager = cardManager;
        this.game = game;
        System.out.println("entrei no jogo");
        this.jogo = jogo;

        jogo.addObserver(this);
        addComponents();

        this.add(painelFundo);
        repaint();
        validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

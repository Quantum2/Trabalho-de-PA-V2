/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import iu.texto.Texto;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logicaJogo.EsperaMovimento;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
public class FrameLayout extends JFrame{
    private Container cp;
    private JPanel game;
    private Jogo jogo;
    private JanelaPrincipal janelaPrincipal;
    private CardLayout cardManager;
    private PainelJogo painelJogo;
    private Texto t;
    
    public FrameLayout(/*Jogo jogo*/){
        super("Trabalho de PA");
	setVisible(true);
	this.setSize(1370, 734);
        this.setMinimumSize(new Dimension(1370, 734));
        ImageIcon img = new ImageIcon("./imagens/background.jpg");
        this.setIconImage(img.getImage());
        cp = getContentPane();
        criarObjGraf();
        disporVista();
        cardManager.show(game, "menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
        validate();   
    }

    protected void criarObjGraf() {
        game = new JPanel();
        janelaPrincipal = new JanelaPrincipal(jogo,this);
    }

    protected void disporVista() {
        cardManager = new CardLayout();
        cp.add(game, BorderLayout.CENTER);
        game.setLayout(cardManager);
        
        game.add(janelaPrincipal,"menu");
        game.addMouseListener(new ListenerClique());
        janelaPrincipal.getB1().addActionListener(new ListenerJogo());
        janelaPrincipal.getB2().addActionListener(new ListenerCarregarJogo());
        this.add(game);
    }

    class ListenerClique extends MouseAdapter {

        private boolean isLeftButton(MouseEvent event) {
            return event.getButton() == MouseEvent.BUTTON1;
        }

        private boolean isRightButton(MouseEvent event) {
            return event.getButton() == MouseEvent.BUTTON3;
        }

    }
    
    class ListenerCarregarJogo implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            t=new Texto(jogo);
            t.carregar();
            jogo=t.getJ();
            jogo.setEstado(new EsperaMovimento(jogo));
            painelJogo = new PainelJogo(jogo,cardManager,game);
            janelaPrincipal.setJogo(jogo);
            game.add(painelJogo,"jogo");
            cardManager.show(game, "jogo");
        }
    }

    class ListenerJogo implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent e) {
            jogo = new Jogo();
            jogo.fazerMapa();
            jogo.explora();
            jogo.Repoe();
            jogo.setEstado(new EsperaMovimento(jogo));
            painelJogo = new PainelJogo(jogo, cardManager, game);
            janelaPrincipal.setJogo(jogo);
            game.add(painelJogo, "jogo");
            cardManager.show(game, "jogo");
        }

    }
}

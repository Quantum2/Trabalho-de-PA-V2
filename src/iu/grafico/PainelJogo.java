/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico;

import iu.texto.Texto;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logicaJogo.EsperaCompra;
import logicaJogo.EsperaInicio;
import logicaJogo.EsperaMovimento;
import logicaJogo.EsperaVenda;
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

    void addComponents() {
        Upgrade.setText("Upgrade");
        Compra.setText("Compra");
        Vender.setText("Vender");
        Opcao_1.setText("Opcao 1");
        Opcao_2.setText("Opcao 2");
        Opcao_3.setText("Opcao 3");
        Opcao_4.setText("Opcao 4");
        Guardar.setText("Guardar Jogo");
        turno.setText("Terminar Turno");
        Desistir.setText("Desistir");

        l1.setText("O teu dinheiro:" + jogo.getJogador().getMoney());
        l2.setText("A tua carga:" + jogo.getJogador().getNave().getCargo().get(0).getNome() + "/" + jogo.getJogador().getNave().getCargo().get(1).getNome() + "/" + jogo.getJogador().getNave().getCargo().get(2).getNome());
        if (jogo.getEstado() instanceof EsperaMovimento) {
            turno.setText("Fase Movimento");
        }

        painelFundo.setPreferredSize(new Dimension(1370, 734));
        fundo.setPreferredSize(new Dimension(150, 100));
        este.setPreferredSize(new Dimension(330, 300));

        painelFundo.add(fundo, BorderLayout.SOUTH);
        fundo.setLayout(new FlowLayout());
        fundo.setOpaque(false);
        painelFundo.add(este, BorderLayout.EAST);
        painelFundo.add(norte, BorderLayout.NORTH);
        norte.setLayout(new FlowLayout());
        norte.setOpaque(false);
        norte.add(norteoeste, BorderLayout.WEST);
        norte.add(nortecentro, BorderLayout.CENTER);
        norteoeste.setLayout(new FlowLayout());
        norteoeste.setOpaque(false);
        norteoeste.add(dados);
        dados.setForeground(Color.white);
        dados.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        nortecentro.setLayout(new FlowLayout());
        nortecentro.setOpaque(false);

        painelFundo.add(boxCartas, BorderLayout.CENTER);
        painelFundo.add(oeste, BorderLayout.WEST);
        oeste.setPreferredSize(new Dimension(75, 250));
        oeste.setOpaque(false);
        boxCartas.setOpaque(false);

        este.setLayout(new BorderLayout());
        este.setOpaque(false);
        este.add(estecimo, BorderLayout.CENTER);
        este.add(esteSul, BorderLayout.SOUTH);
        esteSul.setPreferredSize(new Dimension(330, 300));
        esteSul.setOpaque(false);
        estecimo.setMaximumSize(new Dimension(330, 250));
        estecimo.setPreferredSize(new Dimension(330, 250));
        estecimo.setMinimumSize(new Dimension(330, 250));
        estecimo.setOpaque(false);

        Opcao_1.setVisible(false);
        Opcao_2.setVisible(false);
        Opcao_3.setVisible(false);
        Opcao_4.setVisible(false);
        Upgrade.setVisible(false);
        Compra.setVisible(false);
        Vender.setVisible(false);
        Recomecar.setVisible(false);
        if (jogo.getEstado() instanceof EsperaInicio) {

        } else {
            if (jogo.getEstado() instanceof EsperaVenda) {
                Vender.setVisible(true);
                turno.setText("Fase Venda");
                l3.setText("Precos");
                if ("P".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                    l4.setText("Azul-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(1) + "Vermelho-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(2) + "Preto" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(3));
                }
                if ("X".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                    l4.setText("Azul-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(1) + "Vermelho-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(2) + "Preto" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(3));
                }
                Vender.addMouseListener(new ListenerVende());
                fundo.add(Vender);
                fundo.add(Opcao_1);
                fundo.add(Opcao_2);
                if (jogo.getJogador().getNave().getCargo().get(2).getNome() == "Cinzento") {
                    Opcao_3.addMouseListener(null);
                    fundo.add(Opcao_3);
                }
            } else {
                if (jogo.getEstado() instanceof EsperaCompra) {
                    Upgrade.setVisible(true);
                    Compra.setVisible(true);
                    Recomecar.setVisible(true);
                    turno.setText("Fase Compra");
                    l3.setText("Precos:");
                    if ("P".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                        l4.setText("Azul-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(1) + "Vermelho-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(2) + "Preto" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(3));
                    }
                    if ("X".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                        l4.setText("Azul-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(1) + "Vermelho-" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(2) + "Preto" + jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getCusto().get(3));
                    }
                    if (jogo.getJogador().getNave().getPower() != 5 && "Cinzento".equals(jogo.getJogador().getNave().getCargo().get(2).getNome())) {
                        Upgrade.addMouseListener(new ListenerUpgrade());
                    } else {
                        Upgrade.setVisible(false);
                    }
                    Compra.addMouseListener(new ListenerCompra());
                    fundo.add(Upgrade);
                    fundo.add(Compra);
                    fundo.add(Opcao_1);
                    fundo.add(Opcao_2);
                    fundo.add(Opcao_3);
                    fundo.add(Opcao_4);
                }
            }

        }

        nortecentro.add(Guardar);
        Guardar.addActionListener(new ListenerGuardarJogo());
        nortecentro.add(turno);
        nortecentro.add(Desistir);
        nortecentro.add(Recomecar);

        JPanel linha1 = new JPanel();
        linha1.setLayout(new FlowLayout());
        linha1.add(l1);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1.setOpaque(true);
        l1.setBackground(new Color(70, 152, 103));
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        linha1.setOpaque(false);
        linha1.setAlignmentX(Component.CENTER_ALIGNMENT);
        estecimo.add(linha1);

        JPanel linha2 = new JPanel();
        linha2.setLayout(new FlowLayout());
        linha2.add(l2);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setLocation(0, 0);
        l2.setOpaque(true);
        l2.setBackground(new Color(70, 152, 103));
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        linha2.setMaximumSize(new Dimension(240, 75));
        linha2.setOpaque(false);
        estecimo.add(linha2);

        JPanel linha3 = new JPanel();
        linha3.setLayout(new FlowLayout());
        linha3.add(l3);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setLocation(0, 0);
        l3.setOpaque(true);
        l3.setBackground(new Color(70, 152, 103));
        l3.setForeground(Color.white);
        l3.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        linha3.setMaximumSize(new Dimension(240, 75));
        linha3.setOpaque(false);
        estecimo.add(linha3);

        JPanel linha4 = new JPanel();
        linha4.setLayout(new FlowLayout());
        linha4.add(l4);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4.setLocation(0, 0);
        l4.setOpaque(true);
        l4.setBackground(new Color(70, 152, 103));
        l4.setForeground(Color.white);
        l4.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        linha4.setMaximumSize(new Dimension(240, 75));
        linha4.setOpaque(false);
        estecimo.add(linha4);

        JPanel linha5 = new JPanel();
        linha5.setLayout(new FlowLayout());
        linha5.add(l5);
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5.setLocation(0, 0);
        l5.setOpaque(true);
        l5.setBackground(new Color(70, 152, 103));
        l5.setForeground(Color.white);
        l5.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        linha5.setMaximumSize(new Dimension(240, 75));
        linha5.setOpaque(false);
        estecimo.add(linha5);

        texto.setMinimumSize(new Dimension(180, 50));
        texto.setPreferredSize(new Dimension(150, 25));
        texto.setMaximumSize(new Dimension(150, 25));

        Guardar.setMinimumSize(new Dimension(150, 25));
        Guardar.setPreferredSize(new Dimension(150, 25));
        Guardar.setMaximumSize(new Dimension(150, 25));

        turno.setMinimumSize(new Dimension(150, 25));
        turno.setPreferredSize(new Dimension(150, 25));
        turno.setMaximumSize(new Dimension(150, 25));
        if (t == 0) {
            turno.addMouseListener(new ListenerTerminarTurno());
            t++;
        }

        Desistir.setMinimumSize(new Dimension(150, 25));
        Desistir.setPreferredSize(new Dimension(150, 25));
        Desistir.setMaximumSize(new Dimension(150, 25));
        Desistir.addMouseListener(new ListenerDesistirJogo());

        Recomecar.setMinimumSize(new Dimension(150, 25));
        Recomecar.setPreferredSize(new Dimension(150, 25));
        Recomecar.setMaximumSize(new Dimension(150, 25));
        Recomecar.addActionListener(new ListenerRecomecar());

        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        Guardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        turno.setAlignmentX(Component.CENTER_ALIGNMENT);
        Desistir.setAlignmentX(Component.CENTER_ALIGNMENT);
        Recomecar.setAlignmentX(Component.CENTER_ALIGNMENT);

        mapa();
    }

    void mapa() {
        int conta = 0;
        boxCartas.setLayout(new GridLayout(7, 9));
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if ("W".equals(jogo.getMapa()[i][j].getTexto())) {
                    if (jogo.getMapa()[i][j].getCheck() == false) {
                        boxCartas.add(new Celula("./imagens/espacoporexplorar.png"));
                    } else {
                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i) {
                            Celula cl = new Celula("./imagens/Wormhole.png");
                            Celula nave = new Celula("./imagens/nave.png");
                            nave.setPreferredSize(new Dimension(45, 35));
                            cl.add(nave);
                            boxCartas.add(cl);
                        } else {
                            Celula cl = new Celula("./imagens/Wormhole.png");
                            if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i + 1) {
                                //cl.position = 7;
                                cl.position = 8;

                            } else {

                                if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i) {

                                    //cl.position = 2;
                                    cl.position = 4;

                                } else {

                                    if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                        //cl.position = 8;
                                        cl.position = 6;

                                    } else {

                                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i + 1) {

                                            cl.position = 2;//

                                        } else {

                                            if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i - 1) {

                                                //cl.position = 4;
                                                cl.position = 1;

                                            } else {

                                                if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                                    //cl.position = 5;
                                                    cl.position = 7;

                                                } else {

                                                    if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i) {

                                                        //cl.position = 1;
                                                        cl.position = 3;

                                                    } else {

                                                        if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                                            //cl.position = 6;
                                                            cl.position = 5;

                                                        } else {
                                                            cl.position = 9;
                                                            conta++;
                                                        }
                                                    }

                                                }

                                            }

                                        }

                                    }

                                }
                            }
                            cl.addMouseListener(new ListenerMovimento(cl.position, conta));
                            boxCartas.add(cl);
                        }
                    }
                }
                if ("_".equals(jogo.getMapa()[i][j].getTexto())) {
                    if (jogo.getMapa()[i][j].getCheck() == false) {

                        boxCartas.add(new Celula("./imagens/espacoporexplorar.png"));
                    } else {
                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i) {
                            Celula cl = new Celula("./imagens/EspacoExplorado.png");
                            Celula nave = new Celula("./imagens/nave.png");
                            nave.setPreferredSize(new Dimension(45, 35));
                            cl.add(nave);
                            boxCartas.add(cl);
                        } else {

                            Celula cl = new Celula("./imagens/EspacoExplorado.png");
                            if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i + 1) {
                                //cl.position = 7;
                                cl.position = 8;

                            } else {

                                if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i) {

                                    cl.position = 4;

                                } else {

                                    if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                        cl.position = 6;

                                    } else {

                                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i + 1) {

                                            cl.position = 2;

                                        } else {

                                            if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i - 1) {

                                                cl.position = 1;

                                            } else {

                                                if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                                    cl.position = 7;

                                                } else {

                                                    if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i) {

                                                        cl.position = 3;

                                                    } else {

                                                        if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                                            cl.position = 5;

                                                        }
                                                    }

                                                }

                                            }

                                        }

                                    }

                                }
                            }
                            cl.addMouseListener(new ListenerMovimento(cl.position, 0));
                            boxCartas.add(cl);
                        }
                    }
                }
                if ("P".equals(jogo.getMapa()[i][j].getTexto())) {
                    if (jogo.getMapa()[i][j].getCheck() == false) {
                        boxCartas.add(new Celula("./imagens/espacoporexplorar.png"));
                    } else {
                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i) {
                            Celula cl = new Celula("./imagens/Arrakis.png");
                            Celula nave = new Celula("./imagens/nave.png");
                            nave.setPreferredSize(new Dimension(45, 35));
                            cl.add(nave);
                            boxCartas.add(cl);
                        } else {
                            Celula cl = new Celula("./imagens/Arrakis.png");
                            if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                cl.position = 8;

                            } else {

                                if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i) {

                                    cl.position = 4;

                                } else {

                                    if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                        cl.position = 6;

                                    } else {

                                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i + 1) {

                                            cl.position = 2;

                                        } else {

                                            if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i - 1) {

                                                cl.position = 1;

                                            } else {

                                                if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                                    cl.position = 7;

                                                } else {

                                                    if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i) {

                                                        cl.position = 3;

                                                    } else {

                                                        if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                                            //cl.position = 6;
                                                            cl.position = 5;

                                                        }
                                                    }

                                                }

                                            }

                                        }

                                    }

                                }
                            }
                            cl.addMouseListener(new ListenerMovimento(cl.position, 0));
                            boxCartas.add(cl);
                        }
                    }
                }
                if ("X".equals(jogo.getMapa()[i][j].getTexto())) {
                    if (jogo.getMapa()[i][j].getCheck() == false) {
                        boxCartas.add(new Celula("./imagens/espacoporexplorar.png"));
                    } else {
                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i) {
                            Celula cl = new Celula("./imagens/Asperta.png");
                            Celula nave = new Celula("./imagens/nave.png");
                            nave.setPreferredSize(new Dimension(45, 35));
                            cl.add(nave);
                            boxCartas.add(cl);
                        } else {
                            Celula cl = new Celula("./imagens/Asperta.png");
                            if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                cl.position = 8;

                            } else {

                                if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i) {

                                    cl.position = 4;

                                } else {

                                    if (jogo.getJogador().getNave().getX() == j + 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                        cl.position = 6;

                                    } else {

                                        if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i + 1) {

                                            cl.position = 2;

                                        } else {

                                            if (jogo.getJogador().getNave().getX() == j && jogo.getJogador().getNave().getY() == i - 1) {

                                                cl.position = 1;

                                            } else {

                                                if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i + 1) {

                                                    cl.position = 7;

                                                } else {

                                                    if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i) {

                                                        cl.position = 3;

                                                    } else {

                                                        if (jogo.getJogador().getNave().getX() == j - 1 && jogo.getJogador().getNave().getY() == i - 1) {

                                                            cl.position = 5;

                                                        }
                                                    }

                                                }

                                            }

                                        }

                                    }

                                }
                            }
                            cl.addMouseListener(new ListenerMovimento(cl.position, 0));
                            boxCartas.add(cl);
                        }
                    }
                }
                if (" ".equals(jogo.getMapa()[i][j].getTexto())) {
                    boxCartas.add(new Celula("./imagens/espacoporexplorar.png"));
                }
                boxCartas.revalidate();
                boxCartas.repaint();
            }
        }

    }

    class Celula extends JPanel {

        int position = 0;
        private String path;
        private Image img;

        public Celula(String path) {
            this.path = path;
            img = (new Imagem(path)).createImage();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        public void setCelula(String path) {
            this.path = path;
        }
    }

    public class Imagem {

        private String path;

        public Imagem(String path) {
            this.path = path;
        }

        protected ImageIcon createImageIcon() {
            ClassLoader cl = this.getClass().getClassLoader();
            java.net.URL imgURL = cl.getResource(path);
            if (imgURL == null) {
                return new ImageIcon(path);
            } else {
                System.out.println(" Nao encontrou o ficheiro: " + path);
                return null;
            }
        }

        protected Image createImage() {
            return createImageIcon().getImage();
        }
    }

    class ListenerDesistirJogo extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent evt) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja mesmo desistir?", "Desistir", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                cardManager.show(game, "final");
                exit(0);
            }
        }
    }

    class ListenerTerminarTurno extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            if ("P".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto()) || "X".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                jogo.setEstado(jogo.getEstado().fimEstado());
                boxCartas.removeAll();
                estecimo.removeAll();
                addComponents();
                System.out.println(jogo.getEstado());
            }
        }
    }
    
    class ListenerRecomecar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jogo.getEstado() instanceof EsperaCompra) {
                jogo = jogo.getEstado().Recomeca().J;
                jogo.fazerMapa();
                jogo.explora();
                jogo.Repoe();
                jogo.setEstado(new EsperaMovimento(jogo));
                boxCartas.removeAll();
                estecimo.removeAll();
                addComponents();
            }
        }
    }

    class ListenerGuardarJogo implements ActionListener { //listener do botão vender 

        @Override
        public void actionPerformed(ActionEvent e) {
            Texto t = new Texto(jogo);
            t.gravar();
            Guardar.setText("Guardado");
        }
    }

    class ListenerUpgrade extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            if (jogo.getEstado() instanceof EsperaCompra) {
                if (jogo.getJogador().getNave().getPower() != 5) {
                    Upgrade.setVisible(false);
                    Opcao_1.setVisible(true);
                    Opcao_1.setText("Forca");
                    Opcao_1.addMouseListener(new ListenerOpcaoUpgrade(1));
                }
                if (!"Cinzento".equals(jogo.getJogador().getNave().getCargo().get(2).getNome())) {
                    Upgrade.setVisible(false);
                    Opcao_2.setVisible(true);
                    Opcao_2.setText("Carga");
                    Opcao_2.addMouseListener(new ListenerOpcaoUpgrade(2));
                }
            }
        }
    }

    class ListenerOpcaoUpgrade extends MouseAdapter {

        int op;

        public ListenerOpcaoUpgrade(int op) {
            this.op = op;

        }

        @Override
        public void mouseClicked(MouseEvent event) {
            jogo = jogo.Upgrade(op);
            boxCartas.removeAll();
            estecimo.removeAll();
            addComponents();
        }
    }

    class ListenerVende extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            if (jogo.getEstado() instanceof EsperaVenda) {
                Opcao_1.setVisible(true);
                Opcao_2.setVisible(true);
                Opcao_1.setText(jogo.getJogador().getNave().getCargo().get(0).getNome());
                Opcao_2.setText(jogo.getJogador().getNave().getCargo().get(1).getNome());
                Opcao_1.addMouseListener(new ListenerOpcaoVende(0));
                Opcao_2.addMouseListener(new ListenerOpcaoVende(1));
                if (jogo.getJogador().getNave().getCargo().get(2).getNome() == "Cinzento") {
                    Opcao_3.setVisible(true);
                    Opcao_3.setText(jogo.getJogador().getNave().getCargo().get(2).getNome());
                    Opcao_1.addMouseListener(new ListenerOpcaoVende(2));
                }
                Vender.setVisible(false);
            }
        }
    }

    class ListenerCompra extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            if (jogo.getEstado() instanceof EsperaCompra) {
                Opcao_1.setVisible(true);
                Opcao_2.setVisible(true);
                Opcao_1.setText(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getRecursos().get(0).getNome());
                Opcao_2.setText(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getRecursos().get(1).getNome());
                Opcao_1.addMouseListener(new ListenerOpcaoCompra(0));
                Opcao_2.addMouseListener(new ListenerOpcaoCompra(1));
                Compra.setVisible(false);
                Upgrade.setVisible(false);
            }
            if (jogo.getEstado().ganha() == 2) {
                boxCartas.removeAll();
                estecimo.removeAll();
                JLabel ganha = new JLabel();
                ganha.setText("Ganhou !");
                ganha.setForeground(Color.white);
                ganha.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 60));
                boxCartas.add(ganha);
            } else {
                if (jogo.getEstado().ganha() == 1) {
                    boxCartas.removeAll();
                    estecimo.removeAll();
                    JLabel ganha = new JLabel();
                    ganha.setText("Perdeu");
                    ganha.setForeground(Color.white);
                    ganha.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 60));
                    boxCartas.add(ganha);
                }
            }
        }
    }

    class ListenerOpcaoVende extends MouseAdapter {

        int op;

        public ListenerOpcaoVende(int op) {
            this.op = op;

        }

        @Override
        public void mouseClicked(MouseEvent event) {
            jogo = jogo.Vende(op);
            boxCartas.removeAll();
            estecimo.removeAll();
            addComponents();
        }
    }

    class ListenerOpcaoCompra extends MouseAdapter {

        int op;

        public ListenerOpcaoCompra(int op) {
            this.op = op;

        }

        @Override
        public void mouseClicked(MouseEvent event) {
            jogo = jogo.Compra(op);
            boxCartas.removeAll();
            estecimo.removeAll();
            addComponents();
        }
    }

    class ListenerMovimento extends MouseAdapter {

        int position;
        int conta;
        ArrayList<Integer> pirTexto=new ArrayList();
        ArrayList<Integer> pirTexto2=new ArrayList();

        public ListenerMovimento(int pos, int cont) {
            this.position = pos;
            this.conta = cont;
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            if (jogo.getEstado() instanceof EsperaMovimento) {
                jogo = jogo.Movimento(position, conta);
                boxCartas.removeAll();
                estecimo.removeAll();
                pirTexto.addAll(jogo.explora());
                pirTexto2.addAll(jogo.Repoe());
                if (pirTexto.get(0) != -1) {
                    l5.setText("Ataque piratas P1:" + pirTexto2.get(0) + " P2:" + pirTexto2.get(1));
                }
                if ("P".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                    jogo.setEstado(jogo.getEstado().fimEstado());
                }
                if ("X".equals(jogo.getMapa()[jogo.getJogador().getNave().getY()][jogo.getJogador().getNave().getX()].getTexto())) {
                    jogo.setEstado(jogo.getEstado().fimEstado());
                    if (pirTexto2.get(0) != -1) {
                        l5.setText("Ataque piratas P1:" + pirTexto.get(0) + " P2:" + pirTexto.get(1));
                    }
                }
                addComponents();
            }
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }

    public JPanel getPainelFundo() {
        return painelFundo;
    }
}

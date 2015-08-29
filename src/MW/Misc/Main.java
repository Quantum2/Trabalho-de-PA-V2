package MW.Misc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import iu.grafico.FrameLayout;
import iu.texto.Texto;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.Scanner;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
public class Main implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x;
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Modo de texto\n2 - Modo gráfico\n");

        do {
            x = sc.nextInt();
        } while (x < 0 && x > 2);

        switch (x) {
            case 1:
                Texto gestorText = new Texto(new Jogo());
                gestorText.TJogar();
                break;
            case 2:
                FrameLayout frameLayout = new FrameLayout(/*new Jogo()*/);
                break;
            case 0:
                exit(0);
        }

    }
}

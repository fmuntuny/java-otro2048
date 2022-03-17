package com.nibblersystems.otro2048.gui;

import com.nibblersystems.otro2048.controler.Cuadrado;
import com.nibblersystems.otro2048.controler.Otro2048;
import com.nibblersystems.otro2048.controler.SpecCuadrado;
import com.nibblersystems.otro2048.controler.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrmTablero extends JFrame implements KeyListener, ActionListener {


    private JPanel JPHeader = new JPanel();
    private JPanel JPTablero = new JPanel();
    private JLabel lblPuntos = new JLabel("<html><center>Puntos: 0   Movidas: 0</center></html>");
    private Tablero tablero = new Tablero();

    public FrmTablero(Tablero tablero) {
        super("Otro 2048");
        this.tablero = tablero;
        ImageIcon icono = new ImageIcon("/images/Icono2048.ico");
        this.setIconImage(icono.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(466, 564);
        this.setResizable(false);

        JPHeader.setBackground(new Color(255, 200, 120));
        JPTablero.setBackground(new Color(255, 230, 200));
        JPHeader.setBounds(0, 0, 450, 75);
        JPTablero.setBounds(0, 75, 450, 450);
        lblPuntos.setFont(new Font("MV Boli", Font.BOLD, 26));
        JPHeader.add(lblPuntos);
        JPTablero.setLayout(new GridLayout(4, 4));
        this.setLayout(null);
        this.add(JPHeader);
        this.add(JPTablero);
        this.actualizaFrmTablero(tablero.getArrCuadrados());
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public JLabel formateoJlabel(Cuadrado cuadrado) {
        int index=0;
        switch (cuadrado.getValorCuadrado()){
            case("0"):
                index = 0;
                break;
            case("2"):
                index =1;
                break;
            case("4"):
                index =2;
                break;
            case("8"):
                index =3;
                break;
            case("16"):
                index =4;
                break;
            case("32"):
                index =5;
                break;
            case("64"):
                index =6;
                break;
            case("128"):
                index =7;
                break;
            case("256"):
                index =8;
                break;
            case("512"):
                index =9;
                break;
            case("1024"):
                index =10;
                break;
            case("2048"):
                index =11;
                break;
        }
        cuadrado.setText(cuadrado.getValorCuadrado());
        SpecCuadrado[] spec = SpecCuadrado.values();
        cuadrado.setForeground(spec[index].getColorFuente());
        cuadrado.setFont(new Font("MV Boli", Font.BOLD, 25));
        cuadrado.setBackground(spec[index].getColorFondo());
        cuadrado.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        cuadrado.setOpaque(true);
        cuadrado.setHorizontalAlignment(SwingConstants.CENTER);
        cuadrado.setVerticalAlignment(SwingConstants.CENTER);
        return cuadrado;
    }

    public void comenzarNuevoJuego(){
        tablero.getNewTablero();
    }

    public void actualizaFrmTablero(Cuadrado[][] arrCuadrado) {
        JPTablero.removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JPTablero.add(this.formateoJlabel(new Cuadrado(arrCuadrado[i][j].getValorCuadrado())));
                JPTablero.validate();
                JPTablero.repaint();
            }
        }
        this.lblPuntos.setText("<html><center>Puntos: " + tablero.getPuntos() + "   Movidas: " + tablero.getMovidas()+ "</center></html>");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (38): {//ARRIBA
                this.tablero.moverArriba();
                break;
            }
            case (40): {//ABAJO
                this.tablero.moverAbajo();
                break;
            }
            case (39): {//DERECHA
                this.tablero.moverDerecha();
                break;
            }
            case (37): {//IZQUIERDA
                this.tablero.moverIzquierda();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

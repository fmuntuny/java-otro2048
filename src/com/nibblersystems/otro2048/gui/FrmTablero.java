package com.nibblersystems.otro2048.gui;

import com.nibblersystems.otro2048.controler.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrmTablero extends JFrame implements KeyListener, ActionListener {

    private JLabel i0j0;
    private JLabel i0j1;
    private JLabel i0j2;
    private JLabel i0j3;
    private JLabel i1j0;
    private JLabel i1j1;
    private JLabel i1j2;
    private JLabel i1j3;
    private JLabel i2j0;
    private JLabel i2j1;
    private JLabel i2j2;
    private JLabel i2j3;
    private JLabel i3j0;
    private JLabel i3j1;
    private JLabel i3j2;
    private JLabel i3j3;
    private JPanel JPTablero;
    private JLabel LblPuntos;
    private JLabel Puntos;
    private JLabel LblMovidas;
    private JLabel Movidas;
    private static Tablero tableroForm = new Tablero();

    public FrmTablero(Tablero tablero) {
        super("Otro 2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(null);
        tableroForm = tablero;
        setContentPane(JPTablero);
        this.actualizaFrmTablero(tableroForm);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public void actualizaFrmTablero(Tablero tablero) {
        i0j0.setText(tablero.getArrCuadrados()[0][0].getValorCuadrado());
        if (tablero.getArrCuadrados()[0][0].getValorCuadrado().equals("0")) {
            i0j0.setForeground(new Color(0, 0, 0, 1));
        } else {
            i0j0.setForeground(Color.darkGray);
        }
        i0j1.setText(tablero.getArrCuadrados()[0][1].getValorCuadrado());
        if (tablero.getArrCuadrados()[0][1].getValorCuadrado().equals("0")) {
            i0j1.setForeground(new Color(0, 0, 0, 1));
        } else {
            i0j1.setForeground(Color.darkGray);
        }
        i0j2.setText(tablero.getArrCuadrados()[0][2].getValorCuadrado());
        if (tablero.getArrCuadrados()[0][2].getValorCuadrado().equals("0")) {
            i0j2.setForeground(new Color(0, 0, 0, 1));
        } else {
            i0j2.setForeground(Color.darkGray);
        }
        i0j3.setText(tablero.getArrCuadrados()[0][3].getValorCuadrado());
        if (tablero.getArrCuadrados()[0][3].getValorCuadrado().equals("0")) {
            i0j3.setForeground(new Color(0, 0, 0, 1));
        } else {
            i0j3.setForeground(Color.darkGray);
        }
        i1j0.setText(tablero.getArrCuadrados()[1][0].getValorCuadrado());
        if (tablero.getArrCuadrados()[1][0].getValorCuadrado().equals("0")) {
            i1j0.setForeground(new Color(0, 0, 0, 1));
        } else {
            i1j0.setForeground(Color.darkGray);
        }
        i1j1.setText(tablero.getArrCuadrados()[1][1].getValorCuadrado());
        if (tablero.getArrCuadrados()[1][1].getValorCuadrado().equals("0")) {
            i1j1.setForeground(new Color(0, 0, 0, 1));
        } else {
            i1j1.setForeground(Color.darkGray);
        }
        i1j2.setText(tablero.getArrCuadrados()[1][2].getValorCuadrado());
        if (tablero.getArrCuadrados()[1][2].getValorCuadrado().equals("0")) {
            i1j2.setForeground(new Color(0, 0, 0, 1));
        } else {
            i1j2.setForeground(Color.darkGray);
        }
        i1j3.setText(tablero.getArrCuadrados()[1][3].getValorCuadrado());
        if (tablero.getArrCuadrados()[1][3].getValorCuadrado().equals("0")) {
            i1j3.setForeground(new Color(0, 0, 0, 1));
        } else {
            i1j3.setForeground(Color.darkGray);
        }
        i2j0.setText(tablero.getArrCuadrados()[2][0].getValorCuadrado());
        if (tablero.getArrCuadrados()[2][0].getValorCuadrado().equals("0")) {
            i2j0.setForeground(new Color(0, 0, 0, 1));
        } else {
            i2j0.setForeground(Color.darkGray);
        }
        i2j1.setText(tablero.getArrCuadrados()[2][1].getValorCuadrado());
        if (tablero.getArrCuadrados()[2][1].getValorCuadrado().equals("0")) {
            i2j1.setForeground(new Color(0, 0, 0, 1));
        } else {
            i2j1.setForeground(Color.darkGray);
        }
        i2j2.setText(tablero.getArrCuadrados()[2][2].getValorCuadrado());
        if (tablero.getArrCuadrados()[2][2].getValorCuadrado().equals("0")) {
            i2j2.setForeground(new Color(0, 0, 0, 1));
        } else {
            i2j2.setForeground(Color.darkGray);
        }
        i2j3.setText(tablero.getArrCuadrados()[2][3].getValorCuadrado());
        if (tablero.getArrCuadrados()[2][3].getValorCuadrado().equals("0")) {
            i2j3.setForeground(new Color(0, 0, 0, 1));
        } else {
            i2j3.setForeground(Color.darkGray);
        }
        i3j0.setText(tablero.getArrCuadrados()[3][0].getValorCuadrado());
        if (tablero.getArrCuadrados()[3][0].getValorCuadrado().equals("0")) {
            i3j0.setForeground(new Color(0, 0, 0, 1));
        } else {
            i3j0.setForeground(Color.darkGray);
        }
        i3j1.setText(tablero.getArrCuadrados()[3][1].getValorCuadrado());
        if (tablero.getArrCuadrados()[3][1].getValorCuadrado().equals("0")) {
            i3j1.setForeground(new Color(0, 0, 0, 1));
        } else {
            i3j1.setForeground(Color.darkGray);
        }
        i3j2.setText(tablero.getArrCuadrados()[3][2].getValorCuadrado());
        if (tablero.getArrCuadrados()[3][2].getValorCuadrado().equals("0")) {
            i3j2.setForeground(new Color(0, 0, 0, 1));
        } else {
            i3j2.setForeground(Color.darkGray);
        }
        i3j3.setText(tablero.getArrCuadrados()[3][3].getValorCuadrado());
        if (tablero.getArrCuadrados()[3][3].getValorCuadrado().equals("0")) {
            i3j3.setForeground(new Color(0, 0, 0, 1));
        } else {
            i3j3.setForeground(Color.darkGray);
        }
        Puntos.setText(String.valueOf(tablero.getPuntos()));
        Movidas.setText(String.valueOf(tablero.getMovidas()));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (38): {//ARRIBA
                tableroForm.moverArriba();
                this.actualizaFrmTablero(tableroForm);
                break;
            }
            case (40): {//ABAJO
                tableroForm.moverAbajo();
                this.actualizaFrmTablero(tableroForm);
                break;
            }
            case (39): {//DERECHA
                tableroForm.moverDerecha();
                this.actualizaFrmTablero(tableroForm);
                break;
            }
            case (37): {//IZQUIERDA
                tableroForm.moverIzquierda();
                this.actualizaFrmTablero(tableroForm);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tableroForm = new Tablero();
        actualizaFrmTablero(tableroForm);
    }
}

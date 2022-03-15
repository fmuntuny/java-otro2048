package com.nibblersystems.otro2048.gui;

import com.nibblersystems.otro2048.controler.Otro2048;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmGameOver extends JFrame implements KeyListener {
    private JPanel JPGameOver;
    private JLabel GameOver;
    private JLabel Reiniciar;
    private FrmTablero frmTablero;

    public FrmGameOver(){
        super("Game Over!");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(null);
        setContentPane(JPGameOver);
        this.addKeyListener(this);
        this.setVisible(false);
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent evt ) {
                Otro2048.getFrmTablero().setVisible(true);
                Otro2048.getFrmGameOver().setVisible(false);
            }
        } );
        this.addWindowListener( new WindowAdapter() {
            public void windowActivated(WindowEvent e){
                Otro2048.getFrmTablero().setVisible(false);
            }
        } );
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        String[] args = new String[0];
        switch (e.getKeyCode()) {
            case (38): {//ARRIBA
                Otro2048.abrirNuevoJuego(args);
                break;
            }
            case (40): {//ABAJO
                break;
            }
            case (39): {//DERECHA
                break;
            }
            case (37): {//IZQUIERDA
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

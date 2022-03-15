package com.nibblersystems.otro2048.gui;

import com.nibblersystems.otro2048.controler.Otro2048;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmWin extends JFrame implements KeyListener {
    private JPanel JPWin;
    private JLabel LblWin;
    private FrmTablero frmTablero;

    public FrmWin(){
        super("Ganaste!");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(null);
        setContentPane(JPWin);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

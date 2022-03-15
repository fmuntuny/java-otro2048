/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibblersystems.otro2048.controler;

import com.nibblersystems.otro2048.gui.FrmGameOver;
import com.nibblersystems.otro2048.gui.FrmTablero;
import com.nibblersystems.otro2048.gui.FrmWin;

import java.util.Scanner;

public class Otro2048 {
    private static Tablero tablero = new Tablero();
    private  static FrmTablero frmTablero=new FrmTablero(tablero);
    private static FrmGameOver frmGameOver = new FrmGameOver();
    private static FrmWin frmWin=new FrmWin();


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        tablero.dibujarTablero();
    }
    public static void cerrarJuego(){
        System.exit(0);
    }
    public static void abrirNuevoJuego(String[] args) {
        frmTablero.dispose();
        frmGameOver.dispose();
        frmWin.dispose();
        main(args);

    }

    public static FrmTablero getFrmTablero() {
        return frmTablero;
    }

    public static FrmGameOver getFrmGameOver() {
        return frmGameOver;
    }

    public static FrmWin getFrmWin() {
        return frmWin;
    }
}

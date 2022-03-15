/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibblersystems.otro2048.controler;

import java.awt.*;

/**
 * @author Federico
 */
public class Cuadrado {
    private int id;
    private static int ultimoId;
    private String valorCuadrado;
    private String valorAledaños;
    //private Color color = new Color();

    public Cuadrado() {
        this.id = ++ultimoId;
    }

    public String getValorAledaños(Cuadrado[][] arrCuadrados, int posIOrigen, int posJOrigen, String posicionCardinal) {
        switch (posicionCardinal) {
            case "n":
                try {
                    valorAledaños = arrCuadrados[posIOrigen - 1][posJOrigen].getValorCuadrado();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "-1";
                }
                break;
            case "s":
                try {
                    valorAledaños = arrCuadrados[posIOrigen + 1][posJOrigen].getValorCuadrado();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "-2";
                }
                break;
            case "o":
                try {
                    valorAledaños = arrCuadrados[posIOrigen][posJOrigen - 1].getValorCuadrado();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "-3";
                }
                break;
            case "e":
                try {
                    valorAledaños = arrCuadrados[posIOrigen][posJOrigen + 1].getValorCuadrado();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "-4";
                }
                break;
            case "c":
                try {
                    valorAledaños = arrCuadrados[posIOrigen][posJOrigen].getValorCuadrado();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "-5";
                }
                break;
        }
        return valorAledaños;
    }

    public int getId() {
        return id;
    }

    public String getValorCuadrado() {
        return valorCuadrado;
    }

    public void setValorCuadrado(String valorCuadrado) {
        this.valorCuadrado = valorCuadrado;
    }
}

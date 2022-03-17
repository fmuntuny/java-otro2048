/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibblersystems.otro2048.controler;

import javax.swing.*;
import java.awt.*;

public class Cuadrado extends JLabel {
    private String valor;

    public Cuadrado(String valor) {
        super(valor.toString());
        this.valor=valor;
    }

    public String getValorCuadrado() {
        return this.valor;
    }

    public void setValorCuadrado(String valor) {
        this.valor = valor;
    }
}

package com.nibblersystems.otro2048.controler;

import java.awt.*;

public enum SpecCuadrado {

    CERO(new Color(0, 0, 0, 1),new Color(240,240,220),"0"),//fondo gris claro
    DOS(new Color(130, 130, 130),new Color(250,250,90),"2"),//amarillo claro
    CUATRO(new Color(130, 130, 130),new Color(250,230,90),"4"),//naranja bien claro
    OCHO(new Color(130, 130, 130),new Color(250,210,90),"8"),//naranja claro
    DIECISEIS(new Color(255, 255, 255),new Color(250,190,90),"16"),//naranja intermedio
    TREINTAYDOS(new Color(255, 255, 255),new Color(250,150,90),"32"),//naranja intermedio/ocuro
    SESENTAYCUATRO(new Color(255, 255, 255),new Color(250,90,40),"64"),//naranja oscuro
    CIENTOVEINTIOCHO(new Color(255, 255, 255),new Color(250,40,40),"128"),//rojo claro
    DOSCIENTOSCINCUENTAYSEIS(new Color(255, 255, 255),new Color(200,250,40),"256"),//verde claro
    QUINIENTOSDOCE(new Color(255, 255, 255),new Color(150,250,40),"512"),//verde intermedio
    MILVEINTICUATRO(new Color(255, 255, 255),new Color(80,250,40),"1024"),//verde intenso
    DOSMILCUARENTAYOCHO(new Color(255, 255, 255),new Color(35,180,0),"2048");//verde oscuro

    private Color colorFuente;
    private Color colorFondo;
    private String valor;

    SpecCuadrado(Color colorFuente, Color colorFondo, String valor) {
        this.colorFuente = colorFuente;
        this.colorFondo = colorFondo;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return this.valor;
    }

    public Color getColorFuente() {
        return colorFuente;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public String getValor() {
        return valor;
    }
}

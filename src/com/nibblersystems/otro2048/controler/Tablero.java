/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibblersystems.otro2048.controler;

public class Tablero {
    private Cuadrado[][] arrCuadrados = new Cuadrado[4][4];
    private boolean gameOver = false;
    private static int movidas = 0;
    private final int largoArray = 4;
    private int puntos = 0;
    private int puntosTemp = 0;
    private boolean gano = false;
    private Cuadrado cuadrado;

    public Tablero() { //GENERA UN NUEVO TABLERO PARA EMPEZAR EL JUEGO DESDE CERO
        for (int i = 0; i < this.arrCuadrados[0].length; i++) {
            for (int j = 0; j < this.arrCuadrados[0].length; j++) {
                this.arrCuadrados[i][j] = new Cuadrado("0");
            }
        }
        this.setNewCuadrado("2");
        this.setNewCuadrado("2");
    }

    public void getNewTablero(){
        for (int i = 0; i < this.arrCuadrados[0].length; i++) {
            for (int j = 0; j < this.arrCuadrados[0].length; j++) {
                this.arrCuadrados[i][j] = new Cuadrado("0");
            }
        }
        this.setNewCuadrado("2");
        this.setNewCuadrado("2");
        this.setPuntos(0);
        this.setMovidas(0);
        this.setGano(false);
        this.setGameOver(false);
    }

    /////////////////////////////////////////////////ESTO ES PARA HACER PRUEBAS////////////////////////////////////////////////////////////////
    /*public Tablero(int cantNewCuadrados) { //GENERA UN NUEVO TABLERO ALEATOREO PARA PRUEBAS
        for (int i = 0; i < this.getLargoArray(); i++) {
            for (int j = 0; j < this.getLargoArray(); j++) {
                this.arrCuadrados[i][j] = new Cuadrado();
                this.arrCuadrados[i][j].setValorCuadrado("0");
            }
        }
        for (int i = 0; i < cantNewCuadrados; i++) {
            this.setNewCuadrado(String.valueOf(i));
        }
    }

    public Tablero(String muestraPosiciones) { //GENERA UN NUEVO TABLERO CON LAS POSICIONES I Y J
        for (int i = 0; i < this.arrCuadrados[0].length; i++) {
            for (int j = 0; j < this.arrCuadrados[0].length; j++) {
                this.arrCuadrados[i][j] = new Cuadrado();
                this.arrCuadrados[i][j].setValorCuadrado("i" + i + "-j" + j);
            }
        }
    }

    public Tablero(String w, String x, String y, String z) { //GENERA UN NUEVO TABLERO PARA EMPEZAR EL JUEGO DESDE CERO
        for (int i = 0; i < this.arrCuadrados[0].length; i++) {
            for (int j = 0; j < this.arrCuadrados[0].length; j++) {
                this.arrCuadrados[i][j] = new Cuadrado();
                this.arrCuadrados[i][j].setValorCuadrado("0");
            }
        }
        this.getArrCuadrados()[0][0].setValorCuadrado(w);
        this.getArrCuadrados()[1][0].setValorCuadrado(x);
        this.getArrCuadrados()[2][0].setValorCuadrado(y);
        this.getArrCuadrados()[3][0].setValorCuadrado(z);
        this.dibujarTablero();
    }*/
    /////////////////////////////////////////////////ESTO ES PARA HACER PRUEBAS////////////////////////////////////////////////////////////////


    public Cuadrado[][] getArrCuadrados() {
        return this.arrCuadrados;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = true;
    }

    public int getPuntos() {
        return puntosTemp;
    }

    public void setPuntos(int puntos) {
        this.puntosTemp = puntos + puntosTemp;
    }

    public int getLargoArray() {
        return largoArray;
    }


    public int getMovidas() {
        return movidas;
    }

    public void setMovidas(int cantMovida) {
        movidas += cantMovida;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getValorCuadrado(int i, int j) {
        return this.arrCuadrados[i][j].getValorCuadrado();
    }

    public void setValorCuadrado(int i, int j, String valor) {
        this.arrCuadrados[i][j].setValorCuadrado(valor);
    }

    public void setNewCuadrado(String valorCuadrado) {//GENERA UN CUADRADO NUEVO CON VALOR valorCuadrado EN UN CUADRADO VACIO ALEATOREO
        String[] arrCuadradosVacios = new String[16];
        int contVacios = 0;//INDEX DEL ARRCUADRADOSVACIOS
        for (int i = 0; i < this.getLargoArray(); i++) {
            for (int j = 0; j < this.getLargoArray(); j++) {
                if (this.getArrCuadrados()[i][j].getValorCuadrado().equals("2048")) {
                    this.setGano(true);
                    Otro2048.getFrmWin().setVisible(true);
                }
                if (this.getValorCuadrado(i, j).equals("0")) {
                    arrCuadradosVacios[contVacios] = String.valueOf(i) + String.valueOf(j);
                    contVacios++;
                }
            }
        }
        if (contVacios < 2) {
            this.setGameOver(true);
        } else {
            double indiceVacioI = Math.random() * contVacios;
            String indiceVacioIStr = String.valueOf(indiceVacioI - (indiceVacioI % 1));
            indiceVacioIStr = indiceVacioIStr.substring(0, indiceVacioIStr.lastIndexOf("."));
            int indiceI = Integer.parseInt(arrCuadradosVacios[Integer.parseInt(indiceVacioIStr)].substring(0, 1));
            int indiceJ = Integer.parseInt((arrCuadradosVacios[Integer.parseInt((indiceVacioIStr))].substring(1, 2)));
            this.arrCuadrados[indiceI][indiceJ].setValorCuadrado(valorCuadrado);
        }
    }

    public void dibujarTablero() {

        Otro2048.getFrmTablero().actualizaFrmTablero(this.arrCuadrados);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String dato = this.arrCuadrados[i][j].getValorCuadrado();
                if (dato.equals("0")) {
                    dato = "";
                }
                sb.append(dato).append("\t");
                if (j == 3) {
                    sb.append("\n");
                }
            }
        }
    }

    public int[] subirNumeros(int[] arrNumeros, int jPos) {
        int contarCeros = 0;
        int indexPrimerMayor = -1;
        int indexSegundoMayor = -1;
        int indexTercerMayor = -1;
        int indexCuartoMaror = -1;
        int numPrimerMayorCero = -1;
        int numSegundoMayorCero = -1;
        int numTercerMayorCero = -1;
        int numCuartoMarorCero = -1;
        int sumaPrimerPar = 0;
        int sumaSegundoPar = 0;
        int puntosJugada = 0;
        int[] indexPrimerParConsecutivo = new int[2];
        int[] indexSegundoParConsecutivo = new int[2];
        boolean activaPrimerMayorCero = false;
        boolean activaSegundoMayorCero = false;
        boolean activaTercerMayorCero = false;
        boolean activaCuartoMayorCero = false;
        boolean activaPrimerParConsecutivo = false;
        boolean activaSegundoParConsecutivo = false;
        boolean activaTresConsecutivosIguales = false;
        boolean subioNumeros = false;
        boolean modificoNumeros = false;

        for (int i = 0; i < this.getLargoArray(); i++) {
            if (arrNumeros[i] == 0) {
                contarCeros++;
                if ((subioNumeros == false) && (arrNumeros[0] + arrNumeros[1] + arrNumeros[2] + arrNumeros[3] > 0)) {//FILTRA SI SON 4 CEROS PORQUE NO HAY NADA QUE MODIFICAR
                    subioNumeros = true;
                    if ((arrNumeros[3] > 0) && (arrNumeros[2] == 0)) {
                        arrNumeros[2] = arrNumeros[3];
                        arrNumeros[3] = 0;
                        modificoNumeros = true;
                    }
                    if ((arrNumeros[2] > 0) && (arrNumeros[1] == 0)) {
                        arrNumeros[1] = arrNumeros[2];
                        arrNumeros[2] = 0;
                        modificoNumeros = true;
                        if ((arrNumeros[3] > 0) && (arrNumeros[2] == 0) && (arrNumeros[1] > 0)) {
                            arrNumeros[2] = arrNumeros[3];
                            arrNumeros[3] = 0;
                            modificoNumeros = true;
                        }
                    }
                    if ((arrNumeros[1] > 0) && (arrNumeros[0] == 0)) {
                        arrNumeros[0] = arrNumeros[1];
                        arrNumeros[1] = 0;
                        modificoNumeros = true;
                        if ((arrNumeros[2] > 0) && (arrNumeros[1] == 0) && (arrNumeros[0] > 0)) {
                            arrNumeros[1] = arrNumeros[2];
                            arrNumeros[2] = 0;
                            modificoNumeros = true;
                            if ((arrNumeros[3] > 0) && (arrNumeros[2] == 0) && (arrNumeros[1] > 0)) {
                                arrNumeros[2] = arrNumeros[3];
                                arrNumeros[3] = 0;
                                modificoNumeros = true;
                            }
                        }
                    }
                    if (arrNumeros[0] == 0) {
                        arrNumeros[0] = arrNumeros[1];
                        arrNumeros[1] = 0;
                        modificoNumeros = true;
                    }
                    if (modificoNumeros == true) {
                        --i;
                        --contarCeros;
                    }
                }
            } else {
                if (activaPrimerMayorCero == false) {
                    indexPrimerMayor = i;
                    numPrimerMayorCero = arrNumeros[i];
                    activaPrimerMayorCero = true;
                } else if (activaSegundoMayorCero == false) {//EN ESTE CASO SE GENERA EL PRIMER ARRAY DE PAR CONSECUTIVO
                    indexSegundoMayor = i;
                    numSegundoMayorCero = arrNumeros[i];
                    activaSegundoMayorCero = true;
                    if (numPrimerMayorCero == numSegundoMayorCero) {
                        activaPrimerParConsecutivo = true;
                        indexPrimerParConsecutivo[0] = indexPrimerMayor;
                        indexPrimerParConsecutivo[1] = indexSegundoMayor;
                    }
                } else if (activaTercerMayorCero == false) {//EN ESTE CASO SE PUEDE GENERAR EL PRIMER PAR CONSECUTIVO Y TAMBIÉN 3 CONSECUTIVOS IGUALES
                    indexTercerMayor = i;
                    numTercerMayorCero = arrNumeros[i];
                    activaTercerMayorCero = true;
                    if ((numPrimerMayorCero == numSegundoMayorCero) && (numSegundoMayorCero == numTercerMayorCero)) {
                        activaTresConsecutivosIguales = true;
                    } else if (numSegundoMayorCero == numTercerMayorCero) {
                        activaPrimerParConsecutivo = true;
                        indexPrimerParConsecutivo[0] = indexSegundoMayor;
                        indexPrimerParConsecutivo[1] = indexTercerMayor;
                    }
                } else if (activaCuartoMayorCero == false) {
                    activaCuartoMayorCero = true;
                    indexCuartoMaror = i;
                    numCuartoMarorCero = arrNumeros[i];
                    activaCuartoMayorCero = true;
                    if (((numPrimerMayorCero == numCuartoMarorCero) || (numSegundoMayorCero == numCuartoMarorCero) || (numTercerMayorCero == numCuartoMarorCero)) && (activaPrimerParConsecutivo == false)) {
                        activaPrimerParConsecutivo = true;
                        indexPrimerParConsecutivo[0] = indexTercerMayor;
                        indexPrimerParConsecutivo[1] = indexCuartoMaror;
                    } else if ((numPrimerMayorCero == numSegundoMayorCero) && (numTercerMayorCero == numCuartoMarorCero) && (activaPrimerParConsecutivo == true)) {
                        activaSegundoParConsecutivo = true;
                        activaTresConsecutivosIguales = false;
                        indexSegundoParConsecutivo[0] = indexTercerMayor;
                        indexSegundoParConsecutivo[1] = indexCuartoMaror;
                    } else if ((numSegundoMayorCero == numTercerMayorCero) && (numTercerMayorCero == numCuartoMarorCero)) {
                        activaTresConsecutivosIguales = true;
                    }
                }
            }
        }
        switch (contarCeros) {
            case (2): {
                if (activaPrimerParConsecutivo == true) {
                    sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                    arrNumeros[0] = sumaPrimerPar;
                    arrNumeros[1] = 0;
                    arrNumeros[2] = 0;
                    arrNumeros[3] = 0;
                    puntosJugada += sumaPrimerPar;
                }
                break;
            }
            case (1): {
                //SI SON UN PAR IGUALES Y OTRO DIFERENTE
                if ((activaPrimerParConsecutivo == true) && (activaTresConsecutivosIguales == false)) {
                    if (arrNumeros[0] == arrNumeros[1]) {
                        sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                        arrNumeros[0] = sumaPrimerPar;
                        arrNumeros[1] = arrNumeros[2];
                        arrNumeros[2] = 0;
                        arrNumeros[3] = 0;
                        puntosJugada += sumaPrimerPar;
                    } else {
                        sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                        arrNumeros[1] = sumaPrimerPar;
                        arrNumeros[2] = 0;
                        puntosJugada += sumaPrimerPar;
                    }
                }

                //SI SON 3 IGUALES CONSECUTIVOS
                if (activaTresConsecutivosIguales == true) {
                    sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                    arrNumeros[0] = sumaPrimerPar;
                    arrNumeros[1] = arrNumeros[2];
                    arrNumeros[2] = 0;
                    arrNumeros[3] = 0;
                    puntosJugada += sumaPrimerPar;
                }
                break;
            }
            case (0): {
                //DOS PARES IGUALES
                if ((activaPrimerParConsecutivo == true) && (activaSegundoParConsecutivo == true) && (activaTresConsecutivosIguales == false)) {
                    sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                    sumaSegundoPar = arrNumeros[indexSegundoParConsecutivo[0]] + arrNumeros[indexSegundoParConsecutivo[1]];
                    arrNumeros[0] = sumaPrimerPar;
                    arrNumeros[1] = sumaSegundoPar;
                    arrNumeros[2] = 0;
                    arrNumeros[3] = 0;
                    puntosJugada += sumaPrimerPar + sumaSegundoPar;
                }

                //SI SON 3 IGUALES CONSECUTIVOS
                if (((activaTresConsecutivosIguales == true) && (activaSegundoParConsecutivo == false)) && (arrNumeros[0] == arrNumeros[1])) {
                    sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                    arrNumeros[0] = sumaPrimerPar;
                    arrNumeros[1] = arrNumeros[2];
                    arrNumeros[2] = arrNumeros[3];
                    arrNumeros[3] = 0;
                    puntosJugada += sumaPrimerPar;
                } else if (((activaTresConsecutivosIguales == true) && (activaSegundoParConsecutivo == false)) && (arrNumeros[2] == arrNumeros[3])) {
                    sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                    arrNumeros[1] = sumaPrimerPar;
                    arrNumeros[2] = arrNumeros[3];
                    arrNumeros[3] = 0;
                    puntosJugada += sumaPrimerPar;
                }

                //SI SON DOS IGUALES CONSECUTIVOS Y DOS DIFERENTES
                if ((activaPrimerParConsecutivo == true) && (activaSegundoParConsecutivo == false) && (activaTresConsecutivosIguales == false)) {
                    if (arrNumeros[0] == arrNumeros[1]) {
                        sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                        arrNumeros[0] = sumaPrimerPar;
                        arrNumeros[1] = arrNumeros[2];
                        arrNumeros[2] = arrNumeros[3];
                        arrNumeros[3] = 0;
                        puntosJugada += sumaPrimerPar;
                    } else if (arrNumeros[1] == arrNumeros[2]) {
                        sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                        arrNumeros[1] = sumaPrimerPar;
                        arrNumeros[2] = arrNumeros[3];
                        arrNumeros[3] = 0;
                        puntosJugada += sumaPrimerPar;
                    } else if (arrNumeros[2] == arrNumeros[3]) {
                        sumaPrimerPar = arrNumeros[indexPrimerParConsecutivo[0]] + arrNumeros[indexPrimerParConsecutivo[1]];
                        arrNumeros[2] = sumaPrimerPar;
                        arrNumeros[3] = 0;
                        puntosJugada += sumaPrimerPar;
                    }
                }
                break;
            }
        }
        this.setPuntos(puntosJugada);
        return arrNumeros;
    }

    public boolean noSubeMas() {
        //DEVUELVE TRUE SI SE PUEDEN SUBIR MÁS NÚMEROS
        for (int j = 0; j < this.getLargoArray(); j++) {
            for (int i = 2; i >= 0; i--) {
                String origen2 = this.getArrCuadrados()[i][j].getValorCuadrado();
                String superOrigen2 = this.getArrCuadrados()[i + 1][j].getValorCuadrado();
                int intOrigen2 = Integer.parseInt(origen2);
                int intSuperOrigen2 = Integer.parseInt(superOrigen2);
                if ((intOrigen2 == 0 && intSuperOrigen2 > 0) || ((intOrigen2 == intSuperOrigen2) && (intOrigen2 + intSuperOrigen2 > 0))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void procesarMovimiento() {
        int[] arrTemp = new int[4];
        if (this.noSubeMas() == false) {
            for (int j = 0; j < this.largoArray; j++) {
                for (int i = 0; i < this.largoArray; i++) {
                    arrTemp[i] = Integer.parseInt(this.getArrCuadrados()[i][j].getValorCuadrado());
                }
                int[] arrTemp2 = new int[4];
                arrTemp2 = this.subirNumeros(arrTemp, j);
                for (int i = 0; i < this.getLargoArray(); i++) {
                    this.getArrCuadrados()[i][j].setValorCuadrado(String.valueOf(arrTemp2[i]));
                }
            }
            this.setNewCuadrado("2");
            this.setMovidas(1);
            if (this.getGameOver() == true) {
                Otro2048.getFrmGameOver().setVisible(true);
            }
            Otro2048.getFrmTablero().actualizaFrmTablero(this.arrCuadrados);
        }
    }

    public void rotarTablero90Derecha() {
        Cuadrado[][] arrTemp = new Cuadrado[4][4];
        for (int i = 0; i < arrTemp[0].length; i++) {
            for (int j = 0; j < arrTemp[0].length; j++) {
                arrTemp[i][j] = new Cuadrado("0");
                arrTemp[i][j].setValorCuadrado("0");
            }
        }
        int n = this.getArrCuadrados()[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                arrTemp[i][j].setValorCuadrado(this.getArrCuadrados()[n - j - 1][i].getValorCuadrado());
            }
        }
        //this.arrCuadrados = arrTemp;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                this.getArrCuadrados()[i][j].setValorCuadrado(arrTemp[i][j].getValorCuadrado());
            }
        }
    }

    public void moverArriba() {
        this.procesarMovimiento();
        this.dibujarTablero();
    }

    public void moverAbajo() {
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.procesarMovimiento();
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.dibujarTablero();
    }

    public void moverIzquierda() {
        this.rotarTablero90Derecha();
        this.procesarMovimiento();
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.dibujarTablero();
    }

    public void moverDerecha() {
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.rotarTablero90Derecha();
        this.procesarMovimiento();
        this.rotarTablero90Derecha();
        this.dibujarTablero();
    }
}

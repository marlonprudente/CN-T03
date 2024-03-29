/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

/**
 *
 * @author marlon
 */
public class Splines {

    public static double[] a;
    public static double[] b;
    public static double[] c;
    public static double[] d;

    /**
     * @param n (número de pontos - 1)
     * @param x (array contendo as abissisas dos pontos)
     * @param y (array contendo as coordenadas dos pontos)
     */
    public static void interpola(int n, double x[], double y[]) {        

        final int T = n+1;
        //variáveis locais
        double[] h = new double[T];
        double[] p = new double[T];
        double[] l = new double[T];
        double[] u = new double[T];
        double[] z = new double[T];
        
        //redimensionamento das variáveis globais
        a = new double[T];
        b = new double[T];
        c = new double[T];
        d = new double[T];

        //Passo 1 - Cálculo dos valores de h e d
        for (int i = 1; i <= n; i++) {
            h[i] = x[i] - x[i - 1];
            d[i] = y[i];
        }

        //Passo 2 - Início da construção do sistema linear
        for (int i = 1; i <= (n - 1); i++) {
            p[i] = 3 * ((y[i + 1] - y[i]) / h[i + 1] - (y[i] - y[i - 1]) / h[i]);
        }

        //Passo 3
        l[0] = 1;
        u[0] = 0;
        z[0] = 0;

        //Passo 4
        for (int i = 1; i <= (n - 1); i++) {
            l[i] = 2 * (x[i + 1] - x[i - 1]) - h[i] * u[i - 1];
            u[i] = h[i + 1] / l[i];
            z[i] = (p[i] - h[i] * z[i - 1]) / l[i];
        }

        //Passo 5
        l[n] = 1;
        z[n] = 0;
        b[n] = 0;

        //Passo 6
        for (int j = (n - 1); j >= 0; j--) {
            b[j] = z[j] - u[j] * b[j + 1];
        }
        for (int j = n; j >= 1; j--) {
            c[j] = (y[j] - y[j - 1]) / h[j] + h[j] * (2 * b[j] + b[j - 1]) / 3;
            a[j] = (b[j] - b[j - 1]) / (3 * h[j]);
        }
    }

    public static double[] getA() {
        return a;
    }

    public static double[] getB() {
        return b;
    }

    public static double[] getC() {
        return c;
    }

    public static double[] getD() {
        return d;
    }    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author marlon
 */
public class Funcao {
    
    public void polinomiointerpolador(){
        int n;
        Double vetx[] = null, vetfx[] = null, x, fx = 0.0, parc = 0.0, fin = 1.0;
        Scanner teclado;
        teclado = new Scanner(System.in);
        teclado.useLocale(Locale.ENGLISH);
        
        System.out.println("Ordem do Polinomio: ");
        n = teclado.nextInt();
        
        vetx = new Double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Insira o valor de X" + i);
            vetx[i] = teclado.nextDouble();
        }
        
        vetfx = new Double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Insira o valor de f" + i + "(x)");
            vetfx[i] = teclado.nextDouble();
        }
        
        System.out.println("Valor de X, para se calcular f(x):");
        x = teclado.nextDouble();
        
        for (int i = 0; i < n; i++) {
            fin = vetfx[i];
            
            for (int j = 0; j < n; j++) {
   
                          if (i != j) {
                    fin = fin * (x - vetx[j])/(vetx[i] - vetx[j]);
                }

                


            }
            
            parc = parc + fin;
        }
        fx = parc;
        
        System.out.println("O valor de f(x) para X é = " + fx + "");
        
    }   

    
}

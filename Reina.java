
package pkg8reinas;

public class Reina {
 
    int[] x;
 
    public Reina() {
        x = new int[8];
    }
 
    public boolean esConveniente(int f, int c) {
        /**
        metodo boolano que verifica si es conveniente poner a la reina en la columna c y
        * fila f
         */
        for (int i = 0; i < f; i++) {
            if (x[i] == c || (i - f) == (x[i] - c) ||(i - f) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }
 
    public void imprimeTablero(int[] x) {
        int tam = 8;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (x[i] == j) {
                    System.out.print("۞ ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
 
    public void backtracking(int f, int n) { //este metodo va recorriendo los posibles espacio hasta que 
        //encuentra uno donde no se ataquen
      
        for (int c = 0; c < n; c++) {
            if (esConveniente(f, c)) {
                x[f] = c;
                if (f == n - 1) {
                    imprimeTablero(x);
                } else {
                    backtracking(f + 1, n);
                }
            }
        }
    }
 
    public void llamaBT() {
        backtracking(0, 8);
    }
 
    public static void main(String args[]) {
        Reina R = new Reina();
        R.llamaBT();
      
    }
}
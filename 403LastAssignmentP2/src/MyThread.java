public class MyThread extends Thread{

    private int[][] a, b, c;
    private int i, j, k;

    public MyThread(int[][] a, int[][] b, int[][] c, int i, int j, int k){
        this.a = a;
        this.b = b;
        this.c = c;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public void run(){
        synchronized (this) {
            try {
                c[i][j] += a[i][k] * b[k][j];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

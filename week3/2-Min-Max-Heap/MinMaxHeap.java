import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qvka
 */
public class MinMaxHeap {
    private boolean isMinMaxHeap;
    private int[] array;
    private int size;
    public MinMaxHeap(int[] arr){
        isMinMaxHeap = true;
        this.size = arr.length;
        this.array = new int[size+1];
        System.arraycopy(arr, 0, this.array, 1, this.size);
    }
    public boolean isMinMaxHeap(){
        int level = 1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        preOrder(1, min, max,1);
        return this.isMinMaxHeap;
    }
    public void preOrder(int k , int min , int max , int level){
        if(k > size || array[k] == 0){
            return;
        }
        if( array[k] <=  min || array[k] >= max ){
            isMinMaxHeap = false;
            return;
        }
        if ( level % 2 == 1){
            min = array[k];
        }else{
            max = array[k];
        }
            preOrder(k*2, min, max,level+1);
            preOrder( (k*2)+1 , min , max, level+1);
    }
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
           br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine(){
            String str = "";
            try {
               str = br.readLine();
            } catch (IOException e) {
               e.printStackTrace();
            }
            return str;
        }
    }
   
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int[] arr = new int[n];  // 1-based 
        for(int i = 0 ; i < n ; ++i){
            arr[i] = scanner.nextInt();
        }
        MinMaxHeap heap = new MinMaxHeap(arr);
        if(heap.isMinMaxHeap()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    
}
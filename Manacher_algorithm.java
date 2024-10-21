import java.util.*;

public class Manchers_algo {
    Manchers_algo(String s){
        // step - 1 :)
        int n=s.length();
        c=new char[2*n+1];
        Arrays.fill(c,'#');
        for(int i=0,idx=1;i<n;i++,idx+=2){
            c[idx]=s.charAt(i);
        }
        System.out.println(Arrays.toString(c));
        p=new int[c.length];
        Arrays.fill(p,1);

    }
    char[] c;
    int[] p;
    // step 2 building manachers array
    public void build(){
        // filling all values with 1 as minimum palindromic length could be of length 1
        int n=p.length;
        Arrays.fill(p,1);
        // initializing bounding box limits
        int l=1,r=1;
        // you can take l=-1, r=3
        for(int i=1;i<n;i++){
            p[i] = Math.max(1, Math.min(r - i, r+l-i>=0 ?p[r + l - i]:1));// optimization which helps to reduce time complextiy from n^2 to n
            while (i - p[i] >= 0 && i + p[i] < n && c[i - p[i]] == c[i + p[i]]) {
                p[i]++;
            }
            // updating bounding box if we found a palindrome whose right index cross the r pointer of bounding box
            if (r < i + p[i]) {
                if(i-p[i]<0){
                    System.out.println(i+"  "+p[i]);
                }
                l = i - p[i];
                r = i + p[i];
            }
        }
        System.out.println(Arrays.toString(p));
    }
}

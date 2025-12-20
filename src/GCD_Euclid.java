public class GCD_Euclid {
    int gcd_find(int a, int b){
        int r;
        while(true)
        {
            if(a==0) return b;
            if(b==0) return a;
            r = a%b;
            a = b;
            b = r;
        }
    }
}

public class GCD {
    int GCD(int a, int b){
        int r;
        while(b!=0)
        {
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}

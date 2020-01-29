import java.util.*;



class enc{
    char alpha;
    char []code = {'a', 'a', 'a', ' ', ' ', ' ', ' ', ' ', ' '};
    enc(){
        this.alpha='b';
    }
    public void add(char a, char []c){
        this.alpha=a;
        this.code=c;
    }
    public char[] getcode(){
        return this.code;
    }
    public char getalpha(){
        return this.alpha;
    }
}

class decdata{

    enc[] data; 
    int size, count;

    decdata(int s){
        this.size = s;
        this.count = 0;
        data = new enc[s];
    }

    public void add_data(char a, char[] c, int i){
        data[i] = new enc();
        data[i].add(a, c);

    }
    public enc[] print(){
        return this.data;
    }
    public char get(int i){
        return data[i].getalpha();
    }
    public int check(char[] str){
        int flag=1;
        for(int i=0; i<=count; i++){
            boolean blnResult = Arrays.equals(data[i].code,str);
            if (blnResult==true){
                flag = 0;
            }
        }
        return flag;
    }

}

public class test{
    public static void main(String []args){

        decdata d = new decdata(3);
        char[]c={'h', 'l', 'o'};
        char a = 'a';
        d.add_data(a, c, 0);
        System.out.println(d.get(0));

    }

}
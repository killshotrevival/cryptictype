import java.util.*;

class enc{
    char alpha;
    char []code = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    public void add(char a, char []c){
        code = new char[5];
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
    int size;

    decdata(int s){
        this.size = s;
        data = new enc[s];
        for(int i=0; i<s; i++){
            data[i] = new enc();
        }
    }

    public void add_data(char a, char[] c, int i){

        data[i].add(a, c);

    }

    public void printdata(int input){
        System.out.println("Dataset:-");
        for(int i=0; i<input; i++){
            System.out.print(data[i].getalpha());
            System.out.print(":-");
            System.out.println(data[i].getcode());
        }
    }

    public int check_char(char c, int s){
        int flag=0;
        for(int i=0; i<s; i++){
            if (data[i].getalpha()==c)
            {
                flag=1;
                break;
            }
        }
        return flag;
    }

    public int check(char[] str, int input){
        int flag=1;
        for(int i=0; i<input; i++){
            //data[i] = new enc();
            boolean blnResult = Arrays.equals(data[i].code,str);
            if (blnResult==true){
                flag = 0;
            }
        }
        return flag;
    }

    public char[] retcode(char c){
        char []a = new char[5];
        for(int i=0; i<size; i++){
            if (data[i].getalpha()==c){
                a = new char[data[i].getcode().length];
                a=data[i].getcode();
                break;
            }
        }
        return a;
    }

    //decode
    public void match(char[] str){
        for(int i=0; i<this.size; i++){
            //data[i] = new enc();
            boolean blnResult = Arrays.equals(data[i].code,str);
            if (blnResult==true){
                System.out.print(data[i].getalpha());
            }
        }
    }

    public char[] str_to_char(String s){
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) { 
            c[i] = s.charAt(i); 
        }
        return c;
    }

    public void decode(String str){
        String temp;
        for(int i=0; i<str.length(); i=i+5){
            temp = str.substring(i,i+5);
            char []c = str_to_char(temp);
            match(c);

        }
    }

}

//main class <index.java>
public class index{

    public static int check(char []str, char a){
        int flag=1, c;
        for(int i=0; i<str.length; i++){
            c = Character.compare(str[i], a);
            if (c==0){
                flag = 0;
            }
        }
        return flag;
    }

    public static char [] randomstring(char[] str){
        int c;
        Random random = new Random();
        char[] mainstring = new char[5];
        int j;
        for (int i=0; i<5; i++){
            j=random.nextInt(5);
            c = check(mainstring, str[j]);
            if(c==1){
                mainstring[i] = str[j];
            }
            else{
                i=i-1;
            }
        }
        return mainstring;
        
    }

    public static char[] mainstring_genrator(){
        Random random = new Random();
        int c;
        char[] select = {'@', '!', '$', '#', '%', '~', '^', '&', '*'};
        char[] mainstring = new char[5];
        int j;
        for (int i=0; i<5; i++){
            j=random.nextInt(9);
            c = check(mainstring, select[j]);
            if(c==1){
                mainstring[i] = select[j];
            }
            else{
                i=i-1;
            }
        }
        return mainstring;
    }

    public static char[] str_to_char(String s){
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) { 
            c[i] = s.charAt(i); 
        }
        return c;
    }
    public static void main(String[] args) {
        
        //Will genrate the random string
        char []mainstring = mainstring_genrator();
        StringBuilder finalstr = new StringBuilder("");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Input String:");
        String inputString = input.next();

        char []inputchar = str_to_char(inputString);
        
        char []randomstr;
        int check, check2;
        decdata dataset = new decdata(inputchar.length);
        for(int i=0; i<inputchar.length;i++){
            check2 = dataset.check_char(inputchar[i], i);
            if(check2==0){
            randomstr = randomstring(mainstring);
            check = dataset.check(randomstr, i);
            if(check==1){
                dataset.add_data(inputchar[i], randomstr, i);
                finalstr.append(randomstr);
            }
            else{
                i=i-1;
            }
        }

        else{
            finalstr.append(dataset.retcode(inputchar[i]));
        }
        }

        System.out.println(finalstr);
       // System.out.println(inputchar);
        dataset.printdata(inputchar.length);


        System.out.println("Enter the input to decode:-");
        String decstr = input.next();
        input.close();
        dataset.decode(decstr);

    }

}
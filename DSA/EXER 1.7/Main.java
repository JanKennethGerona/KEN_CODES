import java.util.Scanner;
import java.util.Stack;


public class Main {
    
    public static int inputBase(){
        int base = 0;
        try {

            Scanner input = new Scanner(System.in);
            System.out.print("target base: ");
            base = input.nextInt();
            if (base < 2 || base > 16 || base == 10) {
                base = inputBase();
                return base;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return base;
    }
    
    public static int inputDecimal(){
        int deci = 0;
        try {

            Scanner input = new Scanner(System.in);
            System.out.print("decimal value: ");
            deci = input.nextInt();
            if (deci > 1000) {
                deci = inputDecimal();
            }else if(deci<0){
                return deci;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return deci;
    }
    
    public static void printHexi(Stack remain,int base,int deci){
        int temp;
        System.out.printf("value of %d in base %d is ", deci, base);
        
        while (!remain.isEmpty()){
        temp = Integer.parseInt(remain.pop().toString());
        
        if (temp == 10){
            System.out.print("A");
        }else if(temp == 11){
            System.out.print("B");
        }else if(temp == 12){
            System.out.print("C");
        }else if(temp == 13){
            System.out.print("D");
        }else if(temp == 14){
            System.out.print("E");
        }else if(temp == 15){
            System.out.print("F");
        }else{
            System.out.print(temp);
        }
        }
        System.out.println("");
    }
    
    public static void printConverted(Stack remain, int base, int deci){
        //print the result
        System.out.printf("value of %d in base %d is ", deci, base);
        while (!remain.isEmpty()){
        System.out.print(remain.pop());
        }
        System.out.println("");
    }
    
    public static Stack remaining(Stack remain, int base, int deci){
        int temp = deci;
        remain.push(temp%base);
            //store the remainders in a stack
        temp = temp/base;
        
        if(temp != 0){
            remaining(remain, base, temp);
        }
        return remain;
    }
    
    public static Stack input(Stack remain) {
        Scanner input = new Scanner(System.in);
        int base = 0, temp = 0, deci;
        try {
            deci = inputDecimal();

            if (deci < 0) {
                return remain;
            }

            base = inputBase();
            temp = deci;

            if (deci > 0 && deci < 1000 && base > 1 && base < 17 && base != 10) {
                remain = remaining(remain, base, deci);

                if (base == 16) {
                  printHexi(remain, base, deci);
                } else {
                    printConverted(remain, base, deci);
                }
                remain = new Stack();
                input(remain);
                return remain;
            } else if (deci < 0) {
                return remain;
            } else {
                System.out.println("\nError! try again...");
                remain = new Stack();
                return remain;
            }
        } catch (Exception e) {
            System.out.println("\nError! try again...");
            remain = new Stack();
            input(remain);
            return remain;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack remain = new Stack();
        remain = input(remain);

        System.out.println("thank you for using the program. bye!");
    }
    }
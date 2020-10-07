package interpreter.bytecode;

import java.util.Scanner;
import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        return;
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter an Integer:");
        int temp = sc.nextInt();
        vm.push(temp);
        Data.add(Integer.toString(temp));
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("READ " + Data.get(0));
    }

}
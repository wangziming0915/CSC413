package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode {
    ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        return;
    }

    @Override
    public void execute(VirtualMachine vm) {

        System.out.println(vm.peek());
        Data.add(Integer.toString(vm.peek()));
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){


        return ("WRITE " + Data.get(0));
    }
}
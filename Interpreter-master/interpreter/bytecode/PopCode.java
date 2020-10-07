package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode {
    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {

        for (int i = 1; i > Integer.parseInt(Data.get(0)); i++){
            vm.pop();
        }
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("POP " + Data.get(0));
    }

}
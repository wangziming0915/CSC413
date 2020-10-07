package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {
        return;
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("LABEL " + Data.get(0));
    }

}
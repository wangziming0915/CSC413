package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {

        Data.add(string);

    }

    @Override
    public void execute(VirtualMachine vm) {
        int offset = (vm.getSizeRunTimeStack()) - Integer.parseInt(Data.get(0));
        vm.newFrameAt(offset);

    }
    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("ARGS " + Data.get(0));
    }
}
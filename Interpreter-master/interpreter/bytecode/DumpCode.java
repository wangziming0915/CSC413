package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class DumpCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {

        switch (Data.get(0)){
            case "ON": vm.DumpOn();
                break;
            case "OFF": vm.DumpOff();
                break;
        }
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("");
    }

}
package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.push(Integer.parseInt(Data.get(0)));
    }

    @Override
    public ArrayList<String> getData() {
        return Data;
    }

    @Override
    public String toString(){

        if(Data.size() == 1){
            return ("LIT " + Data.get(0));
        }
        return ("LIT " + Data.get(0) + " " + Data.get(1) + "    "   + "int " + Data.get(1));
    }

}
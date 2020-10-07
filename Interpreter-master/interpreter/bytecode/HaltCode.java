package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void load(String string){}

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltProgram();
    }

    @Override
    public ArrayList<String> getData(){
        return null;
    }

    @Override
    public String toString(){
        return ("HALT ");
    }


}
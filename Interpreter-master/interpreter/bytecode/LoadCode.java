package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int offset = Integer.parseInt(Data.get(0));
        int loadNum =  vm.load(offset);
        vm.push(loadNum);
    }

    @Override
    public ArrayList<String> getData() {
        return Data;

    }

    @Override
    public String toString(){
        return ("LOAD " + Data.get(0) + " " + Data.get(1) + "    " + "<load " + Data.get(1) + ">" );
    }

}

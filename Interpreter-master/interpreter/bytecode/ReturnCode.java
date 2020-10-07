package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int pc = vm.GetReturnAdd();
        int temp = vm.pop();

        while (vm.getSizeRunTimeStack()  > vm.peekFrame()){
            vm.pop();
        }
        vm.popframe();
        vm.push(temp);
        vm.setPc(pc);
    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString() {

        if (Data.size() == 0) {
            return ("RETURN ");
        } else {
            return ("RETURN " + Data.get(0));
        }
    }
}
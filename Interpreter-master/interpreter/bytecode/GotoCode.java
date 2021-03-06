package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();
    String originalAdd;

    @Override
    public void load(String string) {

        if(Data.size() == 1){
            Data.set(0,string);
        }
        else {
            originalAdd = string;
            Data.add(string);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setPc(Integer.parseInt(Data.get(0))   -  1 );

    }

    @Override
    public ArrayList<String> getData(){
        return Data;
    }

    @Override
    public String toString(){
        return ("GOTO " + originalAdd);
    }



}
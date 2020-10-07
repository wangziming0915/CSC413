package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private ArrayList<String> Data = new ArrayList<>();
    int storeNum;

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {
        storeNum = vm.pop();
        int offset = Integer.parseInt(Data.get(0));
        vm.store(offset,storeNum);
    }

    @Override
    public ArrayList<String> getData() {
        return Data;
    }

    @Override
    public String toString(){

        return ("STORE " + Data.get(0) + " " + Data.get(1) + "    "  + Data.get(1) + "=" + storeNum);
    }

}

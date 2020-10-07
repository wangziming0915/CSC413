package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.HashMap;

public class BopCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();
    private static HashMap<String, Integer> bopTable;

    @Override
    public void load(String string) {
        Data.add(string);
    }

    @Override
    public void execute(VirtualMachine vm) {
        bopTable = new HashMap<>();


        int firstLevel = vm.pop();
        int secondLevel = vm.pop();

        bopTable.put("+", (secondLevel + firstLevel));
        bopTable.put("-", (secondLevel - firstLevel));
        try {
            bopTable.put("/", (secondLevel / firstLevel));
        } catch (ArithmeticException e) {

        }
        bopTable.put("*", (secondLevel * firstLevel));
        bopTable.put("==", ((secondLevel == firstLevel) ? 1 : 0));
        bopTable.put("!=", ((secondLevel != firstLevel) ? 1 : 0));
        bopTable.put("<=", ((secondLevel <= firstLevel) ? 1 : 0));
        bopTable.put(">=", ((secondLevel >= firstLevel) ? 1 : 0));
        bopTable.put(">", ((secondLevel > firstLevel) ? 1 : 0));
        bopTable.put("<", ((secondLevel < firstLevel) ? 1 : 0));
        bopTable.put("|", ((secondLevel | firstLevel)));
        bopTable.put("&", (secondLevel & firstLevel));

        vm.push(bopTable.get(Data.get(0)));
    }

    @Override
    public ArrayList<String> getData() {
        return Data;
    }

    @Override
    public String toString() {
        return ("BOP " + Data.get(0));
    }

}
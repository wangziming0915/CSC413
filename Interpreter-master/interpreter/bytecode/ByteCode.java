package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

abstract public class ByteCode {

    abstract public void load(String string);
    abstract public void execute(VirtualMachine vm);
    public abstract ArrayList<String> getData();

}
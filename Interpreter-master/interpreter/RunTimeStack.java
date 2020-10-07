package interpreter;

import interpreter.bytecode.ArgsCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.DumpCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);
    }

    int size;

    public void dump(ByteCode code) {

        if (code instanceof ArgsCode) {
            size = Integer.parseInt(code.getData().get(0));
            System.out.println(code);
        } else if (code instanceof CallCode) {
            System.out.print(code);
            System.out.print("   ");
            System.out.print("(");
            for (int i = 0; i < size; i++) {
                System.out.print(runTimeStack.get(runTimeStack.size() - 1 - i));
                if (!(i + 1 == size)) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            System.out.println();
        } else {
            System.out.println(code);
        }

        Iterator<Integer> itRun = runTimeStack.iterator();
        Iterator<Integer> itFrme = framePointer.iterator();

        if (!(code instanceof DumpCode)) {
            int index = 0;
            int frameInt = 0;
            boolean dumping = false;
            while (itFrme.hasNext() && frameInt == 0) {
                frameInt = itFrme.next();
            }
            System.out.print("[");
            while (itRun.hasNext()) {
                System.out.print(itRun.next());
                index++;
                if (itRun.hasNext() && index != frameInt) {
                    System.out.print(",");
                }
                if (frameInt == index) {
                    System.out.print("]");
                    dumping = true;
                    if (itRun.hasNext()) {
                        dumping = false;
                        System.out.print("[" + itRun.next());
                        if (itRun.hasNext()) {
                            System.out.print(",");
                        }
                        if (itFrme.hasNext()) {
                            frameInt = itFrme.next();
                        }
                    }
                }
            }
            if (!dumping) {
                System.out.print("]");
            }
            System.out.println();

        }
    }

    public int peek() {
        return (int) runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() {
        int temp = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return temp;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {

        framePointer.add(offset);
    }

    public void popframe() {
        framePointer.pop();
    }

    public void store(int offset, int newNum) {
        runTimeStack.set(offset + framePointer.peek(), newNum);
    }

    public int load(int offset) {
        return (int) runTimeStack.get(offset + framePointer.peek());
    }

    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }

    public int getSizeRunTimeStack() {
        return runTimeStack.size();
    }

    public int peekFrame() {
        return framePointer.peek();
    }
}
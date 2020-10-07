package interpreter;

import interpreter.bytecode.*;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program = new Program();
    private StringTokenizer tok;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab correct class name for the given bytecode from CodeTable
     * create an instance of the bytecode class name returned from code table.
     * Parse any additional arguments for the given bytecode and send them to
     * the newly created bytecode instance via the init function.
     */


    public Program loadCodes() {
        String line, codeClass;

        try {
            while ((line = this.byteSource.readLine()) != null) {
                tok = new StringTokenizer(line);
                codeClass = CodeTable.getClassName(tok.nextToken());
                try {
                    ByteCode ByteInstance = (ByteCode) (Class.forName("interpreter.bytecode." + codeClass).newInstance());

                    while (tok.hasMoreElements()) {
                        ByteInstance.load(tok.nextToken());
                    }

                    this.program.addByte(ByteInstance);
                }
                catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error reading file");
        }

        this.program.resolveAddrs(program);
        return program;
    }
}

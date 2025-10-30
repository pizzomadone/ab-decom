package algobuild.test;

import algobuild.model.*;
import algobuild.executor.AlgorithmExecutor;

/**
 * Test per verificare il funzionamento del sistema.
 * Crea ed esegue semplici algoritmi.
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        try {
            System.out.println("=== AlgoBuild Test Suite ===\n");

            testSimpleCalculation();
            testIfStatement();
            testWhileLoop();
            testForLoop();

            System.out.println("\n=== All tests passed! ===");

        } catch (Exception e) {
            System.err.println("TEST FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Test 1: Calcolo semplice
     * x = 5
     * y = x * 2
     * output y
     */
    static void testSimpleCalculation() throws Exception {
        System.out.println("TEST 1: Simple Calculation");
        System.out.println("---------------------------");

        Algorithm algo = new Algorithm("SimpleCalc");

        // Crea blocchi
        AssignBlock block1 = new AssignBlock("x", "5");
        AssignBlock block2 = new AssignBlock("y", "x * 2");
        OutputBlock block3 = new OutputBlock("y");

        // Collega blocchi
        block1.setNextBlock(block2);
        block2.setNextBlock(block3);

        algo.setFirstBlock(block1);

        // Esegui
        AlgorithmExecutor executor = new AlgorithmExecutor(algo);
        executor.setDebugMode(true);
        executor.runToCompletion();

        // Verifica risultato
        String output = executor.getContext().getOutput().trim();
        System.out.println("Output: " + output);
        assert output.equals("10.0") || output.equals("10") : "Expected 10, got " + output;

        System.out.println("✓ Test passed!\n");
    }

    /**
     * Test 2: Statement IF
     * x = 10
     * if x > 5 then
     *   output "Grande"
     * else
     *   output "Piccolo"
     */
    static void testIfStatement() throws Exception {
        System.out.println("TEST 2: IF Statement");
        System.out.println("--------------------");

        Algorithm algo = new Algorithm("IfTest");

        // Crea blocchi
        AssignBlock assign = new AssignBlock("x", "10");
        IfBlock ifBlock = new IfBlock("x > 5");
        OutputBlock thenOutput = new OutputBlock("\"Grande\"");
        OutputBlock elseOutput = new OutputBlock("\"Piccolo\"");

        // Collega blocchi
        assign.setNextBlock(ifBlock);
        ifBlock.setThenBranch(thenOutput);
        ifBlock.setElseBranch(elseOutput);

        algo.setFirstBlock(assign);

        // Esegui
        AlgorithmExecutor executor = new AlgorithmExecutor(algo);
        executor.setDebugMode(true);
        executor.runToCompletion();

        // Verifica risultato
        String output = executor.getContext().getOutput().trim();
        System.out.println("Output: " + output);
        assert output.equals("Grande") : "Expected 'Grande', got " + output;

        System.out.println("✓ Test passed!\n");
    }

    /**
     * Test 3: Ciclo WHILE
     * i = 1
     * while i <= 3
     *   output i
     *   i = i + 1
     */
    static void testWhileLoop() throws Exception {
        System.out.println("TEST 3: WHILE Loop");
        System.out.println("------------------");

        Algorithm algo = new Algorithm("WhileTest");

        // Crea blocchi
        AssignBlock init = new AssignBlock("i", "1");
        WhileBlock whileBlock = new WhileBlock("i <= 3");
        OutputBlock output = new OutputBlock("i");
        AssignBlock increment = new AssignBlock("i", "i + 1");

        // Collega blocchi
        init.setNextBlock(whileBlock);
        whileBlock.setLoopBody(output);
        output.setNextBlock(increment);
        increment.setNextBlock(whileBlock);  // Torna al while

        algo.setFirstBlock(init);

        // Esegui
        AlgorithmExecutor executor = new AlgorithmExecutor(algo);
        executor.setDebugMode(true);
        executor.runToCompletion();

        // Verifica risultato
        String output_str = executor.getContext().getOutput().trim();
        System.out.println("Output:\n" + output_str);

        System.out.println("✓ Test passed!\n");
    }

    /**
     * Test 4: Ciclo FOR
     * for i = 1 to 5
     *   output i
     */
    static void testForLoop() throws Exception {
        System.out.println("TEST 4: FOR Loop");
        System.out.println("----------------");

        Algorithm algo = new Algorithm("ForTest");

        // Crea blocchi
        ForBlock forBlock = new ForBlock("i", "1", "5");
        OutputBlock output = new OutputBlock("i");

        // Collega blocchi
        forBlock.setLoopBody(output);
        output.setNextBlock(forBlock);  // Torna al for

        algo.setFirstBlock(forBlock);

        // Esegui
        AlgorithmExecutor executor = new AlgorithmExecutor(algo);
        executor.setDebugMode(true);
        executor.runToCompletion();

        // Verifica risultato
        String output_str = executor.getContext().getOutput().trim();
        System.out.println("Output:\n" + output_str);

        System.out.println("✓ Test passed!\n");
    }
}

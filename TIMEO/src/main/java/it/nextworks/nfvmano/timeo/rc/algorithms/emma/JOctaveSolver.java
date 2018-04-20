package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Marco Capitani on 16/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class JOctaveSolver extends Solver {

    private OctaveEngine solver = new OctaveEngineFactory().getScriptEngine();

    private PrintStream devNull = new PrintStream(new OutputStream() {
        @Override
        public void write(int i) throws IOException {
            // Swallow it.
        }
    });

    JOctaveSolver(double[] objective,
                         double[][] eqConstraintM,
                         double[] eqConstraintV,
                         double[] upperBound,
                         double[] lowerBound,
                         double[][] ineqConstraintM,
                         double[] ineqConstraintV) {
        super(objective, eqConstraintM, eqConstraintV, upperBound, lowerBound, ineqConstraintM, ineqConstraintV);
        solver.eval("clear;");
        solver.put("c", convert(c));
        solver.eval("c;");
        solver.put("A", convert(A));
        solver.eval("A;");
        solver.put("b", convert(b));
        solver.eval("b;");
        solver.put("G", convert(G));
        solver.eval("G;");
        solver.put("h", convert(h));
        solver.eval("h;");
        solver.put("lb", convert(l));
        solver.eval("lb;");
        solver.put("ub", convert(u));
        solver.eval("ub;");
    }

    private OctaveDouble convert(double[][] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException("Array of length zero passed to convert.");
        }
        int rows = input.length;
        int columns = input[0].length;
        double[] data = new double[rows*columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i + j*rows] = input[i][j];
            }
        }
        return new OctaveDouble(data, rows, columns);
//        return new OctaveDouble(
//                Arrays.stream(input)
//                        .flatMapToDouble(Arrays::stream)
//                        .toArray(),
//                input.length,
//                input[0].length
//        );
    }

    private OctaveDouble convert(double[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException("Array of lenght zero passed to convert.");
        }
        return new OctaveDouble(
                input,
                input.length,
                1
        );
    }

    @Override
    double[] solve() throws OptimizationFailedException {
        try {
            PrintStream stdOut = System.out;
            PrintStream stdErr = System.err;
//        System.setOut(devNull);
//        System.setErr(devNull);
            solver.eval("A2 = cat(1, A, G);");
            solver.eval("b2 = cat(1, b, h);");
            solver.eval("ctype = repelems([\"S\", \"U\"],[1, 2; size(A)(1), size(G)(1)])';");
            solver.eval("vartype = repelems([\"C\"], [1; size(A)(2)]);");
            solver.eval("param.msglev = 0;");
            solver.eval("[x, f, er, ex] = glpk(c, A2, b2, lb, ub, ctype, vartype, 1, param);");
            double errCode = ((OctaveDouble) solver.get("er")).get(1);
            if (errCode != 0) {
                throw new OptimizationFailedException(
                        String.format("No solution found by joctave solver. Error code: %s", errCode)
                );
            }
            OctaveDouble x = (OctaveDouble) solver.get("x");
            int size = x.getSize()[0];
            double[] output = new double[size];
            for (int i = 0; i < size; i++) {
                output[i] = x.get(i + 1, 1);
            }
            System.setOut(stdOut);
            System.setErr(stdErr);
            return output;
        } finally {
            solver.close();
        }
    }
}

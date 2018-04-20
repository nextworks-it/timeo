package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;

/**
 * Created by Marco Capitani on 16/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
abstract class Solver {

    protected double[] c;
    protected double[][] A;
    protected double[] b;
    protected double[] u;
    protected double[] l;
    protected double[][] G;
    protected double[] h;

    Solver(double[] objective,
                     double[][] eqConstraintM, double[] eqConstraintV,
                     double[] upperBound, double[] lowerBound,
                     double[][] ineqConstraintM, double[] ineqConstraintV) {
        this.c = objective;
        this.A = eqConstraintM;
        this.b = eqConstraintV;
        this.l = lowerBound;
        this.u = upperBound;
        this.G = ineqConstraintM;
        this.h = ineqConstraintV;
    }
    abstract double[] solve() throws OptimizationFailedException;
}

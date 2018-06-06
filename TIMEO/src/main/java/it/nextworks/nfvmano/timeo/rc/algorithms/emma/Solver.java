/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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

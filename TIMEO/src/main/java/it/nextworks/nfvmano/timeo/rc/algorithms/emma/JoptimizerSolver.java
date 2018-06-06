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

import com.joptimizer.optimizers.LPOptimizationRequest;
import com.joptimizer.optimizers.LPOptimizationResponse;
import com.joptimizer.optimizers.LPPrimalDualMethod;

import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marco Capitani on 14/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class JoptimizerSolver extends Solver {

    private static final Logger log = LoggerFactory.getLogger(JoptimizerSolver.class);

    private LPPrimalDualMethod solver = new LPPrimalDualMethod(-1, 1E12);
    private LPOptimizationRequest request = new LPOptimizationRequest();

    JoptimizerSolver(double[] objective,
                     double[][] eqConstraintM, double[] eqConstraintV,
                     double[] upperBound, double[] lowerBound,
                     double[][] ineqConstraintM, double[] ineqConstraintV) {
        super(objective, eqConstraintM, eqConstraintV, upperBound, lowerBound, ineqConstraintM, ineqConstraintV);
        request.setC(c);
        request.setA(A);
        request.setB(b);
        request.setLb(l);
        request.setUb(u);
        request.setG(G);
        request.setH(h);
    }

    @Override
    double[] solve() throws OptimizationFailedException {
        solver.setLPOptimizationRequest(request);
        int returnCode;
        try {
            returnCode = solver.optimize();
        } catch (Exception e) {
            log.error("Cannot compute solution: {}.", e.getMessage());
            log.debug("Error details: ", e);
            throw new OptimizationFailedException("Cannot compute solution.", e);
        }
        if (returnCode == 1) {
            log.warn("Optimization returned a warning.");
        }
        else if (returnCode == 2) {
            log.error("Optimization failed.");
            throw new OptimizationFailedException("Optimization failed.");
        }
        LPOptimizationResponse response = solver.getLPOptimizationResponse();
        return response.getSolution();
    }
}

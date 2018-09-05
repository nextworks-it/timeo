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
package it.nextworks.nfvmano.timeo.rc.algorithms;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TrafficCoefficientParameters {

    String previousStep;
    String currentVM;
    String destinationVM;

    public TrafficCoefficientParameters(String previousStep, String currentVM, String destinationVM) {
        if (null == previousStep) {
            throw new IllegalArgumentException("Previous step must not be null.");
        }
        if (null == currentVM) {
            throw new IllegalArgumentException("Current vm must not be null.");
        }
        if (null == destinationVM) {
            throw new IllegalArgumentException("Destination VM must not be null.");
        }
        this.previousStep = previousStep;
        this.currentVM = currentVM;
        this.destinationVM = destinationVM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficCoefficientParameters that = (TrafficCoefficientParameters) o;

        return previousStep.equals(that.previousStep)
                && currentVM.equals(that.currentVM)
                && destinationVM.equals(that.destinationVM);
    }

    @Override
    public int hashCode() {
        int result = previousStep.hashCode();
        result = 31 * result + currentVM.hashCode();
        result = 31 * result + destinationVM.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Coefficient[prev: %s, current: %s, next: %s]", previousStep, currentVM, destinationVM);
    }
}

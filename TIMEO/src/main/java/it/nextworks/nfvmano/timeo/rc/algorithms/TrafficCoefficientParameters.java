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

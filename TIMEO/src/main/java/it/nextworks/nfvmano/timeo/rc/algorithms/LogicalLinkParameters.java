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
public class LogicalLinkParameters {

    public String sourceNodeId;
    public String previousVMId; // Might be null, for traffic not yet processed.
    public String nextVMId;

    public LogicalLinkParameters(String sourceNodeId, String previousVMId, String nextVMId) {
        if (null == sourceNodeId) {
            throw new IllegalArgumentException("Source node must not be null.");
        }
        if (null == nextVMId) {
            throw new IllegalArgumentException("Next VM must not be null.");
        }
        this.sourceNodeId = sourceNodeId;
        this.previousVMId = previousVMId;
        this.nextVMId = nextVMId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogicalLinkParameters that = (LogicalLinkParameters) o;

        return sourceNodeId.equals(that.sourceNodeId)
                && (previousVMId != null ? previousVMId.equals(that.previousVMId) : that.previousVMId == null)
                && nextVMId.equals(that.nextVMId);
    }

    @Override
    public int hashCode() {
        int result = sourceNodeId.hashCode();
        result = 31 * result + (previousVMId != null ? previousVMId.hashCode() : 0);
        result = 31 * result + nextVMId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("LogicalLink[source: %s, prevVM: %s, nextVM: %s]",
                sourceNodeId, previousVMId, nextVMId);
    }
}

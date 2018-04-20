package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class Table {

    @JsonProperty("opendaylight-flow-statistics:aggregate-flow-statistics")
    public AggregateFlowStatistics aggregateFlowStatistics;

    @JsonProperty("opendaylight-flow-table-statistics:flow-table-statistics")
    public FlowTableStatistics flowTableStatistics;

    @JsonProperty("id")
    public Integer id;

}
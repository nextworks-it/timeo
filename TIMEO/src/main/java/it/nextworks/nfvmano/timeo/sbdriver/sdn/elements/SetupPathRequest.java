package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.Connection;


/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class SetupPathRequest {

    @JsonProperty("connection")
    Connection connection;

    @JsonCreator
    public SetupPathRequest(@JsonProperty("connection") Connection connection) {
        this.connection = connection;
    }

    @JsonProperty("connection")
    public Connection getConnection() {
        return connection;
    }
}

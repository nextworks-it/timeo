package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.BooleanMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.IntegerMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.StringMetadata;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
@JsonSubTypes({
        @Type(value = StringMetadata.class, name = "String"),
        @Type(value = IntegerMetadata.class, name = "Integer"),
        @Type(value = BooleanMetadata.class, name = "Boolean"),
})
public class PnfInstanceMetadata {
	
	

}

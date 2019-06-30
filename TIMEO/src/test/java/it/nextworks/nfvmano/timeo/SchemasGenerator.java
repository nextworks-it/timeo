package it.nextworks.nfvmano.timeo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import org.junit.Test;

import java.io.StringWriter;

/**
 * Created by Marco Capitani on 08/03/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class SchemasGenerator {

    @Test
    public void makeVnfdSchema() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(Vnfd.class);

        StringWriter json = new StringWriter();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(json, jsonSchema);

        System.out.println(json.toString());
    }
}

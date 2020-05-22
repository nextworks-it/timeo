package it.nextworks.nfvmano.timeo.tapi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.client.model.ContextSchema;
import io.swagger.client.model.CreateConnectivityServiceRPCInputSchema;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiTopologyUtilities;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class TestTapiTopologyTranslator {

    @Test
    public void retrieveConnectivityRequestFromFile() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapterFactory(new ValidatorAdapterFactory());

        Gson gson = gsonBuilder.create();
        //Gson gson =  new Gson();
        InputStream in = TestTapiTopologyTranslator.class.getResourceAsStream("/retrieved-obfn-context.json");
        Reader reader  = null;
        try {
            reader = new InputStreamReader(in, "UTF-8");
            ContextSchema contextSchema = gson.fromJson(reader, ContextSchema.class);
            String  result = gson.toJson(contextSchema);
            System.out.println(result);

            TapiTopologyUtilities.translateTapiTopology(contextSchema.getTopologyContext().getTopology().get(0), contextSchema);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NotExistingEntityException e) {
            e.printStackTrace();
        }

    }
}

package it.nextworks.nfvmano.timeo.common.exception;


/**
 * Created by francesca on 19/04/17.
 */
public class RemoteEntityFailureException extends Exception {

        public RemoteEntityFailureException(String type, String url) {
            super("Remote entity " + type + " failed at " + url);
        }

}

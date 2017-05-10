package org.grails.gactions;

import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class DarkerColorRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    public RequestHandler create(RootRequest rootRequest) {
        return new DarkerColorRequestHandler(rootRequest)
    }
}

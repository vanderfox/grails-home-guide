package org.grails.gactions;

import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest;


public class DarkerColorRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    public RequestHandler create(RootRequest rootRequest) {
        return new DarkerColorRequestHandler(rootRequest)
    }
}

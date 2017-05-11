package org.grails.gactions;

import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest;

public class ColorRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    RequestHandler create(RootRequest rootRequest) {
        return new ColorRequestHandler(rootRequest)
    }

}

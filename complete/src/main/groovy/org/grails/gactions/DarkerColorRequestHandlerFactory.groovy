package org.grails.gactions

import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest
import groovy.transform.CompileStatic

@CompileStatic
class DarkerColorRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    RequestHandler create(RootRequest rootRequest) {
        new DarkerColorRequestHandler(rootRequest)
    }
}

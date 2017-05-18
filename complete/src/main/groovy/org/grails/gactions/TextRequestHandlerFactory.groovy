package org.grails.gactions

import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest
import groovy.transform.CompileStatic

@CompileStatic
class TextRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    RequestHandler create(RootRequest rootRequest) {
        new TextRequestHandler(rootRequest)
    }
}

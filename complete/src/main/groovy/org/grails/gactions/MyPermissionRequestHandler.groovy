package org.grails.gactions

import com.frogermcs.gactions.ResponseBuilder
import com.frogermcs.gactions.api.permission.PermissionRequestHandler
import com.frogermcs.gactions.api.request.RootRequest
import com.frogermcs.gactions.api.response.RootResponse
import groovy.transform.CompileStatic

@CompileStatic
class MyPermissionRequestHandler extends PermissionRequestHandler {

    MyPermissionRequestHandler(RootRequest rootRequest) {
        super(rootRequest)
    }

    @Override
    RootResponse getResponse() {
        String msg = 'Hey. I don\'t know your name, but it\'s ok. :) Now tell me something so I could repeat it.'
        if (isPermissionGranted() && userProfile != null) {
            msg = "Hey ${userProfile.given_name} It's nice to meet you! Now tell me something so I could repeat it."
        }
        ResponseBuilder.askResponse(msg)
    }
}

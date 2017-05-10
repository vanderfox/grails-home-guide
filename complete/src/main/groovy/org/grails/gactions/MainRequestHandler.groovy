package org.grails.gactions

import com.frogermcs.gactions.ResponseBuilder
import com.frogermcs.gactions.api.RequestHandler
import com.frogermcs.gactions.api.request.RootRequest
import com.frogermcs.gactions.api.response.RootResponse

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class MainRequestHandler extends RequestHandler {
    protected MainRequestHandler(RootRequest rootRequest) {
        super(rootRequest)
    }

    @Override
    public RootResponse getResponse() {
        return ResponseBuilder.askResponse("Hey, it works! Now tell something so I could repeat it.")
    }
}
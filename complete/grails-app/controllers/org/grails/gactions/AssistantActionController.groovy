package org.grails.gactions

import com.frogermcs.gactions.AssistantActions
import com.frogermcs.gactions.api.StandardIntents
import com.frogermcs.gactions.api.request.RootRequest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader


import javax.servlet.http.HttpServletRequest

class AssistantActionController {

    def index() {
        AssistantActions assistantActions =
                new AssistantActions.Builder(new GrailsResponseHandler(response))
                        .addRequestHandlerFactory(StandardIntents.MAIN, new MainRequestHandlerFactory())
                        .addRequestHandlerFactory(StandardIntents.TEXT, new TextRequestHandlerFactory())
                        .addRequestHandlerFactory(StandardIntents.PERMISSION, new MyPermissionRequestHandlerFactory())
                        .addRequestHandlerFactory("color.intent", new ColorRequestHandlerFactory())
                        .addRequestHandlerFactory("color.darker.intent", new DarkerColorRequestHandlerFactory())
                        .build()
        RootRequest rootRequest = parseActionRequest(request)
        // log to file for debugging
        Writer writer = new FileWriter("/tmp/google-action-request-${System.currentTimeMillis()}-debug.json")
        Gson gson = new GsonBuilder().create()
        gson.toJson(rootRequest, writer)
        writer.flush()
        writer.close()
        assistantActions.handleRequest(rootRequest)
        null // we do not want to return a grails view here the handlers do this

    }

    private RootRequest parseActionRequest(HttpServletRequest request) throws IOException {
        JsonReader jsonReader = new JsonReader(request.getReader())
        return new Gson().fromJson(jsonReader, RootRequest.class)
    }

    def color() {
        AssistantActions assistantActions =
                new AssistantActions.Builder(new GrailsResponseHandler(response))
                        .addRequestHandlerFactory("color.intent", new ColorRequestHandlerFactory())
                        .build()
        RootRequest rootRequest = parseActionRequest(request)
        // log to file for debugging
        Writer writer = new FileWriter("/tmp/google-action-request-color-${System.currentTimeMillis()}-debug.json")
        Gson gson = new GsonBuilder().create()
        gson.toJson(rootRequest, writer)
        writer.flush()
        writer.close()
        assistantActions.handleRequest(rootRequest)
        null // we do not want to return a grails view here the handlers do this

    }
    def darkerColor() {
        AssistantActions assistantActions =
                new AssistantActions.Builder(new GrailsResponseHandler(response))
                        .addRequestHandlerFactory("color.darker.intent", new DarkerColorRequestHandlerFactory())
                        .build()
        RootRequest rootRequest = parseActionRequest(request)
        // log to file for debugging
        Writer writer = new FileWriter("/tmp/google-action-request-color-${System.currentTimeMillis()}-debug.json")
        Gson gson = new GsonBuilder().create()
        gson.toJson(rootRequest, writer)
        writer.flush()
        writer.close()
        assistantActions.handleRequest(rootRequest)
        null // we do not want to return a grails view here the handlers do this

    }
}

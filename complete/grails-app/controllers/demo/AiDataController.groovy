package demo

import ai.api.AIServiceException
import ai.api.model.AIResponse
import org.grails.apiai.AiServiceController

class AiDataController implements AiServiceController {

 def index() {
     try {
         AIResponse aiResponse = request((String)params.query, request.getSession())
         response.setContentType("text/plain")
         response.getWriter().append(aiResponse.result.fulfillment.speech)
     } catch (AIServiceException e) {
         log.error("Error talking to remote service: ${e.message}",e)
     }

 }
}

package by.foranx.makarov.frnx_proj;

import jakarta.validation.Valid;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.Set;
import java.util.Map;
import jakarta.ws.rs.core.Context;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Path("/")
public class PaymentRequestController {

    @Inject
    private Validator validator;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Path("/json")
    @Produces(MediaType.TEXT_HTML)
    public void getJsonPage() throws IOException {
        response.sendRedirect(request.getContextPath() + "/jsp/jsonPage");
    }

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateJson(@Valid PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", "Invalid JSON payload"))
                    .build();
        }

        Set<ConstraintViolation<PaymentRequest>> violations = validator.validate(paymentRequest);

        if (violations.isEmpty()) {
            return Response.ok(Map.of("Error", "0", "MSG", "OK")).build();
        } else {
            StringBuilder violationMessages = new StringBuilder();
            for (ConstraintViolation<PaymentRequest> violation : violations) {
                violationMessages.append(violation.getMessage()).append("; ");
            }
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", violationMessages.toString()))
                    .build();
        }
    }

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateJson(String json) {
        try {
            PaymentRequest paymentRequest = new ObjectMapper().readValue(json, PaymentRequest.class);

            Set<ConstraintViolation<PaymentRequest>> violations = validator.validate(paymentRequest);

            if (violations.isEmpty()) {
                return Response.ok(Map.of("Error", "0", "MSG", "OK")).build();
            } else {
                StringBuilder violationMessages = new StringBuilder();
                for (ConstraintViolation<PaymentRequest> violation : violations) {
                    violationMessages.append(violation.getMessage()).append("; ");
                }
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Map.of("Error", "1", "MSG", violationMessages.toString()))
                        .build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", "Malformed JSON request"))
                    .build();
        }
    }
}

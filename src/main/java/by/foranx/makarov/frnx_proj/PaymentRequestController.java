package by.foranx.makarov.frnx_proj;

import jakarta.validation.Valid;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.Map;

import jakarta.ws.rs.core.Context;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Path("/")
public class PaymentRequestController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentRequestController.class);

    @Inject
    private Validator validator;

//    @Inject
//    private PaymentRequestRepository paymentRequestRepository;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Path("/json")
    @Produces(MediaType.TEXT_HTML)
    public String getJsonPage() throws IOException {
        logger.info("Redirecting to JSON page");
        response.sendRedirect(request.getContextPath() + "/jsp/jsonPage");
        return null;
    }

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateAndSaveJson(@Valid PaymentRequest paymentRequest) {
        logger.info("Received request to validate and save JSON: {}", paymentRequest);

        if (paymentRequest == null) {
            logger.error("Invalid JSON payload: paymentRequest is null");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", "Invalid JSON payload"))
                    .build();
        }

        Set<ConstraintViolation<PaymentRequest>> violations = validator.validate(paymentRequest);

        if (violations.isEmpty()) {
//            paymentRequestRepository.save(paymentRequest);
            logger.info("Successfully saved payment request: {}", paymentRequest);
            return Response.ok(Map.of("Error", "0", "MSG", "OK")).build();
        } else {
            StringBuilder violationMessages = new StringBuilder();
            for (ConstraintViolation<PaymentRequest> violation : violations) {
                violationMessages.append(violation.getMessage()).append("; ");
            }
            logger.error("Validation failed for payment request: {} - Violations: {}", paymentRequest, violationMessages);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", violationMessages.toString()))
                    .build();
        }
    }

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateAndSaveJson(String json) {
        logger.info("Received raw JSON to validate and save: {}", json);
        try {
            PaymentRequest paymentRequest = new ObjectMapper().readValue(json, PaymentRequest.class);

            Set<ConstraintViolation<PaymentRequest>> violations = validator.validate(paymentRequest);

            if (violations.isEmpty()) {
//                paymentRequestRepository.save(paymentRequest);
                logger.info("Successfully saved payment request from raw JSON: {}", paymentRequest);
                return Response.ok(Map.of("Error", "0", "MSG", "OK")).build();
            } else {
                StringBuilder violationMessages = new StringBuilder();
                for (ConstraintViolation<PaymentRequest> violation : violations) {
                    violationMessages.append(violation.getMessage()).append("; ");
                }
                logger.error("Validation failed for raw JSON: {} - Violations: {}", json, violationMessages);
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Map.of("Error", "1", "MSG", violationMessages.toString()))
                        .build();
            }
        } catch (IOException e) {
            logger.error("Malformed JSON request: {}", json, e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("Error", "1", "MSG", "Malformed JSON request"))
                    .build();
        }
    }
}
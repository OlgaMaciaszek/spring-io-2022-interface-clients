package io.spring.barcelona.customerservice;

/**
 * @author Olga Maciaszek-Sharma
 */
public interface VerificationServiceClient {

	CustomerVerificationResult verify(CustomerApplication customerApplication);
}

package io.spring.barcelona.customerservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Olga Maciaszek-Sharma
 */
@FeignClient("verification-service")
public interface VerificationServiceOFClient {

	@PostMapping(path = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	CustomerVerificationResult verify(@RequestBody CustomerApplication customerApplication, @RequestHeader("X-Custom-Header") String customHeader);

}

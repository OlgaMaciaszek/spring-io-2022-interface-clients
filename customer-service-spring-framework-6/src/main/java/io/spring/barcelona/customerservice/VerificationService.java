package io.spring.barcelona.customerservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Rossen Stoyanchev
 */
public interface VerificationService {

	@PostExchange(url = "/verify")
	CustomerVerificationResult verify(@RequestBody CustomerApplication customerApplication);

}

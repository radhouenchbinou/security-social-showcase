package sample.api;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public abstract class ApiBinding {

	protected RestTemplate restTemplate;
	protected RestTemplate restTemplateBIs;

	/**
	 *
	 * @param accessToken
	 */
	public ApiBinding(String accessToken) {
		this.restTemplate = new RestTemplate();
		this.restTemplateBIs = new RestTemplate();

		if (accessToken != null) {
			this.restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
		} else {
			this.restTemplate.getInterceptors().add(getNoTokenInterceptor());
		}
	}

	/**
	 *
	 * @param accessToken
	 * @return
	 */
	private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
		return (request, bytes, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + accessToken);
			return execution.execute(request, bytes);
		};
	}

	/**
	 *
	 * @return
	 */
	private ClientHttpRequestInterceptor getNoTokenInterceptor() {
		return (request, bytes, execution) -> {
			throw new IllegalStateException("Can't access the Facebook API without an access token");
		};
	}

}

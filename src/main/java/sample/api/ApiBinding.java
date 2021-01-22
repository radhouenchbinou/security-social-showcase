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

	public ApiBinding(String accessToken) {
		this.restTemplate = new RestTemplate();
		this.restTemplateBIs = new RestTemplate();
			accessToken="EAAFbzekZCr2wBAAAcjCT6FR1ZBJlbnxt7Do8EP4hvk9NOyRZCjM9GALcy28gu529fknzUKKSZBmy2SXCeMhZCtFcnQWHWZCyOcWTezAzefIHaDExIOEuDUHy17yQbabSVY70bNesmBuPZCsP9UWZArSpZBN7yHAcD8MLw486vt3LoDAZDZD";

		//if (accessToken != null) {
			this.restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
	//	} else {
	//		this.restTemplate.getInterceptors().add(getNoTokenInterceptor());
	//	}
	}
	
	private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
				request.getHeaders().add("Authorization", "Bearer " + accessToken);
				return execution.execute(request, bytes);
			}
		};
	}
	
	private ClientHttpRequestInterceptor getNoTokenInterceptor() {
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
				throw new IllegalStateException("Can't access the Facebook API without an access token");
			}
		};
	}

}

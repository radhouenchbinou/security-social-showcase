package sample.api.facebook;

import java.util.List;

import sample.api.ApiBinding;

public class Facebook extends ApiBinding {

	private static final String GRAPH_API_BASE_URL = "https://graph.facebook.com/v9.0";
	
	public Facebook(String accessToken) {
		super(accessToken);
	}
	
	public Profile getProfile() {

		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me", Profile.class);
	}


	public List<Page> getPages(){
		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me/accounts", PagesList.class).getData();
	}

}

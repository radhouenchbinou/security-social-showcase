package sample.api.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import sample.api.ApiBinding;
import sample.api.facebook.models.Conversation;
import sample.api.facebook.models.Message;
import sample.api.facebook.models.Page;
import sample.api.facebook.models.Profile;

public class Facebook extends ApiBinding {

	private static final String GRAPH_API_BASE_URL = "https://graph.facebook.com/v9.0";
	
	public Facebook(String accessToken) {
		super(accessToken);
	}

	/**
	 *
	 * @return
	 */
	public Profile getProfile() {

		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me", Profile.class);
	}

	/**
	 *
	 * @return
	 */
	public List<Page> getPages(){
		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me/accounts", PagesList.class).getData();
	}

	/**
	 *
	 * @param accessToken
	 * @return
	 */
	public Page getPageDetails(String accessToken){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		//headers.put(HttpHeaders.AUTHORIZATION, Arrays.asList("Bearer " + accessToken));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		return restTemplateBIs.exchange(GRAPH_API_BASE_URL+ "/me?fields=id,name,access_token", HttpMethod.GET, httpEntity, Page.class).getBody();
	}

	/**
	 *
	 * @param accessToken
	 * @return
	 */
	public List<Conversation> getConversations(String accessToken){
		HttpHeaders headers = new HttpHeaders();
		headers.put(HttpHeaders.AUTHORIZATION, Arrays.asList("Bearer " + accessToken));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		return restTemplateBIs.exchange(GRAPH_API_BASE_URL+ "/me/conversations?fields=id,snippet,senders,unread_count", HttpMethod.GET, httpEntity, ConversationsList.class).getBody().getData();

	}

	/**
	 *
	 * @param conversationId
	 * @param accessToken
	 * @return
	 */
	public MessagesList getMessages(String conversationId, String accessToken){
		HttpHeaders headers = new HttpHeaders();
		headers.put(HttpHeaders.AUTHORIZATION, Arrays.asList("Bearer " + accessToken));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		return restTemplateBIs.exchange(GRAPH_API_BASE_URL+ "/"+conversationId+"/messages?fields=from,message,created_time", HttpMethod.GET, httpEntity, MessagesList.class).getBody();
	}

}

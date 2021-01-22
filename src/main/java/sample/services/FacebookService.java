package sample.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sample.api.facebook.ConversationsList;
import sample.api.facebook.Facebook;
import sample.api.facebook.PagesList;
import sample.api.facebook.models.Conversation;
import sample.api.facebook.models.Message;
import sample.api.facebook.models.Page;

import java.util.List;

@Service
public class FacebookService {
    /**
     *
     */
    private Facebook facebook;
    /**
     *
     */
    public FacebookService(Facebook facebook) {
        this.facebook = facebook;
    }
    /**
     *
     * @return
     */
    public List<Page> fetchUserPages(){
        return facebook.getPages();
    }
    /**
     *
     */
    public Page fetchUserPage(String pageId){
        Page page = fetchUserPages().stream().filter(p -> p.getId().equals(pageId)).findFirst().get();
        return facebook.getPageDetails(page.getAccess_token());
    }

    public List<Conversation> fetchConversations(String pageId){
        Page page = fetchUserPages().stream().filter(p -> p.getId().equals(pageId)).findFirst().get();
        return facebook.getConversations(page.getAccess_token());
    }

    public List<Message> fetchMessages(String conversationId, String pageId){
        Page page = fetchUserPages().stream().filter(p -> p.getId().equals(pageId)).findFirst().get();
        return facebook.getMessages(conversationId, page.getAccess_token());
    }
}

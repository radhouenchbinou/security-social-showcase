package sample.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sample.api.facebook.MessagesList;
import sample.services.FacebookService;

@Controller
public class ConversationsController {
    private FacebookService facebookService;

    public ConversationsController(FacebookService facebookService){
            this.facebookService = facebookService;
    }
    /**
     *
     * @param id page id
     * @param model
     * @return
     */
    @GetMapping("/{idPage}/conversations")
    public String conversationsList(@PathVariable("idPage") String id,Model model){
        model.addAttribute("conversationsList", facebookService.fetchConversations(id));
        return "conversationsList";
    }
    /**
     *
     * @param idPage
     * @param idConversation
     * @param model
     * @return
     */
    @GetMapping("/{idPage}/conversations/{idConversation}")
    public String messages(@PathVariable("idPage") String idPage, @PathVariable("idConversation") String idConversation,Model model){
        MessagesList msgList = facebookService.fetchMessages(idConversation,idPage);
        model.addAttribute("messages", msgList);
        return "messages";
    }

}

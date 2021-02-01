package sample.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String conversationsList(@PathVariable("idPage") String id,@RequestParam(name = "nextCursor",defaultValue ="last") String nextCursor, @RequestParam(name = "prevCursor",defaultValue ="first") String prevCursor,Model model){
        model.addAttribute("conversationsList", facebookService.fetchConversations(id,nextCursor,prevCursor));
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
    public String messages(@PathVariable("idPage") String idPage, @PathVariable("idConversation") String idConversation,@RequestParam(name = "nextCursor",defaultValue ="last") String nextCursor, @RequestParam(name = "prevCursor",defaultValue ="first") String prevCursor, Model model){
        MessagesList msgList = facebookService.fetchMessages(idConversation,idPage,nextCursor,prevCursor);
        model.addAttribute("messages", msgList);
        return "messages";
    }

}

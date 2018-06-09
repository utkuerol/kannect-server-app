package com.pse.testserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pse.testserver.Post.Post;
import com.pse.testserver.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ComponentScan(basePackages = "com.pse.testserver.Post.Post")
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;

    ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(value = {"/feed"}, method = RequestMethod.GET)
    @ResponseBody
    public String getPosts(Model model) {

        List<Post> feed = postService.getAllPosts();

        try {
            //Convert object to JSON string
            String feedJson = mapper.writeValueAsString(feed);
            return feedJson;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
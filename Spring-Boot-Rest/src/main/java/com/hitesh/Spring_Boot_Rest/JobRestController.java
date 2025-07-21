package com.hitesh.Spring_Boot_Rest;

import com.hitesh.Spring_Boot_Rest.model.JobPost;
import com.hitesh.Spring_Boot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping(path="jobPosts" , produces = "application/json")

    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String load(){
        service.load();
        return "Success";
    }
}

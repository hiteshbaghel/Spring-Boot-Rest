package com.hitesh.Spring_Boot_Rest.service;

import com.hitesh.Spring_Boot_Rest.model.JobPost;
import com.hitesh.Spring_Boot_Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost)
    {
           //repo.addJob(jobPost);
        repo.save(jobPost);
    }
    public List<JobPost> getAllJobs()
    {
          return repo.findAll(); // return repo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());  //return repo.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
         repo.save(jobPost); //repo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {

        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have experience in Spring Boot", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "React Developer", "Must have experience in React and development ", 2, List.of("JS", "HTML", "React", "UI")),
                new JobPost(3, "Angular Developer", "Must have experience in angular framework", 2, List.of("Angular JS", "Html", "CSS", "MVC")),
                new JobPost(4, "Javascript Developer", "Must have experience in Javascript Advance", 2, List.of("DOM", "JS", "AD. JS", "ASYNC prog.")),
                new JobPost(5, "PHP Developer", "Must have experience in PHP development", 2, List.of("PHP", "Backend knowledge", "API"))
        ));

        repo.saveAll(jobs);
    }
}

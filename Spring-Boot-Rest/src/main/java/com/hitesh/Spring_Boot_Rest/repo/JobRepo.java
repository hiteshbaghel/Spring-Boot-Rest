package com.hitesh.Spring_Boot_Rest.repo;

import com.hitesh.Spring_Boot_Rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class JobRepo {

     List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have experience in Spring Boot", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Java Developer Specialist", "Must have experience in Spring and development ", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"))
    ));
    public List<JobPost> getAllJobs(){
    return jobs;
    }
    public void addJob(JobPost job)
    {
            jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost  getJob(int postId)
    {
        for (JobPost job : jobs)
        {
            if (job.getPostId() == postId)
                return job;
        }
          return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost job : jobs)
        {
            if(job.getPostId() == jobPost.getPostId())
            {
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDesc(jobPost.getPostDesc());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for (JobPost jobpost : jobs)
        {
            if(jobpost.getPostId() == postId)
            {
                jobs.remove(jobpost);
            }
        }
    }
}

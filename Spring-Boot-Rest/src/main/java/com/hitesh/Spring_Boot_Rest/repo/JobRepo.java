package com.hitesh.Spring_Boot_Rest.repo;

import com.hitesh.Spring_Boot_Rest.model.JobPost;
import com.sun.jdi.InterfaceType;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    public List<JobPost> findByPostProfileContainingOrPostDescContaining (String postProfile , String postDesc);







//
//     List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Java Developer", "Must have experience in Spring Boot", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//            new JobPost(2, "React Developer", "Must have experience in React and development ", 2, List.of("JS", "HTML", "React", "UI")),
//             new JobPost(3, "Angular Developer", "Must have experience in angular framework", 2, List.of("Angular JS", "Html", "CSS", "MVC")),
//             new JobPost(4, "Javascript Developer", "Must have experience in Javascript Advance", 2, List.of("DOM", "JS", "AD. JS", "ASYNC prog.")),
//             new JobPost(5, "PHP Developer", "Must have experience in PHP development", 2, List.of("PHP", "Backend knowledge", "API"))
//    ));
//    public List<JobPost> getAllJobs(){
//    return jobs;
//    }
//    public void addJob(JobPost job)
//    {
//            jobs.add(job);
//        System.out.println(jobs);
//    }
//
//    public JobPost  getJob(int postId)
//    {
//        for (JobPost job : jobs)
//        {
//            if (job.getPostId() == postId)
//                return job;
//        }
//          return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for(JobPost job : jobs)
//        {
//            if(job.getPostId() == jobPost.getPostId())
//            {
//                job.setPostProfile(jobPost.getPostProfile());
//                job.setPostDesc(jobPost.getPostDesc());
//                job.setReqExperience(jobPost.getReqExperience());
//                job.setPostTechStack(jobPost.getPostTechStack());
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
//        //jobs.removeIf(jobpost -> jobpost.getPostId() == postId);
//        for (JobPost jobpost : jobs)
//        {
//            if(jobpost.getPostId() == postId)
//            {
//                jobs.remove(jobpost);
//            }
//        }
//    }
}

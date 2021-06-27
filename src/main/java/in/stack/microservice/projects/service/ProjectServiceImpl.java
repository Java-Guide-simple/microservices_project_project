package in.stack.microservice.projects.service;

import in.stack.microservice.projects.model.Project;
import in.stack.microservice.projects.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    //  Adding New Project Record
    @Override
    public Project saveProject(Project project) {
        log.info("Inside ProjectService # saveProject Method");
        return projectRepo.save(project);
    }

    // Displaying All Projects Details
    @Override
    public List<Project> getAllProject() {
        log.info("Inside ProjectService # getAllProject() Method");
        return projectRepo.findAll();
    }

    // Displaying Project Details By ID
    @Override
    public Optional<Project> getProjectById(int id) {
        log.info("Inside ProjectService # getProjectById() Method");
        return projectRepo.findById(id);
    }

    // Updating the Project Details (Sending New Project Details With Existing Project ID)
    @Override
    public Project updateProject(Project project) {
        log.info("Inside ProjectService # updateProject() Method");
        Boolean b = projectRepo.existsById(project.getId());
        Project pro = null;
        if (b) {
            pro = projectRepo.saveAndFlush(project);
        }

        return pro;
    }

    // Deleting Project Record BY ID OF Project
    @Override
    public Boolean deleteProject(int id) {
        log.info("Inside ProjectService # deleteProject() Method");
        Boolean b = projectRepo.existsById(id);
        if (b) {
            projectRepo.deleteById(id);
        }
        return b;
    }
}

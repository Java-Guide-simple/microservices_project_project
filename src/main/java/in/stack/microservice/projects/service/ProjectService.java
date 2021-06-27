package in.stack.microservice.projects.service;

import in.stack.microservice.projects.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    public Project saveProject(Project project);
    public List<Project> getAllProject();
    public Optional<Project> getProjectById(int id);
    public Project updateProject(Project project);
    public Boolean deleteProject(int id);
}

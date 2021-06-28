package in.stack.microservice.projects.controller;

import in.stack.microservice.projects.model.Project;
import in.stack.microservice.projects.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    // Autowiring Service Class Instance

    @Autowired
    private ProjectService projectService;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    // New Project Record Adding
    @ApiOperation(value = "Add New Project Details",
            response = Project.class, tags = "Project")
    @PostMapping("/save")
    public Project save(@RequestBody Project project) {
        log.info("Inside ProjectController # save() Method");
        return projectService.saveProject(project);
    }

    // Displaying Project Details By ID
    @ApiOperation(value = "Get  Project Details By Id",
            response = Project.class, tags = "Project")
    @GetMapping("/get-one/{id}")
    public Optional<Project> getProjectbyId(@PathVariable int id) {
        log.info("Inside ProjectController # getProjectbyId() Method");
        return projectService.getProjectById(id);
    }

    // Displaying All Projects Details
    @ApiOperation(value = "Get All Project Details",
            response = Project.class, tags = "Project")
    @GetMapping("/get-all")
    public List<Project> getAllProjects() {
        log.info("Inside ProjectController # getAllProjects() Method");
        return projectService.getAllProject();
    }

    // Deleting Project Record BY ID OF Project
    @ApiOperation(value = "Delete Project Details By Id",
            response = Project.class, tags = "Project")
    @DeleteMapping("/delete/{id}")
    public String deleteProjectById(@PathVariable int id) {
        log.info("Inside ProjectController # deleteProjectById() Method");
        Boolean b = projectService.deleteProject(id);
        if (b)
            return "Deleted";
        else
            return "Something went Wrong";
    }
    // Updating the Project Details (Sending New Project Details With Existing Project ID)
    @ApiOperation(value = "Update Project Details",
            response = Project.class, tags = "Project")
    @PutMapping("/update")
    public String updateProject(@RequestBody Project project) {
        log.info("Inside ProjectController # updateProject() Method");
        Project updated = projectService.updateProject(project);
        if (updated != null)
            return "Updated";
        else
            return "Not Updated ,Something went Wrong";
    }
}

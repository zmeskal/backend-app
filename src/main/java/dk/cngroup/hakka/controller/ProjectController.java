package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.controller.routes.Routes;
import dk.cngroup.hakka.entity.Project;
import dk.cngroup.hakka.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = Routes.PROJECTS, produces = MediaType.APPLICATION_JSON)
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Project> list() {
        return projectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public Project create(@RequestBody Project project) {
        return projectRepository.save(project);
    }
}

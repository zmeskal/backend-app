package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.controller.routes.Routes;
import dk.cngroup.hakka.entity.Project;
import dk.cngroup.hakka.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Routes.PROJECTS, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private final ProjectRepository projectRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Project> list() {
        return projectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Project create(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project findOne(@PathVariable("id") Long id) {
        return projectRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        projectRepository.delete(id);
    }
}

package dk.cngroup.hakka.domain;

import dk.cngroup.hakka.TestNeo4jContext;
import dk.cngroup.hakka.entity.Project;
import dk.cngroup.hakka.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = {TestNeo4jContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProjectTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void shouldCreateNewProjects() {
        Project project = new Project();
        project.setName("New Project 1");

        projectRepository.save(project);

        assertEquals(project.getName(), "New Project 1");
        assertTrue(project.getId() != null);
    }
}

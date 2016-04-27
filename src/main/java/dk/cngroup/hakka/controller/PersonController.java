package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.controller.routes.Routes;
import dk.cngroup.hakka.entity.Person;
import dk.cngroup.hakka.entity.Project;
import dk.cngroup.hakka.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Routes.PERSONS, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findOne(@PathVariable("id") Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        personRepository.delete(id);
    }
}

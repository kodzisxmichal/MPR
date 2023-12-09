package pl.edu.pjatk.michalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    private final CatService catService;

    @Autowired
    public MyRestController(CatService catService){this.catService = catService;}

    @GetMapping("/greeting")
    public String greeting() {return "Greeting from Spring Boot";}

    @GetMapping("/cat/name/{name}")
    public Cat findByName(@PathVariable("name") String name) {
        return this.catService.findByName(name);
    }

    @GetMapping("/cat/id/{id}")
    public Cat findById(@PathVariable("id") Long id) {
        return this.catService.findById(id);
    }

    @PostMapping("/cat/add")
    public void add(@RequestBody Cat body) {
        this.catService.add(body);
    }

    @DeleteMapping("/cat/delete")
    public void delete(@RequestBody Long id) {
        this.catService.delete(id);
    }

    @PutMapping("/cat/update")
    public void update(@RequestBody Cat body) {
        this.catService.update(body);
    }

    @GetMapping("/cat/filter/name/{name}")
    public List<Cat> filterByName(@PathVariable("name") String name) {
        return this.catService.filterByName(name);
    }

    @GetMapping("/cat/filter/age/{age}")
    public List<Cat> filterByAge(@PathVariable("age") Integer age) {
        return this.catService.filterByAge(age);
    }

    @GetMapping("/cat/all")
    public List<Cat> findAll() {
        return this.catService.findAll();
    }

}

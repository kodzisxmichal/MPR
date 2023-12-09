package pl.edu.pjatk.michalk;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    CatRepository repository;

    public CatService(CatRepository repository){this.repository = repository;}

    public Cat findById(Long id){
        return repository.findById(id).orElse(new Cat("dupa",1));
    }
    public Cat findByName(String name){
        return repository.findByName(name);
    }

    public void add(Cat cat){
        repository.save(cat);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(Cat inputCat){
        Cat cat = findById(inputCat.getId());

        cat.setName(inputCat.getName());
        cat.setAge(inputCat.getAge());

        repository.save(cat);
    }

    public List<Cat> findAll(){
        ArrayList<Cat> result = new ArrayList<>();

        var tmp = repository.findAll().iterator();

        while (tmp.hasNext()) {
            result.add(tmp.next());
        }

        return result;
    }

    public List<Cat> filterByName(String name){
        List<Cat> allCats = findAll();

        return allCats.stream().filter((c)->c.getName().equals(name)).toList();
    }

    public List<Cat> filterByAge(Integer age){
        List<Cat> allCats = findAll();

        return allCats.stream().filter((c)->c.getAge().equals(age)).toList();
    }

}

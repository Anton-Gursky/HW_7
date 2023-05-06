package Task_34.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentsService {

    @Autowired StudentsRepository repo;

    public void save(Students student){
        repo.save(student);
    }

    public List<Students> listAll(){
        return (List<Students>) repo.findAll();
    }

    public Students get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<Students> search(String keyword){
        return repo.search(keyword);
    }
}
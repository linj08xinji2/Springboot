package second.mytest.lover;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
     @Autowired
	 PersonRepostiory personRepostiory;
     @RequestMapping(method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
     public List<Person> findAll(){
    	 return personRepostiory.findAll();
     }
	
}

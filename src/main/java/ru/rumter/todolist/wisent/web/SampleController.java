package ru.rumter.todolist.wisent.web;


import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.rumter.todolist.wisent.dao.SampleDAO;

@RestController
@Lazy
@RequestMapping(value = "/sample")
public class SampleController {

    private final SampleDAO sampleDAO;

    public SampleController(SampleDAO sampleDAO) {
        this.sampleDAO = sampleDAO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "Hello " + sampleDAO.getData(1) + "!";
    }

}

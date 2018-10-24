package ru.rumter.todolist.wisent.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.rumter.todolist.wisent.dao.SampleDAO;

@Controller
@Lazy
public class SampleController {

    private final SampleDAO sampleDAO;

    public SampleController(SampleDAO sampleDAO) {
        this.sampleDAO = sampleDAO;
    }

    @GetMapping("/hello")
    public ModelAndView hello() {
        Map<String, String> model = new HashMap<>();
        model.put("data", sampleDAO.getData(1));
        return new ModelAndView("index", model);
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String edit() {
        sampleDAO.updateData(1, "updated data " + System.currentTimeMillis());

        return "Hello " + sampleDAO.getData(1) + "!";
    }

}

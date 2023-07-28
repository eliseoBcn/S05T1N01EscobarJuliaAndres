package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	   @RequestMapping(value = "/index2")
	   public String index() {
	      return "index";
	   }
}

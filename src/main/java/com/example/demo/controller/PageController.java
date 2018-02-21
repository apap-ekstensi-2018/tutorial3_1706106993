package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
  @RequestMapping("/hello")
  public String index ()
  {
    return "hello";
  }

//	@RequestMapping("/greeting")
//	public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model)
//	{
//    model.addAttribute("name", name);
//		return "greeting";
//	}

  @RequestMapping("/greeting/{name}")
  public String greeting (@PathVariable Optional<String> name, Model model)
  {
    if (name.isPresent()) {
      model.addAttribute("name", name.get());
    } else {
      model.addAttribute("name", "apap");
    }

    return "greeting";
  }

  @RequestMapping("/perkalian")
  public String greeting (@RequestParam(value = "a", required = false, defaultValue = "0") int number, @RequestParam(value = "b", defaultValue = "0") int multiplier, Model model)
  {
    model.addAttribute("number", number);
    model.addAttribute("multiplier", multiplier);
    model.addAttribute("result", number * multiplier);

    return "multiply";
  }
}

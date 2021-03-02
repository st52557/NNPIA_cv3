package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;
import java.util.Random;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Controller
	//@RequestMapping("user")
	public class GreetingControler{

		private final CounterService counterService;
		private final AutoResponse autoResponse;

		public GreetingControler(CounterService counterService, AutoResponse autoResponse) {
			this.counterService = counterService;
			this.autoResponse = autoResponse;
		}


		@RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
		public String reqContactMe(
				@RequestParam(name = "name", required = false) String name, Model model,
				@RequestParam(name = "email", required = false) String email,
				@RequestParam(name = "msg", required = false, defaultValue = "") String msg){

			System.out.println(name);
			if(name != null){
				counterService.add();
			}

			model.addAttribute("name",name);
			model.addAttribute("email",email);
			model.addAttribute("counter", counterService.getCounter());
			model.addAttribute("available",autoResponse.getResponse(msg));

			return "index";
		}

		@RequestMapping(value = "/welcome/{name}", method = {RequestMethod.GET})
		public String reqWelcome(@PathVariable("name") String name, Model model){
			counterService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "welcome";
		}

//		@GetMapping(value = "/greeting2")
//		public String requestGreeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model){
//			counterService.add();
//			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
//			model.addAttribute("counter", counterService.getCounter());
//			return "greeting";
//		}

		public boolean getMyAvailability() {
			Random random = new Random();
			return random.nextBoolean();
		}


	}



}

package hello.springinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Model에서 이거 import 안 쓰면 에러남
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//꼭 해줘야함
public class HelloController {

    @GetMapping("hello") //웹 어플리케이션에서  "/hello"라고 들어오면 이 method를 호출해줌
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello"; // 템플릿 폴더에 있는 html이름과 동일, 그 html파일로 넘어감
    }

    @GetMapping("hello-mvc")//웹 어플리케이션에서  "/hello-mvc"라고 들어오면 이 method를 호출해줌
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
        //ex) http://localhost:10000/hello-mvc?name=hil
    }

    //잘 안씀
    @GetMapping("hello-string")
    @ResponseBody//html body 아님, http에서 헤더와 바디 중 응답 body에 이 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;//name이 spring이면 결과는 hello spring
        //template engine과의 차이는 뷰 없음, 그냥 문자가 그대로 내려감
    }

    @GetMapping("hello-API")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//객체 넘김

    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

package academy.everyonecodes.helloworld.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloWorld {

    public String get() {
        return "Hello World";
    }
}

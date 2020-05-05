package academy.everyonecodes.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Service
@Validated
public class TextService {

    public String returnSameText(@Size(min = 3) String text){
        return text;
    }
}

package academy.everyonecodes.theHotelRoom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {

    private final String messageToEveryone;
    private final String messageToRoom;

    public HotelEndpoint(@Value("${hotel.message.hotel}") String messageToEveryone,
                         @Value("${hotel.message.room}") String messageToRoom) {
        this.messageToEveryone = messageToEveryone;
        this.messageToRoom = messageToRoom;
    }

    @GetMapping
    String get() {
        return messageToEveryone;
    }

    @GetMapping("/room")
    String getRoom() {
        return messageToRoom;
    }
}


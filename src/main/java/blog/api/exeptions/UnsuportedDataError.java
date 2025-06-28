package blog.api.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedDataError extends RuntimeException {
    public UnsuportedDataError(String message) {
        super(message);
    }
}

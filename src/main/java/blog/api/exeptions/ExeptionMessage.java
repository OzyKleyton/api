package blog.api.exeptions;

import java.util.Date;


public record ExeptionMessage(Date timestamp, String message, String details) {}

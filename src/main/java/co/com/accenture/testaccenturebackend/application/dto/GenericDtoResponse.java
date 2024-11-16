package co.com.accenture.testaccenturebackend.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenericDtoResponse {

    private int code;

    private String message;
}

package com.andrusevich.accounts.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMessage;
}

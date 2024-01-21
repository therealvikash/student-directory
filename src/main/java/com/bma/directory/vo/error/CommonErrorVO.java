package com.bma.directory.vo.error;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Component
public class CommonErrorVO {
    @Schema(description = "Specifies the error code")
    private String errorCode;

    @Schema(description = "Specifies the error description")
    private String errorDescription;
}
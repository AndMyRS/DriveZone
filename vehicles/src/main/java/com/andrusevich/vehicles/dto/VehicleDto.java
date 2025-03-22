package com.andrusevich.vehicles.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Vehicles",
        description = "Schema to hold vehicle information"
)
@Data
public class VehicleDto {
    @NotEmpty(message = "Mobile Number cannot be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number should consist of 10 digits")
    @Schema(
            description = "Mobile number of customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "Vin number cannot be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "Vin number should consist of 12 digits")
    @Schema(
            description = "Vin number of the vehicle", example = "548732457654"
    )
    private String vinNumber;

    @NotEmpty(message = "Vehicle type cannot be a null or empty")
    @Schema(
            description = "Type of the vehicle", example = "Truck"
    )
    private String vehicleType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;

}

package com.study.coupon.coupon.application.port.in.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.study.coupon.coupon.domain.CouponType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.stream.Stream;

@Value
public class GenerateCouponCommand {
    @NotNull
    @Min(100)
    @Max(50000)
    Long point;
    @NotNull
    CouponType type;

    @JsonCreator
    public static CouponType by(String value) {
        return Stream.of(CouponType.values())
                .filter(couponType -> couponType.toString().equals(value.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}

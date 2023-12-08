package sn.esmt.inapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RechargingDto {
    private double dataBalance;
    private double callBalance;
    private double smsBalance;
}

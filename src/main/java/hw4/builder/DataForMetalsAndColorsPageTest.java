package hw4.builder;

import enums.Colors;
import enums.Conditions;
import enums.Metals;
import enums.Vegetables;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class DataForMetalsAndColorsPageTest {
    private Integer summaryNumber1;
    private Integer summaryNumber2;
    private List<Conditions> elements;
    private Colors color;
    private Metals metal;
    private List<Vegetables> vegetables;
}
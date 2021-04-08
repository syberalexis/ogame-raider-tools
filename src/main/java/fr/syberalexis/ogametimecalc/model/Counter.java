package fr.syberalexis.ogametimecalc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counter<E, N extends Number> {
    private E element;
    private N counter;
}

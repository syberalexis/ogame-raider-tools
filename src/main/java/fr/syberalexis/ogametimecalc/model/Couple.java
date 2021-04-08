package fr.syberalexis.ogametimecalc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Couple<L, R> {
    private L left;
    private R right;
}

package br.com.guiabolso.junit.second

import spock.lang.Specification
import spock.lang.Unroll

class TypeCalculatorSpec extends Specification {
    
    def calculator

    @Unroll
    def '#typeA is #expected on #typeB'(def typeA, def typeB, def expected) {
        expect:
        expected == calculator.damageFromTo(typeA, typeB)
        
        where:
        typeA   | typeB   | expected
        "Grass" | "Grass" | "Not very effective"
        "Water" | "Water" | "Not very effective"
        "Fire"  | "Fire"  | "Not very effective"
        "Grass" | "Water" | "Super effective"
        "Water" | "Fire"  | "Super effective"
        "Fire"  | "Grass" | "Super effective"
        "Grass" | "Fire"  | "Not very effective"
        "Fire"  | "Water" | "Not very effective"
        "Water" | "Grass" | "Not very effective"
    }
    
    def setup() {
        calculator = new TypeCalculator()
    }

}

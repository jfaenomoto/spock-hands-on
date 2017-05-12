package br.com.guiabolso.junit.second

class TypeCalculator {

    private final static def TYPE_INDEX = ["Grass", "Water", "Fire"]
    
    private final static def TYPE_MATRIX = [
        [-1, 1, -1], // grass
        [-1, -1, 1], // water
        [1, -1, -1]  // fire
    ]
    
    def damageFromTo(String typeA, String typeB) {
        int typeAIndex = TYPE_INDEX.findIndexOf { it == typeA };
        int typeBIndex = TYPE_INDEX.findIndexOf { it == typeB };
        if (TYPE_MATRIX[typeAIndex][typeBIndex] == 0) {
            return "Normal";
        } else if (TYPE_MATRIX[typeAIndex][typeBIndex] == 1) {
            return "Super effective";
        } else {
            return "Not very effective";
        }
    }
}

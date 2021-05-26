package Module2_OOP.ExtraTasks.Lesson11;

public class Answer {
    private String variantA;
    private String variantB;
    private String variantC;
    private String variantD;
    private String rightVariant;

    public Answer(String variantA, String variantB, String variantC, String variantD, String rightVariant) {
        this.variantA = variantA;
        this.variantB = variantB;
        this.variantC = variantC;
        this.variantD = variantD;
        this.rightVariant = rightVariant;
    }

    public String getVariantA() {
        return variantA;
    }

    public void setVariantA(String variantA) {
        this.variantA = variantA;
    }

    public String getVariantB() {
        return variantB;
    }

    public void setVariantB(String variantB) {
        this.variantB = variantB;
    }

    public String getVariantC() {
        return variantC;
    }

    public void setVariantC(String variantC) {
        this.variantC = variantC;
    }

    public String getVariantD() {
        return variantD;
    }

    public void setVariantD(String variantD) {
        this.variantD = variantD;
    }

    public String getRightVariant() {
        return rightVariant;
    }

    public void setRightVariant(String rightVariant) {
        this.rightVariant = rightVariant;
    }
}

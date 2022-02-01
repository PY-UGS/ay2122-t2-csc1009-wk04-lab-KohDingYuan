public class BMI{
    private double weight_MetricToImperial = 0.45359237;
    private double height_MetricToImperial = 0.0254;

    private double weightMetric;
    private double heightMetric;
    private double weightImperial;
    private double heightImperial;

    public BMI(double weightMetric, double heightMetric) {
        this.weightMetric = weightMetric;
        this.heightMetric = heightMetric;

        this.weightImperial = weightMetric * weight_MetricToImperial;
        this.heightImperial = heightMetric * height_MetricToImperial;
    }

    public double getWeightMetric() {
        return weightMetric;
    }
    public double getHeightMetric() {
        return heightMetric;
    }

    public void setWeightMetric(double weightMetric) {
        this.weightMetric = weightMetric;
    }
    public void setHeightMetric(double heightMetric) {
        this.heightMetric = heightMetric;
    }

    public double getBMI(){
        return this.weightImperial/(Math.pow(this.heightImperial, 2));
    }
    public String getBMIRange(){
        double calculatedBMI = this.getBMI();
        if(calculatedBMI < 18.5) return "Underweight";
        else if(18.5 <= calculatedBMI && calculatedBMI < 25) return "Normal";
        else if(25 <= calculatedBMI && calculatedBMI < 30) return "Overweight";
        else return "Obese";
    }
}
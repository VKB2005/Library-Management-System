abstract class FineCalculator{
protected double finePerDay = 1.0;

public abstract double calculateFine(int overdueDays);
public void setFineRate(double fineRate){
this.finePerDay = fineRate;
}
public double getFineRate(){
return finePerDay;
}
}

class StandardFineCalculator extends FineCalculator{
public double calculateFine(int overdueDays) {
return overdueDays > 0 ? overdueDays * finePerDay : 0;
}
}

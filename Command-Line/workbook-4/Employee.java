public class Employee {

    double totalPay;
    double regularHours;
    double overtimeHours;


    Employee (double totalPay, double regularHours, double overtimeHours) {
        this.totalPay = totalPay;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
    }


    public double getTotalPay() {
        return totalPay;
    }
    public double getRegularHours() {
        return regularHours;
    }
    public double getOvertimeHours() {
        return overtimeHours;
    }
}

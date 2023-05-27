public class DateTime extends Date {
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
        else
            this.hour = 0;
        if (minute >= 0 && minute <= 59)
            this.minute = minute;
        else
            this.minute = 0;
    }
    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
        else
            this.hour = 0;
    }
    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59)
            this.minute = minute;
        else
            this.minute = 0;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof DateTime))
            return false;
        if (!super.equals(other))
            return false;
        if (!(this.hashCode() == other.hashCode())){
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        return this.hour == otherDateTime.hour && this.minute == otherDateTime.minute;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hour;
        result = 31 * result + minute;
        return result;
    }
    /** an override to the "toString" method. we used the function string.format to get the
     * requested template: %s: This is a placeholder for a string value.
     * In this case, it represents the result of super.toString(), which represents the
     * date part of the DateTime object - using this call to action : super.toString()
     * that occurs in the parent`s class.
     * @return a string in the format DD/MM/YYYY hh:mm
     */
    @Override
    public String toString() {
        return String.format("%s %02d:%02d",super.toString(), hour, minute);
    }
}
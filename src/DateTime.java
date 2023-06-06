/**
 * The DateTime class represents a date and time with the year, month, day, hour, and minute components.
 * It extends the Date class and provides additional methods for working with date and time.
 */
public class DateTime extends Date {
    private int hour;
    private int minute;
    /**
     * Constructs a DateTime object with the specified year, month, day, hour, and minute.
     * The year, month, and day must follow the rules defined in the Date class.
     * The hour must be between 0 and 23 (inclusive).
     * The minute must be between 0 and 59 (inclusive).
     * If any of the values are outside the valid range, default values are used.
     *
     * @param year   the year component of the date and time
     * @param month  the month component of the date and time
     * @param day    the day component of the date and time
     * @param hour   the hour component of the date and time
     * @param minute the minute component of the date and time
     */
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
    /**
     * Compares this DateTime object to the specified object.
     * The result is true if and only if the argument is not null,
     * represents the same date and time as this DateTime object,
     * and has the same hour and minute values.
     *
     * @param other the object to compare this DateTime against
     * @return true if the given object is equal to this DateTime, false otherwise
     */
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
    /**
     * Returns a hash code value for the DateTime object.
     * The hash code is based on the hash code of the parent class (Date),
     * as well as the hour and minute values of the DateTime object.
     *
     * @return the hash code value for the DateTime object
     */
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
/**
 * The Date class represents a date with the year, month, and day components.
 * It provides methods for creating and manipulating dates.
 */
public class Date {
    private int year;
    private int month;
    private int day;
    /**
     * Constructs a Date object with the specified year, month, and day.
     * The year must be between -3999 and 3999 (inclusive).
     * The month must be between 1 and 12 (inclusive).
     * The day must be between 1 and 31 (inclusive).
     * If any of the values are outside the valid range, default values are used.
     *
     * @param year  the year component of the date
     * @param month the month component of the date
     * @param day   the day component of the date
     */
    public Date(int year, int month, int day) {
        if (year >= -3999 && year <= 3999)
            this.year = year;
        else
            this.year = 0;
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            this.month = 1;
        if (day >= 1 && day <= 31)
            this.day = day;
        else
            this.day = 1;
    }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            this.month = 1;
    }
    /**
     * Compares this Date object to the specified object.
     * The result is true if and only if the argument is not null and represents
     * the same date as this Date object.
     *
     * @param other the object to compare this Date against
     * @return true if the given object is equal to this Date, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Date))
            return false;
        if (!(this.hashCode() == other.hashCode())){
            return false;
        }
        Date otherDate = (Date) other;
        return this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day;
    }
    /**
     The String.format method is used to format the year, month, and day values into the format we need.
     * %04d specifies a four-digit year with leading zeros if necessary,
     * %02d specifies a two-digit month and day with leading zeros if necessary.
     * @return a string in the format DD/MM/YYYY
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}

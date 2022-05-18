package nextdate;

import java.io.IOException;

/**
 * nextday问题.
 * @author Boliang Weng
 */
public class NextDay {
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    public static final int DAY_28 = 28;
    public static final int DAY_29 = 29;
    public static final int DAY_30 = 30;
    public static final int DAY_31 = 31;

    public static final int YEAR_MIN = 1900;
    public static final int YEAR_MAX = 2050;

    public static final int FOUR = 4;
    public static final int HUNDRED = 100;


  /**
   * nextday问题.
   * @param day 天数
   * @param month 月份
   * @param year 年份
   * @return 返回结果字符串
   */
    public String nextDate (final int day, final int month, final int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;
        try {
            String message = null;
            checkParams(day, month, year);
            if (year == YEAR_MAX && month == DECEMBER && day == DAY_31) {
                throw new IOException("超过时间范围");
            }else if (month == DECEMBER && day == DAY_31) {
                nextDay = 1;
                nextMonth = 1;
                nextYear++;
                message =  nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }else if (isLastDay(day, month, year)) {
                nextDay = 1;
                nextMonth++;
                message = nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }else {
                nextDay++;
                message = nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }
            return message;
        }
        catch (IOException e) {
            return "非法参数!";
        }
    }

    /**
     * 判断是否是闰年.
     * @param year 年份
     * @return 返回true或false
     */
    private Boolean isLeapYear (final int year) {
        return (((year % FOUR) == 0) && ((year % HUNDRED) != 0))
                || ((year % (FOUR*HUNDRED)) == 0);
    }

    /**
     *  判断是否是一个月的最后一天.
     * @param day 天数
     * @param month 月份
     * @param year 年份
     * @return 返回true或false
     * @throws IOException 通用错误
     */
    private Boolean isLastDay (
            final int day,
            final int month,
            final int year) throws IOException {
        boolean result = false;

        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                result = day == DAY_31;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                if (day == DAY_31) {
                    throw new IOException("天数不合法");
                }
                result = day == DAY_30;
                break;
            case FEBRUARY:
                if (day >= DAY_30) {
                    throw new IOException("天数不合法");
                }
                if (isLeapYear(year)) {
                    result = day == DAY_29;
                } else if (day == DAY_29) {
                    throw new IOException("天数不合法");
                }else {
                    result = day == DAY_28;
                }
                break;
            default:
                throw new IOException("月份错误");
        }
        return result;
    }

    /**
    *  简单检查年月日的数据合法性.
    * @param day 日
    * @param month 月
    * @param year 年
    * @throws IOException 通用错误
    */
    private void checkParams (
            final int day,
            final int month,
            final int year) throws IOException {
        if (day < 1
                || day >DAY_31
                || month < 1
                || month > DECEMBER
                || year < YEAR_MIN
                || year > YEAR_MAX) {
            throw new IOException("输入范围错误");
        }
    }
}

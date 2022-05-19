package nextdate;

import java.io.IOException;

/**
 * NextDay问题.
 * @author Boliang Weng
 */
public class NextDay {
    /**
    * NextDay问题.
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
            String message;
            checkParams(day, month, year);
            if (year == Constant.YEAR_MAX
                    && month == Constant.DECEMBER
                    && day == Constant.DAY_31) {
                throw new IOException(Constant.ERROR_INPUT);
            }else if (month == Constant.DECEMBER && day == Constant.DAY_31) {
                nextDay = 1;
                nextMonth = 1;
                nextYear++;
                message =  nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }else if (Boolean.TRUE.equals(isLastDay(day, month, year))) {
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
            return Constant.ERROR;
        }
    }

    /**
     * 判断是否是闰年.
     * @param year 年份
     * @return 返回true或false
     */
    private Boolean isLeapYear (final int year) {
        return (((year % Constant.FOUR) == 0)
                && ((year % Constant.HUNDRED) != 0))
                || ((year % (Constant.FOUR * Constant.HUNDRED)) == 0);
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
        boolean result;

        switch (month) {
            case Constant.JANUARY:
            case Constant.MARCH:
            case Constant.MAY:
            case Constant.JULY:
            case Constant.AUGUST:
            case Constant.OCTOBER:
            case Constant.DECEMBER:
                result = day == Constant.DAY_31;
                break;
            case Constant.APRIL:
            case Constant.JUNE:
            case Constant.SEPTEMBER:
            case Constant.NOVEMBER:
                if (day == Constant.DAY_31) {
                    throw new IOException(Constant.ERROR_DAY);
                }
                result = day == Constant.DAY_30;
                break;
            case Constant.FEBRUARY:
                if (day >= Constant.DAY_30) {
                    throw new IOException(Constant.ERROR_DAY);
                }
                if (Boolean.TRUE.equals(isLeapYear(year))) {
                    result = day == Constant.DAY_29;
                } else if (day == Constant.DAY_29) {
                    throw new IOException(Constant.ERROR_DAY);
                }else {
                    result = day == Constant.DAY_28;
                }
                break;
            default:
                throw new IOException(Constant.ERROR_MONTH);
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
                || day >Constant.DAY_31
                || month < 1
                || month > Constant.DECEMBER
                || year < Constant.YEAR_MIN
                || year > Constant.YEAR_MAX) {
            throw new IOException(Constant.ERROR_INPUT);
        }
    }
}

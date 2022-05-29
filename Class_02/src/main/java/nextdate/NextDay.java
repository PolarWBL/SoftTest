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
    public String nextDate(final int day, final int month, final int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;
        try {
            String message;
            checkParams(day, month, year);
            if (year == Cons.YEAR_MAX
                    && month == Cons.DECEMBER
                    && day == Cons.DAY_31) {
                throw new IOException(Cons.ERROR_INPUT);
            } else if (month == Cons.DECEMBER && day == Cons.DAY_31) {
                nextDay = 1;
                nextMonth = 1;
                nextYear++;
                message = nextYear + "年" + nextMonth + "月" + nextDay + "日";
            } else if (Boolean.TRUE.equals(isLastDay(day, month, year))) {
                nextDay = 1;
                nextMonth++;
                message = nextYear + "年" + nextMonth + "月" + nextDay + "日";
            } else {
                nextDay++;
                message = nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }
            return message;
        } catch (IOException e) {
            return Cons.ERROR;
        }
    }

    /**
     * 判断是否是闰年.
     * @param year 年份
     * @return 返回true或false
     */
    private Boolean isLeapYear(final int year) {
        return (((year % Cons.FOUR) == 0)
                && ((year % Cons.HUNDRED) != 0))
                || ((year % (Cons.FOUR * Cons.HUNDRED)) == 0);
    }

    /**
     *  判断是否是一个月的最后一天.
     * @param day 天数
     * @param month 月份
     * @param year 年份
     * @return 返回true或false
     * @throws IOException 通用错误
     */
    private Boolean isLastDay(final int day, final int month,
            final int year) throws IOException {
        boolean result;
        switch (month) {
            case Cons.JANUARY:  case Cons.MARCH:    case Cons.MAY:      case Cons.JULY:
            case Cons.AUGUST:   case Cons.OCTOBER:  case Cons.DECEMBER:
                result = day == Cons.DAY_31;
                break;
            case Cons.APRIL:    case Cons.JUNE:     case Cons.SEPTEMBER:case Cons.NOVEMBER:
                if (day == Cons.DAY_31) {
                    throw new IOException(Cons.ERROR_DAY);
                }
                result = day == Cons.DAY_30;
                break;
            case Cons.FEBRUARY:
                if (day >= Cons.DAY_30) {
                    throw new IOException(Cons.ERROR_DAY);
                }
                if (Boolean.TRUE.equals(isLeapYear(year))) {
                    result = day == Cons.DAY_29;
                } else if (day == Cons.DAY_29) {
                    throw new IOException(Cons.ERROR_DAY);
                } else {
                    result = day == Cons.DAY_28;
                }
                break;
            default:
                throw new IOException(Cons.ERROR_MONTH);
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
    private void checkParams(
            final int day, final int month,
            final int year) throws IOException {
        if (day < 1 || day > Cons.DAY_31
                || month < 1            || month > Cons.DECEMBER
                || year < Cons.YEAR_MIN || year > Cons.YEAR_MAX) {
            throw new IOException(Cons.ERROR_INPUT);
        }
    }
}

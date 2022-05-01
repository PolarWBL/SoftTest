package nextdate;

/**
 * @author Boliang Weng
 */
public class NextDay {

    public String nextDate(int day, int month, int year){
        try {
            checkParams(day, month, year);
            if (isLastDay(day, month, year)) {
                day = 1;
                if (month == 12) {
                    month = 1;
                    if (year == 2050) {
                        throw new RuntimeException("超过时间范围");
                    }
                    year++;
                    return year + "年" + month + "月" + day + "日";
                }
                month++;
                return year + "年" + month + "月" + day + "日";
            }
            day++;
            return year + "年" + month + "月" + day + "日";
        } catch (RuntimeException e) {
            return "非法参数!";
        }

    }

    private Boolean isLeapYear(int year){
        return (((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0);
    }

    private Boolean isLastDay(int day, int month, int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day == 31;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    throw new RuntimeException("天数不合法");
                }
                return day == 30;
            default:
                if (day >= 30) {
                    throw new RuntimeException("天数不合法");
                }
                if (isLeapYear(year)) {
                    return day == 29;
                } else if (day == 29) {
                    throw new RuntimeException("天数不合法");
                }
                return day == 28;
        }
    }

    private void checkParams(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2050) {
                throw new RuntimeException("输入范围错误");
        }
    }
}

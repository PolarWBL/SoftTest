package nextdate;

/**
 * @author wengboliang 2019111413
 */
public class NextDate {
    public String getNextDate(int day, int month, int year){
        int tomorrowDay = day, tomorrowMonth = month, tomorrowYear = year;

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2050) {
            return "非法参数!";
        }

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (day < 31){
                    tomorrowDay = day + 1;
                }else {
                    tomorrowDay = 1;
                    tomorrowMonth = month+1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 30){
                    tomorrowDay = day + 1;
                } else if (day == 30) {
                    tomorrowDay = 1;
                    tomorrowMonth = month + 1;
                }else{
                    return "非法参数!";
                }
                break;
            case 12:
                if (day<31){
                    tomorrowDay = day + 1;
                }else {
                    tomorrowDay = 1;
                    tomorrowMonth = 1;
                    if (year == 2050){
                        return "非法参数!";
                    }else {
                        tomorrowYear = year + 1;
                    }
                }
                break;
            case 2:
                boolean isLeapYear = (((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0);
                if (day<28){
                    tomorrowDay = day + 1;
                }else if (day == 28){
                    if (isLeapYear){
                        tomorrowDay = 29;
                    }else {
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    }
                }else if (day == 29 && isLeapYear){
                    tomorrowDay = 1;
                    tomorrowMonth = 3;
                }else {
                    return "非法参数!";
                }
                break;
            default:
        }

        return  tomorrowYear + "年" + tomorrowMonth + "月" + tomorrowDay + "日";

    }

}

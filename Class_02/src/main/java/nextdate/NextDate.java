package nextdate;

/**
 * @author wengboliang 2019111413
 */
public class NextDate {
    public String getNextDate(int day, int month, int year){
        int tomorrowDay = day, tomorrowMonth = month, tomorrowYear = year;
        boolean c1, c2, c3;
        c1 = (1<=day) && (day<=31);
        c2 = (1<=month) && (month<=12);
        c3 = (1900<=year) && (year<=2050);

        if (!(c1 && c2 && c3)){
            return "非法参数!";
        }

        boolean isLeapYear = (((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0);

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
                }else{
                    tomorrowDay = 1;
                    tomorrowMonth = month + 1;
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
                if (day<28){
                    tomorrowDay = day + 1;
                }else if (day == 28){
                    if (isLeapYear){
                        tomorrowDay = 29;
                    }else {
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    }
                }else{
                    if (isLeapYear){
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    }else {
                        return "非法参数!";
                    }
                }
                break;
            default:
        }

        return  tomorrowYear + "年" + tomorrowMonth + "月" + tomorrowDay + "日";

    }

}

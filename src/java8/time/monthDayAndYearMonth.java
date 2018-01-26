package java8.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

/**
 * @ProjectName: java_basics
 * @Package: java8.time
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/26/026 20:11
 * @UpdateDate: 2018/1/26/026 20:11
 */
public class monthDayAndYearMonth {

    public static void main(String[] args) {

        //MonthDay类仅包含日月信息，不包含年，用于检查特定日期，日生日，节日等
        MonthDay birthDay = MonthDay.of(10,12);
        System.out.println(MonthDay.now().equals(birthDay)?"Today isyour birthday!!!":"Today is not your birthday");

        //从某一日期获取MonthDay
        LocalDate dateOfBirth = LocalDate.of(2000,2,29);
        MonthDay specialDay = MonthDay.from(dateOfBirth);

        //检查某年是否含有该日期
        System.out.println(specialDay.isValidYear(1990));

        //YearMonth 用于检查信用卡过期信息等
        System.out.println(YearMonth.of(2020, Month.AUGUST));

    }
}

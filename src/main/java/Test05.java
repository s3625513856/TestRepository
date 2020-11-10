import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test05 {
    public static void main(String[] args) throws ParseException {
        //解析excel 日期 变为数值（与1899-12-30）相差的天数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = sdf.parse("9999-12-12");
        String date = "1899-12-30";
        Date parse2 = sdf.parse(date);
        long ll = parse1.getTime()-parse2.getTime();
        long ll1 = ll/(1000*60*60*24);
        System.out.println(ll1);
    }
}

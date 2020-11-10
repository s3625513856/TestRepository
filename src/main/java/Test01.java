import com.sun.deploy.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
    public static void main(String[] args) throws ParseException {

        String str = "2007-11-31";

        String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        boolean dateFlag = m.matches();
        if (!dateFlag) {
            System.out.println("格式错误1");
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try{
            Date date = formatter.parse(str);
            System.out.println(date);
            System.out.print("格式正确！");
        }catch(Exception e){
            System.out.println("格式错误2！");
        }
/*        String str ="-1.26ea-03";
        str =str.trim();

        if (null == str || "".equals(str)) {
            System.out.println(false);;
        }
        String regx = "[+-]*\\d+\\.?\\d*[Ee]*[+-]*\\d+";
        Pattern pattern = Pattern.compile(regx);
        boolean isNumber = pattern.matcher(str).matches();
        if (isNumber) {
            System.out.println(isNumber);
        }
        regx = "^[-\\+]?[.\\d]*$";
        pattern = Pattern.compile(regx);
        System.out.println(pattern.matcher(str).matches());*/
    }
}

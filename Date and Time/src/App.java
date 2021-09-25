import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args)  {
        Date watch= new Date();

        System.out.println(watch.toString());//returns today's date

        SimpleDateFormat sf= new SimpleDateFormat("E MM,dd,yyyy 'at' ss,mm,hh a zzz "); //setting format

        System.out.println(sf.format(watch));
        

    }
}

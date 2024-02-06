package expectedResult;

public class ExpectedResult {
   public static final String SUCCESS_MESSAGE = "Your tire quote was sent.";
   public static String tire_id = "SXJvbm1hbnx8OTEwNjR8fHRlc3RmZWVkfHwxNDcxNnx8Qg%3D%3D";  //Base64 decoded tire_id - Ironman|91064|testfeed||14716||B // це тестовий тайр ід  //якщо не буде екзепшн він буде потрібен

    //ці змінні для перевірки сабтоталу на сторінці суммарі, я їх захардкодив, в ідеалі вони повинні бути взяті з бази даних і повинні розраховуватися автоматично, але
    //тут в мене фантазія так розігралася, а часу немає((

   public static String Subtotal1 = ("79.75"); //це сабтотал для 1 тайра
public static String Subtotal2 = ("144.50"); //це сабтотал для 2 тайрів
public static String Subtotal3 = "209.25"; //це сабтотал для 3 тайрів
public static String Subtotal4 = "274.00"; //це сабтотал для 4 тайрів
public static String Subtotal5 = "338.75"; //це сабтотал для 5 тайрів
public static String Subtotal4WithOptionalService = "294.00"; //це сабтотал для 4 тайрів + сервіс

   //////////////////////////////Tires Properties////////////////////////////
   public final static String MODEL_NAME1 = "RB-12";
   public final static String MODEL_NAME2 = "IMOVE";
   public final static String MODEL_NAME3 = "RP18";
   public final static String BRAND_IN_IMAGE1 = "Ironman Tire.";

   public final static String BRAND_IN_IMAGE2 = "Ironman Tire.";

   public final static String BRAND__IN_IMAGE3 = "Westlake Tire.";

   public final static String WARRANTY0 = "N/A";
    public final static String WARRANTY1 = "70000KM";

    public final static String PART_NUMBER1 = "91064";
    public final static String PART_NUMBER2 = "72017";
    public final static String PART_NUMBER3 = "38076";
    public final static Integer PRICE1 = 79;

}

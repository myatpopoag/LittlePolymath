package com.larkium.littlepolymath;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class QuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "Quiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 4;
    //Table name
    private static final String TABLE_NAME = "Q";
    //Id of question
    private static final String UID = "_UID";
    //Title of question
    private static final String TITLE = "TITLE";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //Explanation
    private static final String EXP = "EXP";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +TITLE+ " VARCHAR(255), "+ QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255),"+EXP+" VARCHAR(500));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    QuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<QuizQuestion> arraylist = new ArrayList<>();

        arraylist.add(new QuizQuestion("ကမ္ဘာ့တိုက်ကြီးများ", "ကမ္ဘာ့အကြီးဆုံးတိုက်မှာ မည်သည့်တိုက်ဖြစ်သနည်း။", "အာရှတိုက်", "မြောက်အမေရိကတိုက်", "အာဖရိကတိုက်", "ဥရောပတိုက်", "အာရှတိုက်","အာရှတိုက်သည် လူဦးရေအများဆုံးနှင့် အကြီးဆုံး တိုက်ဖြစ်ပါသည်။ကမ္ဘာ့ အရှေ့ခြမ်းတွင်တည်ရှိပြီး နိုင်ငံပေါင်း ၄၈ နိုင်ငံဖြင့် ဖွဲ့စည်းထားပါသည်။"));

        arraylist.add(new QuizQuestion("သင်္ချာ","လွန်ခဲ့သော သုံးနှစ်က မောင်ဘသည် မောင်မြထက်အသက်(၅)နှစ်ပိုကြီးသည်။ ယခုလက်ရှိအချိန်တွင် မောင်ဘနှင့် မောင်မြသည် အသက်မည်မျှပိုကြီးသနည်း။", "၃နှစ်", "၅နှစ်", "၈နှစ်", "၁၀နှစ်", "၅နှစ်","လွန်ခဲ့သော ၃ နှစ်တွင် မောင်ဘသည် မောင်မြထက်အသက်(၅)နှစ်ပိုကြီးခဲ့လျှင် ယခုအချိန်တွင်လည်း အသက်ကွာခြားမှုမှာ (၅)နှစ်ပင်ဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("တူရိယာများ","သာမန် Guitar(ဂီတာ)တစ်လုံးတွင် ကြိုးမည်မျှပါဝင်သနည်း။","၅ကြိုး","၆ကြိုး","၇ကြိုး","၈ကြိုး","၆ကြိုး","စံပြဂီတာ တစ်လုံးတွင် ကြိုး ၆ ကြိုးပါဝင်ပြီး ၄၊ ၇၊ ၈၊ ၉၊ ၁၀၊ ၁၁၊ ၁၂၊ ၁၃ ကနေ ၁၈ကြိုးအထိ တပ်ဆင်အသုံးပြုနိုင်သော ဂီတာများလည်းရှိပါသည်။"));

        arraylist.add(new QuizQuestion("စာချုပ်များ","မည်သည့်ခုနှစ်တွင် ပင်လုံစာချုပ် ချုပ်ဆိုခဲ့သနည်း။","၁၉၄၅","၁၉၄၆","၁၉၄၇","၁၉၄၈","၁၉၄၇","၁၉၄၇ခုနှစ် ဖေဖော်ဝါရီလ ၁၂ရက်တွင် ရှမ်းပြည်နယ်တောင်ပိုင်း ပင်လုံမြို့၌ တိုင်းရင်းသားလူမျိုးများအားလုံး သွေးစည်းညီညွတ်ခြင်းအထိမ်းအမှတ်အဖြစ်ချုပ်ဆိုခဲ့သော စာချုပ်ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အဆောက်အဦးများ","ကမ္ဘာ့အမြင့်ဆုံး အဆောက်အဦးမှာ","Shanghai Tower","One World Trade Center","Makkah Clock Tower","Burj Khalifa","Burj Khalifa","Burj Khalifa သည် အာရပ်စော်ဘွားများပြည်ထောင်စု တွင်တည်ရှိသော မိုးမျှော်တိုက် ဖြစ်ပြီး ၂၀၁၀တွင်ဖွင့်လှစ်ကာ အမြင့် ၈၂၉.၈ မီတာရှိပါသည်။"));

        arraylist.add(new QuizQuestion("နည်းပညာ","မည်သည့် Programming Language သည် Applet Program များကိုဖန်တီးရာတွင် အသုံးပြုသနည်း။","COBOL","C Language","BASIC","Java","Java","Applet program သည် web browser များတွင် embedded ပြုလုပ်နိုင်သော Java program တစ်မျိုးဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အနုပညာ","Ed Sheeran ရေးသားခဲ့သော သီချင်းတစ်ပုဒ်မှာ","Love Story","Supermarket Flowers","Story of My Life","We own the night","Supermarket Flowers","\"Supermarket flowers\"သီချင်းသည် အမေရိကန် တေးရေး တေးဆို Ed Sheeran ၏ သုံးခုမြောက် albumဖြစ်သော \"divide ÷\"၂၀၁၇ တွင်ပါဝင်သော သီချင်းတစ်ပုဒ်ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","ဧရာဝတီမြစ်၏ မြစ်ခွဲတစ်စင်းမှာ","ဖျာပုံမြစ်","မြစ်သာမြစ်","ရွှေကျင်မြစ်","သောင်ရင်းမြစ်","ဖျာပုံမြစ်","ဧရာဝတီမြစ်တွင် မြစ်ခွဲ ၉ စင်းရှိပြီး မြစ်ကျဉ်း ၄ ခုရှိပါသည်။"));

        arraylist.add(new QuizQuestion("အားကစား","Davis Cup သည် မည်သည့် အားကစားနည်းတွင်ပေးအပ်သော ဆုဖလားဖြစ်သနည်း။","Football","Swimming","Hockey","Tennis","Tennis","Davis ဖလားသည် နိုင်ငံတကာ အမျိုးသား tennis ပြိုင်ပွဲတွင်ပေးအပ်သော ဆုဖလားဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အထိမ်းအမှတ်နေ့များ","World Cancer Day မှာ မည်သည့်နေ့ဖြစ်သနည်း။","February 2","February 3","February 4","February 5","February 4","World Cancer Day ကို February လ 4ရက်နေ့အဖြစ် ကင်ဆာရောဂါကို နားလည်သဘောရန်၊ ကြိုတင်ကာကွယ်တားဆီးနိုင်ရန် နှင့် ကုသပျောက်ကင်း စေရန် ရည်ရွယ်၍ နိုင်ငံတကာမှ သတ်မှတ်ခဲ့ခြင်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ဆိုရိုးစကား","ပုပ်မှပေါ်၊________။","ဟုတ်မှကျော်","လုပ်မှမော်","လုပ်မှကျော်","ဟုတ်မှမော်","လုပ်မှကျော်","ပုပ်မှပေါ်၊ လုပ်မှကျော်။"));

        arraylist.add(new QuizQuestion("ကာတွန်းဇာတ်ကောင်များ","Donal Duck ဇာတ်ကောင်ကို မည်သည့် ထုတ်လုပ်ရေးကုမ္ပဏီမှ ဖန်တီးခဲ့သနည်း။","Warner Bros.","DreamWorks Pictures","Universal Pictures","Walt Disney Pictures","Walt Disney Pictures","Donal Duck ကာတွန်းဇာတ်ကောင်ကို 1934ခုနှစ်တွင် Walt Disney production မှ ဖန်တီးခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("ရူပ‌ဗေဒ","အောက်ပါတို့မှ Scalar quantityကို ရွေးချယ်ပါ။","Velocity","Displacement","Speed","Force","Speed","Speed နှင့် Temperature တို့သည်ထင်ရှားသော scalar quatityများဖြစ်ကြသည်။ "));

        arraylist.add(new QuizQuestion("အတိုကောက်စကားလုံးများ","UFO ၏ အရှည်ကောက်မှာ","Unknown Flighting Object","Unidentified Flying Object","Unidentified Finding Operator","Unknown Files Organizer","Unidentified Flying Object","Unidendified Flying Object ဆိုသည်မှာ ရုတ်တရက်ကြည့်ရုံနှင့် ခွဲခြားသိမြင်၍မရနိုင်သော လေကြောင်းဖြစ်စဉ် အဖြစ်လူသိများသော အသုံးအနှုန်းဖြစ်ပါသည်။  အမည်မသိပျံသန်းနေသောအရာ ပန်းကန်ပြားပျံ ဟုလည်းလူသုံးများပါသည်။"));

        arraylist.add(new QuizQuestion("အခေါ်အဝေါ်များ","အစာအိမ်ရောဂါ၏ အမည်မှာ","Diabete","Typhoid","Gastric","Diarrhea","Gastric","စိတ်ဖိစီးမှုများခြင်း၊ ပုံမမှန်သော စားသောက်နည်းစနစ် များသည် အစာအိမ်ရောဂါဖြစ်စေပါသည်။"));

        arraylist.add(new QuizQuestion("အားကစား","2008 Summer Olympic ကိုမည်သည့်မြို့တွင် ကျင်းပခဲ့သနည်း။","Beijing","Rio de Janeiro","London","Tokyo","Beijing","2008 Summer Olympic ကို တရုတ်နိုင်ငံ Beijing မြို့တွင်ကျင်းပခဲ့ပြီး နိုင်ငံပေါင်း ၂၀၄နိုင်ငံ ပါဝင်ယှဉ်ပြိုင်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("အထိမ်းအမှတ်နေ့များ","အမေရိက နိုင်ငံ၏ လွတ်လပ်ရေးနေ့မှာ","March 3","July 9","July 4","August 6","July 4","လွတ်လပ်ရေးနေ့ကြေညာခြင်းကို ၁၇၇၆ခုနှစ် July ၄ ရက်နေ့တွင် စတင်သတ်မှတ်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("Grammar","We've been waiting for ages!The food______be ready by now.","can't","may","must","might","must","We use modal verbs like must, may, might, could and can't to say how sure we are about something. We use 'must' when we feel very sure. "));

        arraylist.add(new QuizQuestion("Chemistry","အောက်ပါ elementများတွင် Noble gasမဟုတ်သောelement မှာ","Helium","Chlorine","Argon","Krypton","Chlorine","Chlorine သည် Highly reactive ဖြစ်သည့်အတွက် Noble gas မဟုတ်သောelement တစ်ခု ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အနုပညာ","ကမ္ဘာ့‌ဈေးအကြီးဆုံး ဓာတ်ပုံ၏ အမည်မှာ","Rhein II","Phantom","Spiritual America","Dead Troops Talk","Phantom","Phantom အမည်ရှိ ဓာတ်ပုံသည် Austrilian ဓာတ်ပုံပညာရှင် Peter Lik ၏ ထင်ရှားသော အနုပညာလက်ရာဖြစ်ပြီး အမေရိကန် ဒေါ်လာ ၆၅ million တန်ဖိုးရှိပါသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","မြန်မာနိုင်ငံမှ တရုတ်နိုင်ငံသို့ သွားရောက်နိုင်သော လမ်းအမည်မှာ","ကော့ကရိတ်လမ်း","တမူးလမ်း","တာပိန်လမ်း","အများတောင်ကြားလမ်း","တာပိန်လမ်း","မြန်မာနိုင်ငံမှ တရုတ်နိုင်ငံသို့ သွားရောက်နိုင်သော လမ်းမကြီးများ မှာ တာပိန်လမ်း၊ နမ်တင့်လမ်း၊ ရွှေလီလမ်း နှင့် တရုတ်-မြန်မာလမ်းမကြီး တို့ဖြစ်ကြသည်။"));

        arraylist.add(new QuizQuestion("တီထွင်မှုများ","Penicillin(ပင်နီဆီလင်)ဆေးကို ရှာဖွေတွေ့ရှိသူမှာ","Edward Jenner","Robert Koch","Alexander Fleming","Ernst Chain","Alexander Fleming","Penicillin ကဲ့သို့ ပထမဆုံး ပဋိဇီဝ ဆေးကို London မြို့ St.Mary's ဆေးရုံ၏ ဗက်တီးရီးယားဗေဒ ပါမောက္ခ Alexandar Fleming ကရှာဖွေတွေ့ရှိခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("ဘာသာရပ်များ","အာကာသဆိုင်ရာ အရာဝတ္ထုများနှင့် ဖြစ်စဉ်များကိုလေ့လာသော ဘာသာရပ်မှာ","Astronomy","Autonomy","Aeronomy","Agronomy","Astronomy","Astronomy(နက္ခတ္တဗေဒ)သည် Cosmic background radiation ကဲ့သို့ ကမ္ဘာ့လေထု၏အပြင်ဘက် အာကာသဖြစ်စဉ်များ နှင့် ကြယ်များ၊ဂြိုဟ်များ၊ကြယ်တံခွန်များ နှင့်နဂါးငွေ့တန်းများ ကိုလေ့လာသောဘာသာရပ်ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("Company များ","Ford Motor company မှာ မည့်သည့်နိုင်ငံမှ ဖြစ်သနည်း။","Korea","Japan","USA","Germany","USA","Ford Motor company သည် အမေရိကန် မော်တော်ကား ကုမ္ပဏီဖြစ်ပြီး ၁၉၀၃ခုနှစ် ဇွန်လ ၁၆ရက်နေ့တွင် Henry Fordမှ တည်ထောင်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("နည်းပညာ","Elon Musk နှင့် မသက်ဆိုင်သော အရာမှာ","SpaceX","Paypal","Amazon","Tesla","Amazon","စွန့်ဦးတီထွင်သူ Elon Musk သည် SpaceX, Paypal , Tesla ကဲ့သို့ ကမ္ဘာကျော် ကုမ္ပဏီများတွင် Founder,co-founder, chairman စသည်ဖြင့်တာဝန်ထမ်းဆောင်လျက်ရှိပြီး Neuralink, The Boring Company, Zip2, OpenAI, SolarCity အဖွဲ့အစည်းများတွင်လည်း သက်ဆိုင်ရာ ရာထူးများကို ပိုင်ဆိုင်ထားပါသည်။"));

        arraylist.add(new QuizQuestion("အနုပညာ","IMDb rating အမြင့်ဆုံးရရှိထားသော ဇာတ်ကားမှာ","Titanic","The Shawshank Redemption","Avatar","Avengers:Endgame","The Shawshank Redemption","The Shawshank Redemption ဇတ်ကားသည် အမေရိကန် Drama ဇာတ်ကားတစ်ကားဖြစ်ပါသည်။ ၁၉၉၄ ခုနှစ်တွင် ထွက်ရှိခဲ့ပြီး IMDb rating 9.3/10 ရရှိထားသော ဇာတ်ကားကောင်းတစ်ကားဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","၂၀၁၄ UNESCO ကမ္ဘာ့အမွေအနှစ် စာရင်းဝင် အမွေအနှစ်မှာ","ဝေသာလီ","ပုဂံ","ပျူရှေးဟောင်းမြို့များ","မိုင်မော","ပျူရှေးဟောင်းမြို့များ","UNESCO မှ ပျူရှေးဟောင်းမြို့များ ကို ကမ္ဘာ့အမွေအနှစ် စာရင်းဝင်အဖြစ် ၂၀၁၄ခုနှစ်တွင် သတ်မှတ်ခဲ့ပြီး  ၂၀၁၉ခုနှစ်တွင် ပုဂံ ကိုလည်း ထည့်သွင်းသတ်မှတ်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("နိုင်ငံများ","ဘုရင်မ အုပ်ချုပ်သော နိုင်ငံမှာ","Norway","Oman","Denmark","Belgium","Denmark","ဘုရင်မ Margrathe II သည် Denmark နိုင်ငံ၏ ဒုတိယမြောက် သက်တမ်းအကြာဆုံး ဧကရာဇ် အဖြစ် တာဝန်ထမ်းဝန်ထမ်းဆောင်ဆဲ ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("သမ္မတများ","မြန်မာနိုင်ငံ၏ ပဉ္စမမြောက် သမ္မတမှာ","ဦးစန်းယု","မန်းဝင်းမောင်","ဦးနေဝင်း","ဦးစန်းလွင်","ဦးစန်းယု","ဦးစန်းယုသည် ၁၉၈၁ခုနှစ် နိုဝင်ဘာ ၉ရက်မှ ၁၉၈၈ခုနှစ် ဇူလိုင် ၂၅ရက်အထိ မြန်မာနိုင်ငံ၏ ပဉ္စမမြောက် သမ္မတ အဖြစ် တာဝန်ထမ်းဆောင်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("ဝတ္ထုများ","အရသာမတူသော ပန်းသီးများစာအုပ်ကို မည်သူရေးသားခဲ့သနည်း။","တင့်‌ဇော်","လူခါး","မနီတာ","ဖေမြင့်","တင့်‌ဇော်","စာရေးသူ တင့်ဇော်သည် ၂၀၁၇ခုနှစ်တွင် \"အရသာမတူသော ပန်းသီးများ\"စာအုပ်ဖြင့် အမျိုးသားစာပေဆုရရှိခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("အတိုင်းအတာများ","၁ ဖာလုံတွင် မည်မျှ သံကြိုးရှိသနည်း။","၉","၁၀","၁၁","၁၂","၁၀","၂၂ လက်မ  ၁ သံကြိုး ၁၀သံကြိုး  ၁ ဖာလုံ ၈ဖာလုံ ၁ မိုင်"));

        arraylist.add(new QuizQuestion("ဂြိုဟ်များ","ကျွန်ုပ်တို့ နေအဖွဲ့အစည်းတွင် ဂြိုဟ်မည်မျှ ရှိသနည်း။","၉","၈","၇","၁၀","၈","ကျွန်ုပ်တို့ နေအဖွဲ့အစည်းတွင် Mercury, Venus, Earth, Mars Jupiter, Saturn, Uranus နှင့် Neptune ဟူ၍ ဂြိုဟ်ကြီး ၈လုံး လည်ပတ်နေပါသည်။"));

        arraylist.add(new QuizQuestion("လူပုဂ္ဂိုလ်များ","First Man ရုပ်ရှင်ဇာတ်ကားသည် မည်သည့် ပုဂ္ဂိုလ်အကြောင်းမှတ်တမ်းတင်သည့် ဇာတ်ကားဖြစ်သနည်း။","Bill Clinton","Barack Obama","Alfred Nobel","Neil Armstrong","Neil Armstrong","First Man ရုပ်ရှင်ဇာတ်ကားသည် အာကာသယာဉ်မှူး Neil Armstrong ၏ဘဝအကြောင်းနှင့် သူ၏ကမ္ဘာကျော် mission လပေါ်တွင် လမ်းလျှောက်ခြင်းအကြောင်း ရိုက်ကူးထားသော Drama/Sci-fi အမျိုးအစား ဇာတ်ကားဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အားကစား","ဘောလုံးကွင်းရှိ ဂိုးတိုင်(Goalpost)၏ အမြင့်မှာ","၇ပေခွဲ","၈ပေ","၇ပေ","၈ပေခွဲ","၈ပေ","ဘောလုံးကွင်းရှိ ဂိုးတိုင်(Goalpost)တစ်ခု ၏ အမြင့်မှာ ၈ပေရှိပြီး အနံမှာ ၂၄ပေရှိပါသည်။"));

        arraylist.add(new QuizQuestion("သမိုင်း","အမေရိကန်စစ်တပ် ပါဝင်ပက်သက်သော စစ်ပွဲများတွင်ဒုတိယမြောက် အရှည်ကြာဆုံး စစ်ပွဲမှာ","Iraq War","American Revolution War","Vietnam War","War in Afghanistan","Vietnam War","Vietnam War သည် ဒုတိယမြောက်အရှည်ကြာဆုံးစစ်ပွဲဖြစ်ပြီး ၁၉၅၅/၁၁ မှ ၁၉၇၃/၄ အထိကြာမြင့်ခဲ့ပါသည်။ ပထမမြောက် အရှည်ကြာဆုံးမှာ War in Afghanistan ဖြစ်ပြီး ၂၀၀၁/၁၀ မှ ယနေ့တိုင် ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("Grammar","He's going to_____ university in September to study Shakespeare.","(no article)","a","an","the","(no article)","We don't use articles with some places like 'university' when we are talking about them being used for their normal purpose."));

        arraylist.add(new QuizQuestion("သမ္မတများ","ကမ္ဘာ့ပထမဦးဆုံး အမျိုးသမီး သမ္မတမှာမည်သည့်နိုင်ငံမှဖြစ်သနည်း။","Israel","Argentina","China","Brazil","Argentina","ကမ္ဘာ့ပထမဦးဆုံး အမျိုးသမီး သမ္မတ၏အမည်မှာ Isabel Martinez de Peronဖြစ်ပြီး Argentina နိုင်ငံ၏ ၄၂ ယောက်မြောက်သမ္မတလည်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("Information Technology","ROM အမျိုးအစားများမှာ","PROM, EEEEEPROM, RROM ","PROM, EPROM,EEPROM","PCROM, PDROM, PEROM","RPOM, RRROM, PPOM","PROM, EPROM,EEPROM","အဓိကအားဖြင့် ROM အမျိုးအစား ၅ ခုရှိပါသည်။၎င်းတို့မှာ ROM,PROM, EPROM,EEPROM နှင့် Flash memory တို့ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ဂီတ","Hawaiian ဘာသာစကားတွင် Ukulele ဆိုသော စကားလုံးသည်မည်သည့်အဓိပ္ပာယ်ရှိသနည်း။","Jumping flea","Small guitar","Island banjo","Small bug fiddle","Jumping flea","Ukulele သည် ကြိုးငယ်လေးကြိုးပါဝင်သော ဂီတာ အငယ်စား ဖြစ်ပြီး Jumping-ခုန်နေသည် Flea-သန်းဟုအဓိပ္ပာယ်ရှိပါသည်။"));

        arraylist.add(new QuizQuestion("နိုင်ငံများ","ဘရာဇီးလ်(Brazil)နိုင်ငံသည် မည်သည့် တိုက်တွင် တည်ရှိသနည်း။","အာရှတိုက်","မြောက်အမေရိကတိုက်","အာဖရိကတိုက်","တောင်အမေရိကတိုက်","တောင်အမေရိကတိုက်","ဘရာဇီးလ် နိုင်ငံသည် တောင်အမေရိကတိုက်တွင် အကြီးဆုံးနိုင်ငံဖြစ်ပြီး ကမ္ဘာ့အကြီးဆုံးနိုင်ငံ အဆင့် ၅  ရရှိထားပါသည်။"));

        arraylist.add(new QuizQuestion("စကားပုံ","နွားရှေ့  ________။","လှည်းရောက်","ထွန်တုံး","လှည်းကျူး","ထွန်ကျူး","ထွန်ကျူး"," ပြောဆိုဆုံးမသည့်အတိုင်း မလိုက်နာဘဲ ဆရာသမားများကို ပြန်လည်ပြောဆိုပြုမှု နေခြင်းကိုဆိုလိုသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","ကမ္ဘာ့အမြင့်ဆုံးတောင် ဧဝရတ်တောင် သည် မည်သည့်နိုင်ငံ၌ တည်ရှိသနည်း။","Nepal","India","Bhutan","Pakistan","Nepal","ဧဝရတ်တောင်ထိပ်သည် နီပေါနှင့် တရုတ်နိုင်ငံ တိဘက်ဒေသတို့၏ နယ်စပ်တွင်တည်ရှိသည်။"));

        arraylist.add(new QuizQuestion("လူပုဂ္ဂိုလ်များ","Telephone ကိုတီထွင်သူတစ်ဦးမှာ-","Nikola Tesla","Leonado da Vinci","Alexandar Graham Bell","Henry Ford","Alexandar Graham Bell","Alexandar Graham Bellသည် အမေရိကန် အင်ဂျင်နီယာတစ်ဦးဖြစ်ပြီး ကမ္ဘာ့ပထမဦးဆုံး telephone ကို ၁၈၇၆တွင် တီထွင်နိုင်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("Chemistry","သာမန်အခန်းအပူချိန်တွင် မည်သည့် element ကို အရည်အဖြစ် တွေ့ရသနည်း။","Mercury","Helium","Nitrogen","Oxygen","Mercury","Mercury ၏ အရည်ဆူအမှတ်မှာ ၂၀ ဒီဂရီ စီတီဂရိတ် နှင့်အထက်ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အားကစား","အောက်ပါ အားကစားများတွင် မည်သည့် အားကစားပွဲ၏ ကျင်းပသည့်ကွင်းသည် အကြီးဆုံးဖြစ်သနည်း။","Hockey ","Football ","Polo ","Baseball","Polo ","Polo အားကစားပွဲကျင်းပသည့် ကွင်းသည် အလျား ၂၇၅မီတာ၊ အနံ ၁၄၅မီတာရှိပြီး ဘောလုံးကွင်း ၅ကွင်းစာ အရွယ်အစားရှိပါသည်။"));

        arraylist.add(new QuizQuestion("Information Technology","mac operating system ကိုမည်သည့် company မှ develop လုပ်ခဲ့သနည်း။","IBM","Apple","Microsoft","Samsung","Apple","mac operating system သည် Apple computerများ၏ operting systemဖြစ်ပြီး ၂၀၀၁ ခုနှစ်ကတည်းက developလုပ် ရောင်းချခဲ့ခြင်းဖြစ်ပါသည်။ "));

        arraylist.add(new QuizQuestion("Physics","လေထုထဲရှိ စိုထိုင်းခြင်း(Humidity)နှင့် ရေခိုးရေငွေ့ပမာဏကိုတိုင်းတာသော ကိရိယာမှာ-","Hydrometer","Lactometer","Hygrometer","Barometer","Hygrometer","ပထမဆုံး hygrometer အကြမ်းထည်ကို ၁၄၈၀ ခုနှစ်တွင် ကမ္ဘာကျော် Polymath တစ်ဦးဖြစ်သည့် Leonado da Vinci  ကတီထွင်ခဲ့ပြီး ခေတ်သစ်ပုံစံ hygrometer ကို ၁၇၅၅ ခုနှစ်တွင် polymath Johann Heinrich Lambert ကတီထွင်ခဲ့ပါသည်။ "));

        arraylist.add(new QuizQuestion("သီချင်းများ","ကမ္ဘာကျော် ဇာတ်ကားဖြစ်သည့် Titanic ၏ဇာတ်ဝင်တေးသီချင်းဖြစ်သော My Heart Will Go On ကို ရေးသားခဲ့သည့်တေးရေးဆရာမှာ","Will Jennings","Steve Winwood","Eric Clapton","Jimmy Buffett  ","Will Jennings","Will Jennings သည် အမေရီကန် သီချင်းရေးဆရာဖြစ်ပြီး Tears in Heaven နှင့် My Heart Will Go On စသော သီချင်းများဖြင့် ကျော်ကြားသူတစ်ဦးဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("အဆိုအမိန့်များ","I came, I saw, I conquered သည် မည်သည့်ပုဂ္ဂိုလ်၏ အဆိုအမိန့်ဖြစ်သနည်း။","Alexandar the Great","Adolf Hitler","Mao Zedong","Julius Caesar","Julius Caesar","Julius Caesar သည် ကမ္ဘာကျော် ရောမ အာဏာရှင်၊ စစ်ဗိုလ်ချုပ်ကြီးတစ်ဦးဖြစ်ပြီး ရောမအင်ပါယာ ကြီးမားလာမှုကို ဦးဆောင်ခဲ့သူဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ရုပ်ရှင်သရုပ်ဆောင်များ","ရုပ်ရှင်မင်းသမီး ဒေစီကျော်ဝင်း အကောင်းဆုံးအမျိုးသမီးဇာတ်ဆောင်ဆုရရှိသော ဇာတ်ကားမှာ-","အားနွဲ့သူပါရှင်","ပန်းသီတဲ့ကြိုး","တစ်ခါကတစ်ဘဝ","ကကြီးရေက","အားနွဲ့သူပါရှင်","နိုင်ငံကျော်ရုပ်ရှင်မင်းသမီး ဒေစီကျော်ဝင်း သည် ၁၉၇၁ခုနှစ်တွင် အားနွဲ့သူပါရှင် ရုပ်ရှင်ဇာတ်ကားဖြင့် အကောင်းဆုံးအမျိုးသမီးဇာတ်ဆောင်ဆုရရှိခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("ကဗျာများ","တောင်သူကြီး ကဗျာကို မည်သည့်ခေတ်တွင်ရေးဖွဲ့ခဲ့သနည်း။","ကုန်းဘောင်ခေတ်","ညောင်ရမ်းခေတ်","အင်းဝခေတ်","ပုဂံခေတ်","ကုန်းဘောင်ခေတ်", "တောင်သူကြီး ကဗျာကို ကုန်းဘောင်ခေတ်တွင် ဖိုးသူတော်ဦးမင်း ရေးဖွဲ့ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("Information Technology",".gif  ၏ မည်သည့် file၏ extension ဖြစ်သနည်း။","Video file","Image file","Audio file","Word file","Image file",".jpg, .png, .tif နှင့် .gif စသော extension များသည် image file extensionများဖြစ်ကြသည်။ .jpg သည် အသုံးများသော extensionတစ်ခုဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("အာကာသ","Milky Way galaxy သည် မည်သည့် ပုံသဏ္ဌာန်ရှိသနည်း။ ","Circular","Elliptical","Spiral","No Shape","Spiral","Milky Way galaxyသည် spiral (ခရုပတ်ရစ်ခွေသော) ပုံသဏ္ဌာန်ရှိပြီး ကြယ်ပေါင်း ၂၀၀ ဘီလီယံမှ ၄၀၀ဘီလီယံ ထိရှိပါသည်။"));

        arraylist.add(new QuizQuestion("Grammar","Two teenagers were lost out _______ in the Outback, but now that _______ back home safely, _______ families are celebrating.","their - there - they're","there - they're - their","they're - there - their","them - they're - their","there - they're - their","There is a demonstrative pronoun that points to a distant place; they’re is a contraction of the third person plural pronoun “they” and the verb to be “are”, “their” is a possessive adjective that shows a noun belonging to two or more people, not including yourself."));

        arraylist.add(new QuizQuestion("သင်္ချာ","ဆိတ်နှင့် သိုး ၃၆ကောင်တွင် သိုးသည် ဆိတ်ထက် (၅)ဆပိုများ၏။ ဆိတ်ကောင်ရေမှာ","၅ကောင်","၆ကောင်","၇ကောင်","၈ကောင်","၆ကောင်","ဆိတ်+ သိုး= ၃၆ကောင်၊ သိုး=၅ xဆိတ် ၊ ၆xဆိတ်= ၃၆ကောင်၊ ဆိတ်= ၆ကောင်"));

        arraylist.add(new QuizQuestion("ကျန်းမာရေး","အရေပြားရောဂါ တစ်ခုဖြစ်သော ရေယုန်သည် မည်သည့်အရာကြောင့် ဖြစ်ပွားရသနည်း။","Dryness","Bacteria ","Scratching","Viruses","Viruses","ရေယုန်(shingles) သို့ herpes zoster သည် အာရုံကြောဆိုင်ရာ အရေပြားရောဂါတစ်ခုဖြစ်ပြီး varicella-zoster virus ကြောင့်ဖြစ်ပွားသော ကူးစက်ရောဂါ တစ်မျိုးဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("ပန်းချီ ","The Starry Night ပန်းချီကားကို ရေးဆွဲခဲ့သော ကမ္ဘာကျော် ပန်းချီပညာရှင် မှာ-","Pablo Picasso","Leonardo da Vinci","Vincent van Gogh","Sandro Botticelli","Vincent van Gogh","The Starry Night ပန်းချီကား သည် ဆီဆေး ပန်းချီကားတစ်ခုဖြစ်ပြီး အတိုင်းအတာ 74 cm x 92 cm ရှိပါသည်။ ၁၈၈၉ ဇွန်လတွင် ဖန်တီးခဲ့ခြင်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ဇီဝဗေဒ","မှိုပင်များသည် မည်သို့ မျိုးပွားသနည်း။","Small filaments under the ground","Splitting into two","Spores","Seeds","Spores","မှိုပင်များ သည် ၎င်းတို့၏ မျိုးမှုန်(Spores) များကို ထုတ်လွတ်ခြင်းဖြင့် မျိုးပွားကြပါသည်။ မှိုတက်ခြင်းဖြစ်စဉ် တစ်ခု တွင် မျိုးမှုန် ပေါင်း ဘီလီယံချီ ထုတ်လုပ် ပါသည်။"));

        arraylist.add(new QuizQuestion("စစ်ပွဲများ","ဒုတိယ အင်္ဂလိပ်-မြန်မာ စစ်ပွဲ ဖြစ်ပွားရသည့် ပြဿနာမှာ-","ရှင်မဖြူကျွန်း အရေးအခင်း","ကုန်ပို့တင်ဆောင်မှု","ရခိုင်နယ်ခြား ပြဿနာ","သစ်ခိုးထုတ်မှု","ကုန်ပို့တင်ဆောင်မှု","သင်္ဘောကပ္ပတိန် ရှက်ပက်နှင့် လူးဝစ်အားလူသတ်မှု၊ သင်္ဘောနှစ်စီးဖြင့် ကုန်ပို့ဆောင်မှု၊ တရားစွဲဒဏ်ရိုက်ရာမှ စတင်သည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","မြန်မာနိုင်ငံ၏အရှေ့ဘက် အစွန်ဆုံး မြို့မှာ-","မိုင်းယောင်းမြို့","ပန်နန်းဒင်မြို့","ပင်လောင်းမြို့","ကျိုင်းတောင်းမြို့","မိုင်းယောင်းမြို့","မိုင်းယောင်းမြို့ သည် အရှေ့ဘက် အစွန်ဆုံး မြို့၊ မောင်းတောမြို့ သည် အနောက်ဘက် အစွန်ဆုံးမြို့၊ ကော့သောင်းမြို့သည် တောင်ဘက်အစွန်ဆုံးမြို့၊ ပန်နန်းဒင်မြို့ သည် မြောက်ဘက် အစွန်ဆုံးမြို့၊"));

        arraylist.add(new QuizQuestion("ဆုတံဆိပ်များ","နိုဘယ်ဆု(၆)မျိုးတွင် မပါဝင်သော ဆုမှာ-","စာပေဆု","ရူပဗေဒထူးချွန်ဆု","စီပွားရေးသိပ္ပံထူးချွန်ဆု","သင်္ချာ ထူးချွန်ဆု","သင်္ချာ ထူးချွန်ဆု","နိုဘယ်ဆုခြောက်မျိုးမှာ ဆေးဝါးထူးချွန်ဆု၊ ဓာတုဗေဒထူးချွန်ဆု၊ စာပေဆု၊ ငြိမ်းချမ်းရေးဆု၊ ရူပဗေဒထူးချွန်ဆု နှင့် စီးပွားရေးသိပ္ပံထူးချွန်ဆုတို့ ဖြစ်ကြသည်။"));

        arraylist.add(new QuizQuestion("အစားအသောက်","ဝိုင် တွင် အဓိကပါဝင်သော ပါဝင်ပစ္စည်းမှာ မည်သည့် အပင်မှဖြစ်သနည်း။","Agave","Grape","Peach","Pulm","Grape","ဝိုင် တွင် အဓိကပါဝင်သော ပါဝင်ပစ္စည်းမှာ အချဉ်ဖောက်ထားသော စပျစ်သီး များဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ခေတ်ကာလများ","ကမ္ဘာ၏ မည်သည့် အချိန်ကာလ တွင် လူသားများနှင့် ဒိုင်နိုဆောများ အတူနေထိုင်ခဲ့ကြသနည်း။","The Jurassic Period","The Cretaceous Period","The Iron Age","Never","Never","ကျောက်ဖြစ်ရုပ်ကြွင်းမှတ်တမ်းများနှင့် ကာဗွန် Dating မှတ်တမ်းများအရ လူသားများနှင့် ဒိုင်နိုဆောများ သည် မည်သည့်ကာလတွင်မှ အတူနေထိုင်ခဲ့ခြင်းမရှိပါ။ မိကျောင်းများသာလျှင် လူသားများနှင့်ရော ဒိုင်နိုဆောများနှင့်ပါ နေထိုင်ခဲ့ကြသည်ဟု သိပ္ပံပညာရှင်များက မှတ်ယူထားကြပါသည်။"));

        arraylist.add(new QuizQuestion("Information Technology","အောက်ပါ တို့မှ Operating System မဟုတ်သည့် အရာကို ရွေးပါ။","DOS","Mac","C","Linux","C","C သည် programming language တစ်ခုဖြစ်ပါသည်။ အခြားသော programming language များမှာ C++, Java, C# ,Python ,Fortran စသဖြင့် programming language ပေါင်း ၂၅၀ ဝန်းကျင် ရှိပါသည်။"));

        arraylist.add(new QuizQuestion("ကြယ်များ","ကြယ်များ၏ အရောင်အသွေး ကွဲပြားမှုများသည် ကြယ်၏မည်သည့်အရာ ပြောင်းလဲမှုကြောင့်ဖြစ်သနည်း။","Temperature","Pressure","Density","Radiation","Temperature","ကြယ်များ၏ အရောင်များသည် ၎င်းတို့၏ အပူချိန်ကို ဖော်ပြပါသည်။ အပူဆုံးကြယ်များသည် အပြာ သို့ ပြာ-ဖြူ အရောင်ရှိပြီး အအေးဆုံး ကြယ်များသည် အနီရောင် ရှိကြပါသည်။ "));

        arraylist.add(new QuizQuestion("အားကစား","သာမန် ဂေါက်သီးတစ်လုံး၏ မျက်နှာပြင်ပေါ်တွင် အချိုင့်ငယ်(dimples)ပေါင်းမည်မျှရှိသနည်း။","၂၅၇","၄၅၃","၄၁၂","၃၃၆","၃၃၆","သာမန် ဂေါက်သီးတစ်လုံး၏ မျက်နှာပြင်ပေါ်တွင် အရွယ်တူချိုင့်ခွက် ပေါင်း ၃၃၆ ခုရှိပါသည်။"));

        arraylist.add(new QuizQuestion("အတိုကောက်စကားလုံးများ","ဆေးပညာ ၏ အရေးပေါ် လုပ်ရိုးလုပ်စဉ် ဖြစ်သော  CPR ၏အနက်အဓိပ္ပာယ်မှာ-","Cadioprimary resuscitation","Chestpulmonary resuscitation","Cadioprimary rescuse","Cadiopulmonary resuscitation","Cadiopulmonary resuscitation","Cadiopulmonary resuscitation(CPR) သည် ဆေးပညာနှင့်ဆိုင်သော အရေးပေါ်လုပ်လုပ်ရိုးလုပ်စဉ်နည်းလမ်း တစ်ခုဖြစ်ပါသည်။ နှလုံးနှင့်ဆိုင်သော ရပ်တန့်မှုဖြစ်သွားသည့်သူအား ပုံမှန်သွေးလည်ပတ်မှုနှင့် အသက်ရှူမှုများ ပြန်လည်ရရှိစေသော ကုထုံးဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","အောက်ပါကျွန်းကြီးများတွင် မည်သည့်ကျွန်းသည် အကြီးဆုံးဖြစ်သနည်း။","Sumatra","Borneo","Greenland","Victoria Island","Greenland","Greenland သည် Kingdom of Denmark ၏ ကိုယ်ပိုင်အုပ်ချုပ်ခွင့်ရှိသော ကျွန်းကြီးဖြစ်ပြီး ၂,၁၆၆,၀၈၆ စတုရန်းကီလိုမီတာ ဧရိယာရှိပါသည်။"));

        arraylist.add(new QuizQuestion(" ဝတ္ထုများ","Sherlock Holmes ဝတ္ထုကို ရေးသားခဲ့သော စာရေးဆရာ အမည်မှာ","Arthur Conan Doyale","H. G. Wells","Charles Dickens","Mark Twain","Arthur Conan Doyale","Sherlock Holmes ဝတ္ထုကိုဗြိတိန် စာရေးဆရာ Sir Arthur Conan Doyale ကရေးသားခဲ့ပြီး ၁၈၈၇ခုနှစ်ဝန်းကျင်တွင် A Study in Scarlet ဖြင့် စတင်မိတ်ဆက်ခဲ့ပါသည်။ "));

        arraylist.add(new QuizQuestion("အနုပညာ","Ballet အက သည် မည်သည့်နိုင်ငံ ၏ အကဖြစ်သနည်း။","Argentina","Brazil","Spain","Italy","Italy","Ballet အက ၏ဇစ်မြစ်မှာ Italy(အီတလီ)နိုင်ငံ မှဖြစ်ပြီး ၁၅ ရာစုတွင် ပေါ်ပေါက်ခဲ့ပါသည်။ ထို့နောက်  ပြင်သစ် နှင့် ရုရှား နိုင်ငံများသို့ ပျံ့နှံ့လာခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("တီထွင်မှုများ","ကမ္ဘာ့အကြီးမားဆုံးသော Online Shopping Website များမှ တစ်ခုဖြစ်သည့် Amazon ၏ Founder မှာ","Carlos Slim","Jeff Bezos","Warren Buffett","Tim Cook","Jeff Bezos","Jeff Bezos သည် အမေရိကန် နည်းပညာစွန့်ဦးတီထွင်သူ တစ်ဦးဖြစ်ပြီး လက်ရှိ ပိုင်ဆိုင်မှု ဒေါ်လာ၁၅၂ ဘီလီယံ ဖြင့် ကမ္ဘာ့အချမ်းသာဆုံး ပုဂ္ဂိုလ် လည်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("တူရိယာများ","ကမ္ဘာ့စျေးအကြီးဆုံးသော တူရိယာသည် မည့်သည့် တူရိယာ အမျိုးအစားဖြစ်သနည်း။","Violin","Piano","Guitar","Cello","Violin","The Vieuxtemps Guarneri အမည်ရှိ တယော သည် ဒေါ်လာ ၁၆ မီလီယံ တန်ဖိုးရှိပြီး ၁၉ရာစုတွင် Belgian လူမျိုး ကမ္ဘာကျော်တယော ပညာရှင် Henri Vieuxtemps ကပိုင်ဆိုင်ခဲ့ပါသည်။ ယခုထိတိုင် အသံပိုင်းဆိုင်ရာတွင် အပြစ်အနာအဆာ ကင်းမဲ့သော တူရိယာဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("လူပုဂ္ဂိုလ်များ","ကမ္ဘာကျော်ပုံပြင် ယုန်နှင့်လိပ် (The Tortoise and the Hare) ပုံပြင်ကို ရေးသားခဲ့သော လူပုဂ္ဂိုလ်မှာ-","Plato","Heisod","Aesop","Jean de La Fontaine ","Aesop","Aesop သည် ဂရိ ဒဏ္ဍာရီပုံပြင် ဖန်တီးသူ တစ်ဦးဖြစ်ပြီး The Lion and the Mouse, The Fox and the Grapes, The old man and his sons စသော ကမ္ဘာကျော် ပုံပြင်များကို ရေးသားခဲ့သူဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("Physics","လေ၏ force နှင့် velocity ကို တိုင်းတာသော ကိရိယာမှာ-","Ammeter","Anemometer","Altimeter","Audiometer","Anemometer","Anemometer သည် လေ၏ အရှိန်ကို တိုင်းတာသောကိရိယာဖြစ်ပြီး မိုးလေဝသ ခန့်မှန်းသော နေရာတွင်သုံးလေ့ရှိပါသည်။"));

        arraylist.add(new QuizQuestion("တိရစ္ဆာန်များ","နို့တိုက်သတ္တဝါများတွင် အမြန်ဆုံး သွားလာနိုင်သော သတ္တဝါမှာ-","Lion","Hare","African Wild Dog","Cheetah","Cheetah","Cheetah သည် ကြောင်ကြီးမျိုးနွယ်ဝင် ဖြစ်ပါသည်။ တစ်နာရီတွင် ၆၈မိုင်မှ ၇၅မိုင်နှုန်းထိ ၆၀ စက္ကန့်ဝန်းကျင် တာတိုပြေးနိုင်ပါသည်။"));

        arraylist.add(new QuizQuestion("သိပ္ပံ","DNA molecule တစ်ခုသည် မည်သည့်အရာနဲ့ ပုံသဏ္ဌာန် ဆင်တူသနည်း။","A cloverleaf","A cross","A twisted ladder","A figure eight","A twisted ladder","DNA molecule သည် double helix structure ရှိပြီး James Watson နှင့် Francis Crick တို့မှ ၁၉၅၀ ဝန်းကျင်များတွင် ရှာဖွေတွေ့ရှိခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("မိုးလေဝသ","တို်ငဖုန်း(Typhoon) မုန်တိုင်းများသည် မည်သည့် နေရာတွင် ဖြစ်ပွားလေ့ရှိသနည်း။","North Western Pacific Ocean","Indian Ocean","Artic Ocean","Eastern Pacific Ocean","North Western Pacific Ocean","Typhoon မုန်တိုင်းများသည် North Western Pacific Oceanတွင် မကြာခဏ ဖြစ်ပေါ်တတ်ပြီး Hurricane မုန်တိုင်များသည် Eastern Pacific Oceanတွင် ဖြစ်ပေါ်လေ့ရှိပါသည်။ "));

        arraylist.add(new QuizQuestion("အဆိုအမိန့်များ","I love walking in the rain cause no one see me crying သည် မည်သူ့၏ အဆိုအမိန့်ဖြစ်သနည်း။","Charlie Chaplin","Jackie Chan","Robin Williams","Jim Carrey","Charlie Chaplin","ကမ္ဘာကျော် English ဟာသသရုပ်ဆောင် Charlie Chaplin သည် အသံတိတ် ဟာသပညာ ကို မြင့်တင်ပေးခဲ့သူဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အခေါ်အဝေါ်များ"," MANGERY ဆိုသော စကားလုံးကို အစီအစဉ်ကျအောင်ပြန်စီလျှင် ရလာသောစကားလုံး အဓိပ္ပာယ်သည်-","သမုဒ္ဒရာ","မြို့","နိုင်ငံ","တိရစ္ဆာန်","နိုင်ငံ","ရလာသောစကားလုံးသည် အနောက် ဥရောပတိုက် နိုင်ငံတစ်နိုင်ငံဖြစ်သော Germany နိုင်ငံဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ဘာသာစကားများ","ဒုတိယမြောက် လူပြောအများဆုံး ဘာသာစကားမှာ-","Hindi","Chinese","English","Spainish","Spainish","Spainish စပိန်ဘာသာစကားသည်  ဒုတိယမြောက် လူပြောအများဆုံး ဘာသာစကားဖြစ်ပြီး Mandarin Chinese ဘာသာစကားသည် လူပြောအများဆုံး ဘာသာစကားဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","ကမ္ဘာမြေပြင်ကို ရေထု မည်မျှရာခိုင်နှုန်း လွှမ်းမိုးထားသနည်း။","၆၃%","၅၇%","၄၉%","၇၁%","၇၁%","ကမ္ဘာမြေပြင်ကို ရေထုသည် ၇၁% လွှမ်းမိုးထားပါသည်။ ကုန်းမြေသီးသန့်ကို စက်လုံးတစ်လုံးပမာ တည်ဆောက်ပါက အချင်းသည် ၈၇၀ မိုင် သာ ရှိပါတော့မည်။"));

        arraylist.add(new QuizQuestion("သရုပ်ဆောင်များ","Jack Sparrow ဇာတ်ကောင် အဖြစ် သရုပ်ဆောင်သော မင်းသား Johnny Deep၏ ဇာတ်ကားတစ်ကားမှာ-","The Hobbit","Transformers ","Pirates of the Caribbean","The Mummy","Pirates of the Caribbean","ကမ္ဘာကျော် မင်းသား Johnny Deepသည် Pirates of the Caribbean ဇာတ်ကားမှcaptain Jack Sparrow ဟု လူသိများပါသည်။"));

        arraylist.add(new QuizQuestion("နိုင်ငံများ","အီဂျစ်(Egypt)နိုင်ငံ၏ မြို့တော်မှာ-","Cairo","Giza","Luxor","Istanbul","Cairo","Cairo (ကိုင်ရို)သည် အီဂျစ်နိုင်ငံ၏ မြို့တော်ဖြစ်ပြီး နိုင်းမြစ် ဖြတ်သန်းစီးဆင်း သောမြို့ကြီးဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("English","စပါးလင် ကိုမည်သို့ခေါ်သနည်း။","Wild ginger","Lemongrass","Rosselle","Citro leaf","Lemongrass","စပါးလင် ကို lemongrass ဟုခေါ်ဆိုကြပြီး သိပ္ပံအမည်မှာ Cymbopogon ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ရာသီပွဲတော်များ","လှေပြိုင်ပွဲကို မည်သည့်လတွင် ကျင်းပသနည်း။","နယုန်လ","တော်သလင်းလ","နတ်တော်လ","ပြာသိုလ","တော်သလင်းလ","တော်သလင်းလ၏ ပွဲတော်မှာ လှေပြိုင်ပွဲဖြစ်ပြီး ရာသီပန်းမှာ ယင်းမာပန်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("Physics","သက်တန့် (Rainbow)သည် မည်သည့် အရာအကြောင့် ဖြစ်ပေါ်လာရသနည်း။","Induction","Refraction","Radiation","Reflection","Refraction","Refraction သည် ကြားခံနယ် တစ်ခုမှ တစ်ခုသို့ အလင်းဖြတ်သန်းသွားသည့်အခါ ဖြစ်ပေါ်သော အလင်းကွေးညွတ်ခြင်း ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("ငွေကြေး","ကမ္ဘာ့ဈေးအကြီးဆုံး ငွေကြေးမှာ-","British Pound Sterlin","Swiss Franc","US Dollar","Kuwaiti Dinar","Kuwaiti Dinar","Kuwaiti Dinar(KWD)သည် ကူဝိတ်နိုင်ငံ၏ ငွေကြေးဖြစ်ပြီး 1 KWD = 3.29 USD နှင့် ညီမျှပါသည်။"));

        arraylist.add(new QuizQuestion("နည်းပညာ","မြန်မာနိုင်ငံ၏ နိုင်ငံကုဒ် (Country code)မှာ-","+94","+66","+84","+95","+95","Country calling codes သို့ Country dial-in codes သို့ country code များသည် နိုင်ငံများ၏ ဖုန်းနံပါတ် ရှေ့ဆုံး ကိန်းဂဏာန်းများဖြစ်ပါသည်။ မြန်မာနိုင်ငံ၏ Country code မှာ +95 ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("လူပုဂ္ဂိုလ်များ","တောင်အာဖရိက နိုင်ငံ၏ ပထမဦးဆုံးလူမည်း သမ္မတအမည်မှာ-","Jacob Zuma","Nelson Mandela","Kofi Annan","Thabo Mbeki","Nelson Mandela","Nelson Mandela သည် တောင်အာဖရိက နိုင်ငံ၏ ပထမဦးဆုံးလူမည်း သမ္မတ အဖြစ် ၁၉၉၄ ခုနှစ်မှ ၁၉၉၉ခုနှစ်အထိ တာဝန်ထမ်းဆောင်ခဲ့ပါသည်။"));

        arraylist.add(new QuizQuestion("အားကစား","ဆူမို (Sumo) နပန်းပွဲသည် မည်သည့်နိုင်ငံ၏ အားကစားတစ်မျိုး ဖြစ်သနည်း။","China","India","Japan","Korea","Japan","နာမည်ကြီး နပန်းကစားနည်း တစ်မျိုးဖြစ်သည့် ဆူမို အားကစားနည်းသည် Japan နိုင်ငံမှဖြစ်ပြီး ပြိုင်ဘက်အား စည်းမျဉ်းအပြင်ထွက်အောင် ကြိုးပမ်းရခြင်း ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အစားအသောက်","အောက်ပါ စားစရာများများမှ မည်သည့်အစားအစာ သည် Australia နိုင်ငံတွင် တီထွင်ဖန်တီးခဲ့သနည်း။","Pizza","Vegemite","Hot dogs","Croissant","Vegemite","Vegemite သည် အရသာ ကောင်းသော ပေါင်မုန့်နှင့် သုတ်စားရသော ယိုတစ်မျိုးဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("သမ္မတများ","အမေရိကန်ပြည်ထောင်စု၏ ပထမဆုံး သမ္မတ သည် မည်သူဖြစ်သနည်း။","Abraham Lincoln","Thomas Jefferson","Benjamin Franklin","George Washington","George Washington","George Washington သည် အမေရိကန် နိုင်ငံရေးခေါင်းဆောင် တစ်ဦးဖြစ်ပြီး စစ်ဗိုလ်ချုပ် တစ်ဦးလည်းဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အခေါ်အဝေါ်များ","နှစ်ပတ်လည်ဆိုင်ရာ အထိမ်းအမှတ်ဖြစ်သော ၉၀ နှစ်မြောက်ကို မည်သည့်ရတုဟု ခေါ်ဆိုသနည်း။","နီလာရတု","စိန်ရတု","မြရတု","နဝရတ်ရတု","နဝရတ်ရတု","၉၀ နှစ်မြောက်ရတုသည် နဝရတ်ရတု ဖြစ်ပြီး (၄၅ နှစ်မြောက်=နီလာရတု)၊ (၅၅ နှစ်မြောက်= မြရတု)၊ (၆၀ နှစ်မြောက်= စိန်ရတု) စသည်တို့ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("အရောင်များ","အစိမ်းရောင် ဖြစ်လာရန် မည်သည့်အရောင်များကို ရောစပ်ရမည်နည်း။","Red and Yellow","Blue and Yellow","Orange and Purple","Yellow and Purple","Blue and Yellow","အပြာနှင့် အဝါသည် Primary color ဖြစ်ပြီး ၎င်းတို့၏ပေါင်းစပ်မှုကြောင့် အစိမ်း secondary color ထွက်လာပါသည်။ "));

        arraylist.add(new QuizQuestion("Information Technology","2 byte တွင် မည်မျှ bit ရှိသနည်း။","၁၆ bits","၈   bits","၂၄  bits","၁၂  bits","၁၆ bits","1 byte တွင် 8 bits ရှိသောကြောင့် 2 bytes တွင် 16 bits ရှိပါသည်။"));

        arraylist.add(new QuizQuestion("သိပ္ပံ","Isaac Newton ၏ Theory of Gravity ကို မည်သည့် အရာက လွမ်းမိုးထား သနည်း။","Ladder","Hailstone","Apple","Rock","Apple","Isaac Newton ငယ်ရွယ်စဉ်အခါက ပန်းသီးပင်အောက် ထိုင်နေချိန် ခေါင်းပေါ်သို့ ပန်းသီးပြုတ်ကျခဲ့ရာမှ Theory of Gravity ကို စဉ်းစားမိခဲ့ခြင်းဖြစ်သည်။"));

        arraylist.add(new QuizQuestion("ပထဝီ","Longitude(လောင်ဂျီကျု) မျဉ်းများကို မည်သည့်အရပ်မှ မည်သည့်အရပ်သို့ ရေးဆွဲထားသနည်း။","East-West","North-South","Northeast-Northwest","Southeast-Southwest","East-West","Longitude(လောင်ဂျီကျု) မျဉ်းများ သည် သဘာဝမြေမျက်နှာနှင့်ဆိုင်သော သတ်မှတ်ထားသော မျဉ်းကြောင်းများဖြစ်ပြီး ကမ္ဘာမြေကြီး၏ အရှေ့ နှင့် အနောက် Positionကို သတ်မှတ်ရေးဆွဲထားသော မျဉ်းများဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("Physics","လျှပ်စီး (Current) ၏ unit မှာ-","Kelvin(K)","Mole(mol)","Ampere(A)","watt(W)","Ampere(A)","လျှပ်စီး (Current) ၏ unit မှာ Ampere(A) ဖြစ်ပြီး Temperature= Kelvin(K), amount of substance =Mole(mol) နှင့် Power=watt(W) တို့ဖြစ်ကြပါသည်။"));

        arraylist.add(new QuizQuestion("ဂြိုဟ်များ","အောက်ပါတို့အနက် ဂြိုဟ်ပု(dwarf planet)ဟု သတ်မှတ်ခံခဲ့ရသော ဂြိုဟ်မှာ-","Venus","Pluto","Mercury","Mars","Pluto","Pluto ဂြိုဟ်သည် ၂၀၀၆ ခုနှစ်တွင် ဂြိုဟ်များစရင်းမှ ပယ်ချခြင်းခံရပါသည်။ အဘယ်ကြောင့်ဆိုသော် Eris အမည်ရှိ ဂြိုဟ်ပုတစ်စင်းသည် Pluto ထက် ၂၇%ပိုကြီးနေသဖြင့်ဖြစ်ပါသည်။"));

        arraylist.add(new QuizQuestion("စာပေ","Harry Potter ဝတ္ထုရှည်များကို ရေးသားခဲ့သော စာရေးဆရာမှာ-","J. K. Rowling","Stephen King","James Petterson","Tom Clancy","J. K. Rowling","ဗြိတိန် စာရေးဆရာမ J. K. Rowling သည် စိတ်ကူးယဉ်ဆန်သော ဝတ္ထုရှည်များဖြင့် လူသိများပြီး ရောင်းအားအကောင်းဆုံး စိတ်ကူးယဉ်ဝတ္ထု စာရေးဆရာအဖြစ် အဆင့် ၉ ရယူထားဆဲဖြစ်ပါသည်။"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<QuizQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (QuizQuestion question : allQuestions) {
                values.put(TITLE,question.getCategory());
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                values.put(EXP,question.getExp());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<QuizQuestion> getAllOfTheQuestions() {

        List<QuizQuestion> questionsList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME +" ORDER BY RANDOM() LIMIT 11;";


        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        db.beginTransaction();


        while (cursor.moveToNext()) {
            QuizQuestion question = new QuizQuestion();
            question.setId(cursor.getInt(0));
            question.setCategory(cursor.getString(1));
            question.setQuestion(cursor.getString(2));
            question.setOptA(cursor.getString(3));
            question.setOptB(cursor.getString(4));
            question.setOptC(cursor.getString(5));
            question.setOptD(cursor.getString(6));
            question.setAnswer(cursor.getString(7));
            question.setExp(cursor.getString(8));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}

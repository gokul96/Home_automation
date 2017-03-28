import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) 
	{
		System.out.print("{\n");
		System.out.print("\t\"Device\": \"%s\" + \"XDK110\",\n");
		System.out.print("\t\"Timestamp\": \"%ld\",\n");
		System.out.print("\t\"acc (mG)\": \n\t{\n");
		System.out.print("\t\t\"acc_xyz\": \"[%-+5ld,%-+5ld,%-+5ld]\"\n\t},\n");
		System.out.print("\t\"gyro (mdeg/s)\":\n\t{\n");
		System.out.print("\t\t\"gyro_xyz\": \"[%-+5ld,%-+5ld,%-+5ld]\"\n\t},\n");
		System.out.print("\t\"mag (uT)\": \n\t{\n");
		System.out.print("\t\t\"mag_xyz\": \"[%-+5ld,%-+5ld,%-+5ld]\"\n\t},\n");
		System.out.print("\t\"light (lx)\": \"%lf\",\n");
		System.out.print("\t\"temp ('C)\": \"%lf\",\n");
		System.out.print("\t\"pressure (Bar)\": \"%lf\",\n");
		System.out.print("\t\"humidity (RH%%)\": \"%lf\"\n\t}");
//		System.out.print("\t\t\t\"z\": \"%-+5ld\"\n\t\t},\n");
////		System.out.print("\t\t},\n");
//		System.out.print("\t\t\"mag (uT)\": \n\t\t{\n");
//		System.out.print("\t\t\t\"x\": \"%-+5ld\",\n");
//		System.out.print("\t\t\t\"y\": \"%-+5ld\",\n");
//		System.out.print("\t\t\t\"z\": \"%-+5ld\"\n\t\t},\n");
////		System.out.print("\t\t},\n");
//		System.out.print("\t\t\"light (lx)\": \"%lf\",\n");
//		System.out.print("\t\t\"temp ('C)\": \"%lf\",\n");
//		System.out.print("\t\t\"pressure (Bar)\": \"lf\",\n");
//		System.out.print("\t\t\"humidity (RH%%)\": \"%ld\"\n\t}");
////		System.out.print("\t}\n]}");
		
	

	}

}

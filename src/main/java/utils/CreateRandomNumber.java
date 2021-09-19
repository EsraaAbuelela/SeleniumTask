package utils;

public class CreateRandomNumber {

	private static int GenerateRandomNumber(int min, int max) {

		int x = (int) Math.floor(Math.random() * (max - min + 1) + min);

		return x;

	}
	
	public static String generateNewEmail(String email) {
		
		String[] emailStr=email.split("@");
		int randomx=CreateRandomNumber.GenerateRandomNumber(200,500);
		email=emailStr[0].concat("+").concat(String.valueOf(randomx)).concat("@").concat(emailStr[1]);
		
		return email;
	}
	
	
	

}

package cc.openhome;

public class Assert {
	public static void assertEquals(int expected, int result) {
        if(expected == result) {
            System.out.println("���T�I");
        } else {
            System.out.printf("���ѡA�w���� %d�A���O�Ǧ^ %d�I%n", expected, result);
        }
    }
}

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hurtFinger = Integer.parseInt(br.readLine());
		long hurtFingerLife = Long.parseLong(br.readLine());
		final int oneWayCount = 4;
		final int Thumb = 1;
		final int littleFinger = 5;

		long baseCount = hurtFingerLife * oneWayCount;
		long totalCount = 0;

		if (hurtFinger == Thumb)
			totalCount = baseCount * 2;
		else if (hurtFinger == littleFinger)
			totalCount = baseCount * 2 + oneWayCount;
		else if (hurtFingerLife % 2 == 0)
			totalCount = baseCount + hurtFinger - 1;
		else if (hurtFingerLife % 2 == 1)
			totalCount = baseCount + 5 - hurtFinger;

		System.out.print(totalCount);
	}
}

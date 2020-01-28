package dicezied;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dicegame {
	static int ex1(Pattern pattern, String string) {
		Matcher matcher = pattern.matcher(string);

		int count = 0;
		int pos = 0;

		while (matcher.find(pos)) {
			count++;
			pos = matcher.start() + 1;

		}
		return count;
	}

	public boolean exist(String str) {
		if (str.indexOf("6") == -1) {
			return false;
		} else {
			return true;
		}
	}

	public List<String> exMots(String str) {
		List<String> ext = new ArrayList<>();
		String mot = "";
		String newPh = "";

		int pos = 0;
		while (exist(str)) {
			pos = str.indexOf("6");
			mot = str.substring(0, pos);
			newPh = str.substring(pos + 1, str.length());
			str = newPh;
			if (mot.equals("")) {
				mot = "0";

			}
			ext.add(mot);
			ext.remove("0");

		}
		if (ext.size() != 0) {
			ext.remove(ext.get(0));
		}

		return ext;
	}

	List<Integer> chiffre(Long nb) {
		List<Integer> output = new ArrayList<>();
		String cv = String.valueOf(nb);
		for (int i = 0; i < cv.length(); i++) {
			output.add(Character.getNumericValue(cv.charAt(i)));

		}

		return output;

	}
	
	public Long ex2(List<Long> input) {

		List<Integer> ch = new ArrayList<>();
		Dicegame dice = new Dicegame();
		Long rlt = new Long(0);
		long maxRun = 0;
		for (int i = 1; i < input.size(); i++) {
			ch = dice.chiffre(input.get(i));

			if (i < ch.size() && ch.get(i - 1) + 1 == ch.get(i)) {

				maxRun++;

			}

		}
		return maxRun;

	}

	long ex3(List<Long> nb) {

		long rlt = 0;
		long t = 0;
		for (int i = 1; i < nb.size() - 1; i++) {
			if (nb.get(i) == nb.get(i + 1) && nb.size() == 10) {
				rlt = nb.get(i) + nb.get(i + 1);
			}
		}
		for (int j = 0; j > nb.size(); j--) {
			if (nb.get(j) == nb.get(j + 1) && nb.size() == 10) {
				t = nb.get(j) + nb.get(j + 1);
			}
		}
		if (t > rlt) {
			return t;
		} else {
			return rlt;
		}

	}

	public int ex4(List<Long> input) {
		Dicegame zz = new Dicegame();
		int j = 0;
		List<Integer> ch = new ArrayList<>();
		List<Integer> luc = new ArrayList<>();
		for (int i = 0; i < input.size() - 2; i++) {
			j = i + 1;
			ch = zz.chiffre(input.get(i));
			if (ch.get(i) == 6 || ch.get(i) == 5 && ch.get(i) == ch.get(j) && ch.get(j) == ch.get(j + 1)) {

				luc.add(ch.get(i));

			}
		}

		return luc.size();
	}



	public static void main(String... ignored) {
		List<Long> rlt = new ArrayList<>();
		int valeurMin = 1;
		int valeurMax = 100;
		int valeurMin2 = 1;
		int valeurMax2 = 7;
		int v = 0;
		String w = "";
		Random r = new Random();
		int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);
		//System.out.println(valeur);
		for (int i = 0; i < valeur; i++) {
			Random x = new Random();
			v = valeurMin2 + x.nextInt(valeurMax2 - valeurMin2);
			w = w + v;
		}
		//System.out.println(w);
		Pattern pattern = Pattern.compile("66");
		int count = ex1(pattern, w);

		Pattern pattern1 = Pattern.compile("6|5");
		int count1 = ex1(pattern, w);

		System.err.println("\n ex 1 \t nember of 6S =" + count);

		Dicegame dice = new Dicegame();

		for (int i = 0; i < dice.exMots(w).size(); i++) {
			rlt.add(Long.valueOf(dice.exMots(w).get(i)));
		}
		
		System.err.println("\n ex 2 \t Consecutive " + dice.ex2(rlt));
		System.err.println("\n ex 3 \t max value of sub sequence  " + dice.ex3(rlt));

		if (count1 > 3) {
			System.err.println("\n ex 4 \t  Lucky substring =" + count1);
		} else {
			System.err.println("\n ex 4 \t  Lucky substring =" + 0);

		}

	}


}
